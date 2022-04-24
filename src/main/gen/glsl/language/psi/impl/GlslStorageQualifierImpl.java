// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslLayoutQualifier;
import glsl.language.psi.GlslStorageQualifier;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslStorageQualifierImpl extends ASTWrapperPsiElement implements GlslStorageQualifier {

  public GlslStorageQualifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitStorageQualifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslLayoutQualifier getLayoutQualifier() {
    return findChildByClass(GlslLayoutQualifier.class);
  }

}
