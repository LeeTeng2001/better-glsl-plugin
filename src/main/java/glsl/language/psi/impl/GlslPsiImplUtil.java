package glsl.language.psi.impl;

import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslNamedElement;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;

public class GlslPsiImplUtil {
    public static PsiElement getNameIdentifier(GlslNamedElement element) {
        // A declaration must have a name node.
        var nameNode = element.getNode();
        return nameNode != null ? nameNode.getPsi() : null;
    }

    public static String getName(GlslNamedElement element) {
        var idNode = getNameIdentifier(element);
        return idNode != null ? idNode.getText() : null;
    }

    public static PsiElement setName(GlslNamedElement element, String newName) {
        System.out.println("Set name");
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

    // function specific ----------------------------------------------------------------------------
    // get return, get argument
//    public static PsiElement get

    // struct specific ----------------------------------------------------------------------------
    // get all member

    // variable specific ----------------------------------------------------------------------------
    // Access, type, function
}
