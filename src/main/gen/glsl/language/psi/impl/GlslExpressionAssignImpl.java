// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslExpressionAssignImpl extends ASTWrapperPsiElement implements GlslExpressionAssign {

  public GlslExpressionAssignImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitExpressionAssign(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslAssignOp getAssignOp() {
    return findChildByClass(GlslAssignOp.class);
  }

  @Override
  @Nullable
  public GlslExpressionAssign getExpressionAssign() {
    return findChildByClass(GlslExpressionAssign.class);
  }

  @Override
  @Nullable
  public GlslExpressionAssignParen getExpressionAssignParen() {
    return findChildByClass(GlslExpressionAssignParen.class);
  }

  @Override
  @Nullable
  public GlslExpressionNoAssign getExpressionNoAssign() {
    return findChildByClass(GlslExpressionNoAssign.class);
  }

}
