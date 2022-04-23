// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslArithmeticOp;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

public class GlslArithmeticOpImpl extends ASTWrapperPsiElement implements GlslArithmeticOp {

  public GlslArithmeticOpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitArithmeticOp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

}
