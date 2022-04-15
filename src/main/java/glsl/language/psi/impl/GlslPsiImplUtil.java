package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslProperty;
import glsl.language.psi.GlslTypes;

public class GlslPsiImplUtil {
    public static PsiElement getStructDef(GlslProperty element) {
        ASTNode node = element.getNode().findChildByType(GlslTypes.STRUCT_DEFINITION);
        return node != null ? node.getPsi() : null;
    }

    public static PsiElement getVariableDef(GlslProperty element) {
        ASTNode node = element.getNode().findChildByType(GlslTypes.VARIABLE_DEFINITION);
        return node != null ? node.getPsi() : null;
    }

    public static PsiElement getIdentifier(GlslProperty element) {
        ASTNode node = element.getNode().findChildByType(GlslTypes.IDENTIFIER);
        return node != null ? node.getPsi() : null;
    }
}
