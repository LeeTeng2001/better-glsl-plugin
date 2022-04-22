package glsl.language.psi.impl.access;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import glsl.language.psi.GlslNamedElement;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedVariableTypeImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedVariableTypeImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();

        // Find reference to either function or struct
        var myText = getText();
        var definedStruct = GlslUtil.findDefinedStruct(getContainingFile());

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
