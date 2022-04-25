package glsl.language.psi.impl.access;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedVariableAccessFuncImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableAccessFuncImpl(@NotNull ASTNode node) {
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

        // Find reference to either defined function
        var myText = getText();
        var definedVariables = GlslUtil.findDefinedFunctions(getContainingFile(), getTextOffset());

        // Remember to check scope!
        for (var variable : definedVariables) {
            if (variable.textMatches(myText)) {
                return variable.getReference();
            }
        }

        return references.length > 0 ? references[0] : null;
    }

}
