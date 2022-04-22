package glsl.language.psi.impl.origin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiCompiledElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.tree.IElementType;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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

    public ArrayList<Pair<IElementType, String>> getMembers() {
        var allMembers = new ArrayList<Pair<IElementType, String>>();
        var findMembers = getParent().getChildren();

        for (var element : findMembers) {
            if (element.getNode().getElementType().equals(GlslTypes.VARIABLE_DEFINITION)) {
                var memberType = element.getNode().findChildByType(GlslTypes.IDENTIFIER_TYPE);
                var memberId = element.getNode().findChildByType(GlslTypes.VAR_NAME_ORIGIN_VARIABLE);
                allMembers.add(new Pair<>(memberType == null ? GlslTypes.NULL_TOKEN : memberType.getElementType(),
                                        memberId == null ? "" : memberId.getText()));
            }
        }

        return allMembers;
    }
}
