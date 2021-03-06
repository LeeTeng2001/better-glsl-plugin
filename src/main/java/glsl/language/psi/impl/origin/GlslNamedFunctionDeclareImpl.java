package glsl.language.psi.impl.origin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedFunctionDeclareImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedFunctionDeclareImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();
        return references.length > 0 ? references[0] : null;
    }
}
