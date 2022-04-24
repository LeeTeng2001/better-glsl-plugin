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

public class GlslStructDefinitionImpl extends ASTWrapperPsiElement implements GlslStructDefinition {

  public GlslStructDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitStructDefinition(this);
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

  @Override
  @Nullable
  public GlslVarNameOriginStruct getVarNameOriginStruct() {
    return findChildByClass(GlslVarNameOriginStruct.class);
  }

  @Override
  @NotNull
  public List<GlslVariableDefinition> getVariableDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslVariableDefinition.class);
  }

}
