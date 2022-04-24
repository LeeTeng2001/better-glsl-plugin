// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface GlslExpressionAssign extends PsiElement {

  @Nullable
  GlslAssignOp getAssignOp();

  @Nullable
  GlslExpressionAssign getExpressionAssign();

  @Nullable
  GlslExpressionAssignParen getExpressionAssignParen();

  @Nullable
  GlslExpressionNoAssign getExpressionNoAssign();

}
