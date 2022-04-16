package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.psi.GlslVariableDefinition;

public class GlslPsiImplUtil {
    public static PsiElement getNameIdentifier(GlslDeclaration element) {
        // A declaration must have a name node.
        var nameNode = element.getNode().getFirstChildNode();
        return nameNode != null ? nameNode.getPsi() : null;
    }

    public static String getName(GlslDeclaration element) {
        var idNode = getNameIdentifier(element);
        if (idNode == null) return null;
        var name = idNode.getNode().findChildByType(GlslTypes.IDENTIFIER);
        return name != null ? name.getText() : null;
    }

    public static PsiElement setName(GlslDeclaration element, String newName) {
//        var defNamePsi = getNameIdentifier(element);
//        var defNameNode = defNamePsi != null ? defNamePsi.getNode() : null;
//        if (defNameNode != null) {
//            PsiElementFactory factory = element.getContainingFile().getManager().getEl;
//            GlslDeclaration property = GlslElementFactory.createDeclaration(element.getProject(), newName);
//            ASTNode newKeyNode = property.getFirstChild().getNode();
//            element.getNode().replaceChild(defNameNode, newKeyNode);
//        }
        return element;
    }
}
