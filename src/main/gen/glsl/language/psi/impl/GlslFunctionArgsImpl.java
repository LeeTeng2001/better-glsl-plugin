// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslFunctionArgs;
import glsl.language.psi.GlslIdentifierType;
import glsl.language.psi.GlslVarNameOriginVariable;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslFunctionArgsImpl extends ASTWrapperPsiElement implements GlslFunctionArgs {

  public GlslFunctionArgsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitFunctionArgs(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
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
  public GlslVarNameOriginVariable getVarNameOriginVariable() {
    return findNotNullChildByClass(GlslVarNameOriginVariable.class);
  }

}
