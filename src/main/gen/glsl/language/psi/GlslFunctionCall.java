// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface GlslFunctionCall extends PsiElement {

  @NotNull
  List<GlslExpressionNoAssign> getExpressionNoAssignList();

  @NotNull
  GlslVarNameAccessFunc getVarNameAccessFunc();

}
