// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface GlslStructDefinition extends PsiElement {

  @Nullable
  GlslVarNameOriginStruct getVarNameOriginStruct();

  @NotNull
  List<GlslVariableDefinition> getVariableDefinitionList();

}
