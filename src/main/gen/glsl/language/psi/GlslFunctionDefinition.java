// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
  List<GlslMacro> getMacroList();

  @NotNull
  List<GlslStatement> getStatementList();

  @NotNull
  GlslVarNameOriginFunc getVarNameOriginFunc();

}
