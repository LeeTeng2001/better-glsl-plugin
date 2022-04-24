package glsl.language.psi.impl.access;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedVariableAccessMemberImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableAccessMemberImpl(@NotNull ASTNode node) {
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
//        var myText = getText();
//        var parent = getParent().getParent(); // shouldn't crash since it's valid context
//
//        // If our parent is top most, it's a variable access
//        if (!parent.getNode().getElementType().equals(GlslTypes.MEMBER_ACCESS)) {
//            return GlslNamedVariableAccessVarImpl.getReferenceVarAccess(references, myText, this);
//        }

        // TODO: Otherwise, we need to resolve member usage

        return references.length > 0 ? references[0] : null;
    }

}
