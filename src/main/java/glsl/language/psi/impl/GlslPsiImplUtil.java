package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslTypes;

public class GlslPsiImplUtil {
    public static PsiElement getStructDef(GlslDeclaration element) {
        ASTNode node = element.getNode().findChildByType(GlslTypes.STRUCT_DEFINITION);
        return node != null ? node.getPsi() : null;
    }

    public static PsiElement getVariableDef(GlslDeclaration element) {
        ASTNode node = element.getNode().findChildByType(GlslTypes.VARIABLE_DEFINITION);
        return node != null ? node.getPsi() : null;
    }

//    public static PsiElement getIdentifier(GlslProperty element) {
//        ASTNode node = element.getNode().findChildByType(GlslTypes.IDENTIFIER);
//        return node != null ? node.getPsi() : null;
//    }
    public static PsiElement getNameIdentifier(GlslDeclaration element) {
        ASTNode keyNode = element.getNode().getFirstChildNode().getTreeNext();
        System.out.println("NAME IDENTIFIER NODE!");
        System.out.println(element);
        System.out.println(element.getNode());
        System.out.println(keyNode);
        return keyNode != null ? keyNode.getPsi() : null;
    }

    public static String getName(GlslDeclaration element) {
        var defNameNode = getNameIdentifier(element);
        return defNameNode != null ? defNameNode.getText() : null;
    }

    public static PsiElement setName(GlslDeclaration element, String newName) {
        var defNamePsi = getNameIdentifier(element);
        var defNameNode = defNamePsi != null ? defNamePsi.getNode() : null;
        if (defNameNode != null) {
            GlslDeclaration property = GlslElementFactory.createDeclaration(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(defNameNode, newKeyNode);
        }
        return element;
    }
}
