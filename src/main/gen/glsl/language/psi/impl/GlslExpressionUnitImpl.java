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

public class GlslExpressionUnitImpl extends ASTWrapperPsiElement implements GlslExpressionUnit {

  public GlslExpressionUnitImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitExpressionUnit(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslFunctionCall getFunctionCall() {
    return findChildByClass(GlslFunctionCall.class);
  }

  @Override
  @Nullable
  public GlslMemberAccessHead getMemberAccessHead() {
    return findChildByClass(GlslMemberAccessHead.class);
  }

  @Override
  @Nullable
  public GlslUnaryBackOp getUnaryBackOp() {
    return findChildByClass(GlslUnaryBackOp.class);
  }

  @Override
  @Nullable
  public GlslUnaryFrontOp getUnaryFrontOp() {
    return findChildByClass(GlslUnaryFrontOp.class);
  }

}
