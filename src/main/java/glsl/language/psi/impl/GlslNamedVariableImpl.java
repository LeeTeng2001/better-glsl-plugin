package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedVariableImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();

        // Return self for definition that doesn't reference to other
        var parentType = getParent().getNode().getElementType();
        if (!parentType.equals(GlslTypes.IDENTIFIER_TYPE)) {
            return references.length > 0 ? references[0] : null;
        }

        // Find reference to either function or struct
        var myText = getText();
        var definedStruct = GlslUtil.findDefinedStruct(getProject());

        for (var struct : definedStruct) {
            var structName = struct.getText();
            if (structName == null) continue;
            if (structName.equals(myText)) {
//                System.out.println(name + " " + structName.getReference());
                return struct.getReference();
            }
        }

        return references.length > 0 ? references[0] : null;
    }


}
