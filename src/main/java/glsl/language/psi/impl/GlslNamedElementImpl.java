package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiMultiReference;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class GlslNamedElementImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public PsiReference getReference() {
        final PsiReference[] references = getReferences();
        var node = references[0].getElement().getNode();
        var declareNode = node.getFirstChildNode();

        // If we're struct we are the only reference
        if (declareNode.getElementType().equals(GlslTypes.STRUCT_DEFINITION)) {
//            System.out.println("This is struct");
            return references[0];
        }

        // If we're identifier, out type can point to a struct declaration
        if (declareNode.getElementType().equals(GlslTypes.VARIABLE_DEFINITION)) {
//            System.out.println("This is variable");
            var idNode = declareNode.findChildByType(GlslTypes.IDENTIFIER_TYPE).getText();
            var definedStruct = GlslUtil.findDefinedStruct(declareNode.getPsi().getProject());

            for (var struct : definedStruct) {
                var name = struct.getName();
                if (name.equals(idNode)) {
                    System.out.println(name);
                    return struct.getReference();
                }
            }
        }

        return null;
    }
}
