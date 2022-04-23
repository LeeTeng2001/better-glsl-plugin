// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslIdentifierType;
import glsl.language.psi.GlslVarNameType;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslIdentifierTypeImpl extends ASTWrapperPsiElement implements GlslIdentifierType {

  public GlslIdentifierTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitIdentifierType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslVarNameType getVarNameType() {
    return findChildByClass(GlslVarNameType.class);
  }

}
