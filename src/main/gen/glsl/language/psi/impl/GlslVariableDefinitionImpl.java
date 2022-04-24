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

public class GlslVariableDefinitionImpl extends ASTWrapperPsiElement implements GlslVariableDefinition {

  public GlslVariableDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitVariableDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GlslIdentifierType getIdentifierType() {
    return findNotNullChildByClass(GlslIdentifierType.class);
  }

  @Override
  @NotNull
  public List<GlslInitVal> getInitValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslInitVal.class);
  }

  @Override
  @Nullable
  public GlslStorageQualifier getStorageQualifier() {
    return findChildByClass(GlslStorageQualifier.class);
  }

  @Override
  @NotNull
  public List<GlslVarNameOriginVariable> getVarNameOriginVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslVarNameOriginVariable.class);
  }

}
