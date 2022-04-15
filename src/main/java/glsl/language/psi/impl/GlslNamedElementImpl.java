package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import glsl.language.psi.GlslNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedElementImpl extends ASTWrapperPsiElement implements GlslNamedElement {
    public GlslNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
