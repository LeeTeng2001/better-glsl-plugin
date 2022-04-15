// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GlslVisitor extends PsiElementVisitor {

  public void visitDeclaration(@NotNull GlslDeclaration o) {
    visitNamedElement(o);
  }

  public void visitIdentifierType(@NotNull GlslIdentifierType o) {
    visitPsiElement(o);
  }

  public void visitStructDefinition(@NotNull GlslStructDefinition o) {
    visitPsiElement(o);
  }

  public void visitVariableDefinition(@NotNull GlslVariableDefinition o) {
    visitPsiElement(o);
  }

  public void visitVariableVal(@NotNull GlslVariableVal o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull GlslNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
