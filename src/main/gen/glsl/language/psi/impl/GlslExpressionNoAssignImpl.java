// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static glsl.language.psi.GlslTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import glsl.language.psi.*;

public class GlslExpressionNoAssignImpl extends ASTWrapperPsiElement implements GlslExpressionNoAssign {

  public GlslExpressionNoAssignImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitExpressionNoAssign(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslArithmeticOp getArithmeticOp() {
    return findChildByClass(GlslArithmeticOp.class);
  }

  @Override
  @Nullable
  public GlslExpressionNoAssign getExpressionNoAssign() {
    return findChildByClass(GlslExpressionNoAssign.class);
  }

  @Override
  @Nullable
  public GlslExpressionNoAssignParen getExpressionNoAssignParen() {
    return findChildByClass(GlslExpressionNoAssignParen.class);
  }

  @Override
  @Nullable
  public GlslExpressionUnit getExpressionUnit() {
    return findChildByClass(GlslExpressionUnit.class);
  }

  @Override
  @Nullable
  public GlslRelationalOp getRelationalOp() {
    return findChildByClass(GlslRelationalOp.class);
  }

}
