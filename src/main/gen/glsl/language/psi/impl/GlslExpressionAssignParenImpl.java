// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslExpressionAssign;
import glsl.language.psi.GlslExpressionAssignParen;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

public class GlslExpressionAssignParenImpl extends ASTWrapperPsiElement implements GlslExpressionAssignParen {

  public GlslExpressionAssignParenImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitExpressionAssignParen(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GlslExpressionAssign getExpressionAssign() {
    return findNotNullChildByClass(GlslExpressionAssign.class);
  }

}
