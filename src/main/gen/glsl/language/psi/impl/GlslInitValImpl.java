// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslInitVal;
import glsl.language.psi.GlslInitializer;
import glsl.language.psi.GlslMemberAccess;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

  @Override
  @Nullable
  public GlslInitializer getInitializer() {
    return findChildByClass(GlslInitializer.class);
  }

  @Override
  @Nullable
  public GlslMemberAccess getMemberAccess() {
    return findChildByClass(GlslMemberAccess.class);
  }

}
