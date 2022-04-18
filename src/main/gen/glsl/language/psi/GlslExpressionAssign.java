// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GlslExpressionAssign extends PsiElement {

  @Nullable
  GlslAssignOp getAssignOp();

  @Nullable
  GlslExpressionAssign getExpressionAssign();

  @NotNull
  GlslExpressionNoAssign getExpressionNoAssign();

}
