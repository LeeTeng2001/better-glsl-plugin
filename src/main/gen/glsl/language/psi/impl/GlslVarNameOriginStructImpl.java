// This is a generated file. Not intended for manual editing.
package glsl.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static glsl.language.psi.GlslTypes.*;
import glsl.language.psi.impl.origin.GlslNamedStructDeclareImpl;
import glsl.language.psi.*;

public class GlslVarNameOriginStructImpl extends GlslNamedStructDeclareImpl implements GlslVarNameOriginStruct {

  public GlslVarNameOriginStructImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitVarNameOriginStruct(this);
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
