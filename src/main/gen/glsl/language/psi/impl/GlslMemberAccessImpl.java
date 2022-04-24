// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslMemberAccess;
import glsl.language.psi.GlslVarNameAccessVar;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslMemberAccessImpl extends ASTWrapperPsiElement implements GlslMemberAccess {

  public GlslMemberAccessImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitMemberAccess(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslMemberAccess getMemberAccess() {
    return findChildByClass(GlslMemberAccess.class);
  }

  @Override
  @NotNull
  public GlslVarNameAccessVar getVarNameAccessVar() {
    return findNotNullChildByClass(GlslVarNameAccessVar.class);
  }

}
