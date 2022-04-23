// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface GlslMemberAccess extends PsiElement {

  @NotNull
  List<GlslVarNameAccessMember> getVarNameAccessMemberList();

  @NotNull
  GlslVarNameAccessVar getVarNameAccessVar();

}
