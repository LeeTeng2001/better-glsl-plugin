package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedIdentifierTypeImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedIdentifierTypeImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();
        if (references.length == 0) {
            System.out.println("No reference");
            return null;
        }
        var idNode = references[0].getElement().getNode().getFirstChildNode();

        // If we're identifier type, out type can point to a struct declaration
        if (idNode.getElementType().equals(GlslTypes.IDENTIFIER)) {
            var idText = idNode.getText();
            var definedStruct = GlslUtil.findDefinedStruct(idNode.getPsi().getProject());

            for (var struct : definedStruct) {
                var name = struct.getName();
                if (name == null) return null;
                if (name.equals(idText)) {
//                    System.out.println(name + " " + struct.getReference());
                    return struct.getReference();
                }
            }
        }

        return null;
    }
}
