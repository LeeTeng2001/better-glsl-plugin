// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GlslStatementFor extends PsiElement {

  @NotNull
  List<GlslDeclaration> getDeclarationList();

  @NotNull
  List<GlslExpression> getExpressionList();

  @NotNull
  GlslIdentifierType getIdentifierType();

  @NotNull
  List<GlslMacro> getMacroList();

  @NotNull
  GlslRelationalOp getRelationalOp();

  @NotNull
  List<GlslStatement> getStatementList();

  @NotNull
  List<GlslUnarySignOp> getUnarySignOpList();

  @NotNull
  List<GlslVarNameAccessVar> getVarNameAccessVarList();

  @NotNull
  GlslVarNameOriginVariable getVarNameOriginVariable();

}
