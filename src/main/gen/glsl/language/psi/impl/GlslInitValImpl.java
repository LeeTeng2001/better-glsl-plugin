// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslInitVal;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

public class GlslInitValImpl extends ASTWrapperPsiElement implements GlslInitVal {

  public GlslInitValImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitInitVal(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

}
