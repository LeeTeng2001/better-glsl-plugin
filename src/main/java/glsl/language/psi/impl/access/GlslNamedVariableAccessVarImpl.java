package glsl.language.psi.impl.access;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileChooser.FileElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static glsl.language.psi.GlslTypes.*;
import static glsl.language.psi.GlslTypes.STATEMENT_FOR;

public abstract class GlslNamedVariableAccessVarImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableAccessVarImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    // Resolve usage origin (for access, not type specification)
    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();
        var myText = getText();
        return getReferenceVarAccess(references, myText, this);
    }

    public static PsiReference getReferenceVarAccess(final PsiReference[] references, String fromText, PsiElement fromNode) {
        var definedVariables = GlslUtil.findDefinedVariables(fromNode.getContainingFile(), fromNode.getTextOffset());

        // check candidates
        var candidates = new ArrayList<PsiElement>();
        for (var variable : definedVariables) {
            var name = variable.getText();
            if (name == null) continue;
            if (name.equals(fromText)) {
                candidates.add(variable);
            }
        }

        // special case
        if (candidates.isEmpty())  return references.length > 0 ? references[0] : null;
        else if (candidates.size() == 1) return candidates.get(0).getReference();

        // Check scope starting from access node the closest scope
        PsiElement accessScope = getClosestScope(fromNode);
        while (accessScope != null) {
            for (var candidate : candidates) {
                var candScope = getClosestScope(candidate);
                if (candScope == accessScope)
                    return candidate.getReference();  // same scope, have a match
            }
            accessScope = getClosestScope(accessScope.getParent());  // if no match, ascend to find next closest scope
        }

        // Base case, if we cannot find any candidate in scope, or we're null, our only match must be at the global scope
        return candidates.get(0).getReference();
    }

    private static final Set<IElementType> VARIABLE_SCOPES = Stream.of(
            FUNCTION_DEFINITION,
            STRUCT_DEFINITION,
            STATEMENT_IF,
            STATEMENT_ELSE,
            STATEMENT_SWITCH,
            STATEMENT_DO_WHILE,
            STATEMENT_WHILE_NORMAL,
            STATEMENT_FOR
    ).collect(Collectors.toUnmodifiableSet());

    public static PsiElement getClosestScope(PsiElement startFrom) {
        while (startFrom != null) {
            var node = startFrom.getNode();
            if (node == null) return null;
            if (VARIABLE_SCOPES.contains(node.getElementType()))
                break;
            startFrom = startFrom.getParent();
        }

        return startFrom;
    }
}
