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

public class GlslFunctionDefinitionImpl extends ASTWrapperPsiElement implements GlslFunctionDefinition {

  public GlslFunctionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GlslVisitor visitor) {
    visitor.visitFunctionDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GlslVisitor) accept((GlslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GlslDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslDeclaration.class);
  }

  @Override
  @NotNull
  public List<GlslExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslExpression.class);
  }

  @Override
  @Nullable
  public GlslFunctionArgs getFunctionArgs() {
    return findChildByClass(GlslFunctionArgs.class);
  }

  @Override
  @NotNull
  public GlslIdentifierType getIdentifierType() {
    return findNotNullChildByClass(GlslIdentifierType.class);
  }

  @Override
  @NotNull
  public List<GlslMacro> getMacroList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslMacro.class);
  }

  @Override
  @NotNull
  public List<GlslStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GlslStatement.class);
  }

  @Override
  @NotNull
  public GlslVarNameOriginFunc getVarNameOriginFunc() {
    return findNotNullChildByClass(GlslVarNameOriginFunc.class);
  }

}
