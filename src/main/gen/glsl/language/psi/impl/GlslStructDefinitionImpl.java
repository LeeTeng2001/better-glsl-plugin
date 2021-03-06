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
  @Nullable
  public GlslVarNameOriginVariable getVarNameOriginVariable() {
    return findChildByClass(GlslVarNameOriginVariable.class);
  }

  @Override
  @NotNull
  public List<GlslVariableDefinition> getVariableDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslVariableDefinition.class);
  }

}
