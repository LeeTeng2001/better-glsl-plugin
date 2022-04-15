// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import glsl.language.psi.impl.*;

public interface GlslTypes {

  IElementType PROPERTY = new GlslElementType("PROPERTY");

  IElementType COMMENT = new GlslTokenType("COMMENT");
  IElementType CRLF = new GlslTokenType("CRLF");
  IElementType KEY = new GlslTokenType("KEY");
  IElementType SEPARATOR = new GlslTokenType("SEPARATOR");
  IElementType VALUE = new GlslTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new GlslPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
