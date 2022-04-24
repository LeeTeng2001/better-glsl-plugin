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
  public GlslVarNameAccessMember getVarNameAccessMember() {
    return findNotNullChildByClass(GlslVarNameAccessMember.class);
  }

  @Override
  @NotNull
  public List<GlslVarNameAccessVar> getVarNameAccessVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslVarNameAccessVar.class);
  }

}
