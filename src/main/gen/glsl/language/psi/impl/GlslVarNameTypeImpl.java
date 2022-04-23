// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import glsl.language.psi.GlslVarNameType;
import glsl.language.psi.GlslVisitor;
import glsl.language.psi.impl.access.GlslNamedVariableTypeImpl;
import org.jetbrains.annotations.NotNull;

public class GlslVarNameTypeImpl extends GlslNamedVariableTypeImpl implements GlslVarNameType {

  public GlslVarNameTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitVarNameType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
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

}
