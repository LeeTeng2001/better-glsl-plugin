// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.GlslMemberAccess;
import glsl.language.psi.GlslVarNameAccessMember;
import glsl.language.psi.GlslVarNameAccessVar;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
  @NotNull
  public List<GlslVarNameAccessMember> getVarNameAccessMemberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslVarNameAccessMember.class);
  }

  @Override
  @NotNull
  public GlslVarNameAccessVar getVarNameAccessVar() {
    return findNotNullChildByClass(GlslVarNameAccessVar.class);
  }

}
