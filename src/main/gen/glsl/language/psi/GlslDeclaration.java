// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GlslDeclaration extends GlslNamedElement {

  @Nullable
  GlslStructDefinition getStructDefinition();

  @Nullable
  GlslVariableDefinition getVariableDefinition();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiElement getStructDef();

  PsiElement getVariableDef();

}
