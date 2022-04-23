// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface GlslFunctionDefinition extends PsiElement {

  @NotNull
  List<GlslDeclaration> getDeclarationList();

  @NotNull
  List<GlslExpression> getExpressionList();

  @Nullable
  GlslFunctionArgs getFunctionArgs();

  @NotNull
  GlslIdentifierType getIdentifierType();

  @NotNull
  GlslVarNameOriginFunc getVarNameOriginFunc();

}
