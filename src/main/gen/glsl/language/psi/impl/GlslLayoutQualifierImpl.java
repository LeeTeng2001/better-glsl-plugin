// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.GlslLayoutQualifier;
import glsl.language.psi.GlslLayoutQualifierParam;
import glsl.language.psi.GlslVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GlslLayoutQualifierImpl extends ASTWrapperPsiElement implements GlslLayoutQualifier {

  public GlslLayoutQualifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitLayoutQualifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GlslLayoutQualifierParam> getLayoutQualifierParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslLayoutQualifierParam.class);
  }

}
