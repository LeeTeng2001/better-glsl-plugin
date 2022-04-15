// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static glsl.language.psi.GlslTypes.*;
import glsl.language.psi.*;

public class GlslDeclarationImpl extends GlslNamedElementImpl implements GlslDeclaration {

  public GlslDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslStructDefinition getStructDefinition() {
    return findChildByClass(GlslStructDefinition.class);
  }

  @Override
  @Nullable
  public GlslVariableDefinition getVariableDefinition() {
    return findChildByClass(GlslVariableDefinition.class);
  }

  @Override
  public String getName() {
    return GlslPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return GlslPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return GlslPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiElement getStructDef() {
    return GlslPsiImplUtil.getStructDef(this);
  }

  @Override
  public PsiElement getVariableDef() {
    return GlslPsiImplUtil.getVariableDef(this);
  }

}
