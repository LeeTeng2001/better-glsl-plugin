// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlslFunctionDefinitionImpl extends ASTWrapperPsiElement implements GlslFunctionDefinition {

  public GlslFunctionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitFunctionDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GlslDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslDeclaration.class);
  }

  @Override
  @NotNull
  public List<GlslExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslExpression.class);
  }

  @Override
  @Nullable
  public GlslFunctionArgs getFunctionArgs() {
    return findChildByClass(GlslFunctionArgs.class);
  }

  @Override
  @NotNull
  public GlslIdentifierType getIdentifierType() {
    return findNotNullChildByClass(GlslIdentifierType.class);
  }

  @Override
  @NotNull
  public GlslVarNameOriginFunc getVarNameOriginFunc() {
    return findNotNullChildByClass(GlslVarNameOriginFunc.class);
  }

}
