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

public class GlslStatementImpl extends ASTWrapperPsiElement implements GlslStatement {

  public GlslStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GlslStatementDoWhile getStatementDoWhile() {
    return findChildByClass(GlslStatementDoWhile.class);
  }

  @Override
  @Nullable
  public GlslStatementElse getStatementElse() {
    return findChildByClass(GlslStatementElse.class);
  }

  @Override
  @Nullable
  public GlslStatementFor getStatementFor() {
    return findChildByClass(GlslStatementFor.class);
  }

  @Override
  @Nullable
  public GlslStatementIf getStatementIf() {
    return findChildByClass(GlslStatementIf.class);
  }

  @Override
  @Nullable
  public GlslStatementSwitch getStatementSwitch() {
    return findChildByClass(GlslStatementSwitch.class);
  }

  @Override
  @Nullable
  public GlslStatementWhileNormal getStatementWhileNormal() {
    return findChildByClass(GlslStatementWhileNormal.class);
  }

}
