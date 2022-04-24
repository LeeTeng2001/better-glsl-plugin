package glsl.language.psi.impl.origin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedStructDeclareImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedStructDeclareImpl(@NotNull ASTNode node) {
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



//    public ArrayList<Pair<IElementType, String>> getMembers() {
//        var allMembers = new ArrayList<Pair<IElementType, String>>();
//        var findMembers = getParent().getChildren();
//
//        for (var element : findMembers) {
//            if (element.getNode().getElementType().equals(GlslTypes.VARIABLE_DEFINITION)) {
//                var memberType = element.getNode().findChildByType(GlslTypes.IDENTIFIER_TYPE);
//                var memberId = element.getNode().findChildByType(GlslTypes.VAR_NAME_ORIGIN_VARIABLE);
//                allMembers.add(new Pair<>(memberType == null ? GlslTypes.NULL_TOKEN : memberType.getElementType(),
//                                        memberId == null ? "" : memberId.getText()));
//            }
//        }
//
//        return allMembers;
//    }
}
