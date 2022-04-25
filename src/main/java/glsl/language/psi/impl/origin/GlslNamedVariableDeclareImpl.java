package glsl.language.psi.impl.origin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.tree.IElementType;
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
import static glsl.language.psi.impl.access.GlslNamedVariableAccessVarImpl.getClosestScope;

public abstract class GlslNamedVariableDeclareImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableDeclareImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();

        // Check redeclaration of same identifier node on variable
        var candidates = new ArrayList<PsiElement>();
        var myText = getText();
        var definedVariables = GlslUtil.findDefinedVariables(getContainingFile(), getTextOffset());

        for (var variable : definedVariables) {
            var name = variable.getText();
            if (name == null) continue;
            if (name.equals(myText)) {
                candidates.add(variable);
            }
        }

        // check scope
        if (!candidates.isEmpty()) {
            var myScope = getClosestScope(this);
            for (PsiElement candidate : candidates) {
                var candidateScope = getClosestScope(candidate);
                if (candidateScope == myScope)
                    return candidate.getReference();
            }
        }

        return references.length > 0 ? references[0] : null;
    }
}
