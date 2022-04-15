package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslProperty;
import glsl.language.psi.GlslTypes;

public class GlslPsiImplUtil {
    public static String getKey(GlslProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(GlslTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(GlslProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(GlslTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(GlslProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(GlslProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(GlslTypes.KEY);
        if (keyNode != null) {
            GlslProperty property =
                    GlslElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(GlslProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(GlslTypes.KEY);
        return keyNode != null ? keyNode.getPsi() : null;
    }

}
