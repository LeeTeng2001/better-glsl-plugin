// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GlslVariableDefinition extends PsiElement {

  @NotNull
  GlslIdentifierType getIdentifierType();

  @Nullable
  GlslInitVal getInitVal();

  @Nullable
  GlslStorageQualifier getStorageQualifier();

  @NotNull
  GlslVarNameOriginVariable getVarNameOriginVariable();

}
