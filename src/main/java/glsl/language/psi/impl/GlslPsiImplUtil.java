package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslTypes;

public class GlslPsiImplUtil {
    public static PsiElement getNameIdentifier(GlslDeclaration element) {
        // A declaration must have a name node.
        var defNode = element.getNode().getFirstChildNode();
        var nameNode = defNode.findChildByType(GlslTypes.IDENTIFIER);
        return nameNode != null ? nameNode.getPsi() : null;
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
