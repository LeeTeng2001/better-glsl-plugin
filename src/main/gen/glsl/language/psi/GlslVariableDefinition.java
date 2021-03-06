// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GlslVariableDefinition extends PsiElement {

  @NotNull
  GlslIdentifierType getIdentifierType();

  @NotNull
  List<GlslInitVal> getInitValList();

  @Nullable
  GlslStorageQualifier getStorageQualifier();

  @NotNull
  List<GlslVarNameOriginVariable> getVarNameOriginVariableList();

}
