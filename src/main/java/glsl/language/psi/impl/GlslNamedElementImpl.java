package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class GlslNamedElementImpl extends ASTWrapperPsiElement {
    public GlslNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
