// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.GlslExpressionNoAssign;
import glsl.language.psi.GlslIdentifierType;
import glsl.language.psi.GlslInitializer;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GlslInitializerImpl extends ASTWrapperPsiElement implements GlslInitializer {

  public GlslInitializerImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitInitializer(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GlslExpressionNoAssign> getExpressionNoAssignList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslExpressionNoAssign.class);
  }

  @Override
  @NotNull
  public GlslIdentifierType getIdentifierType() {
    return findNotNullChildByClass(GlslIdentifierType.class);
  }

}
