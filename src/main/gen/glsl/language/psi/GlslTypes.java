// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import glsl.language.psi.impl.*;

public interface GlslTypes {

  IElementType DECLARATION = new GlslElementType("DECLARATION");
  IElementType IDENTIFIER_TYPE = new GlslElementType("IDENTIFIER_TYPE");
  IElementType STRUCT_DEFINITION = new GlslElementType("STRUCT_DEFINITION");
  IElementType VARIABLE_DEFINITION = new GlslElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_VAL = new GlslElementType("VARIABLE_VAL");

  IElementType BRACKET_L = new GlslTokenType("BRACKET_L");
  IElementType BRACKET_R = new GlslTokenType("BRACKET_R");
  IElementType COMMENT = new GlslTokenType("COMMENT");
  IElementType CRLF = new GlslTokenType("CRLF");
  IElementType FLOAT = new GlslTokenType("float");
  IElementType FLOAT_CONSTANT = new GlslTokenType("FLOAT_CONSTANT");
  IElementType IDENTIFIER = new GlslTokenType("IDENTIFIER");
  IElementType INT = new GlslTokenType("int");
  IElementType INTEGER_CONSTANT = new GlslTokenType("INTEGER_CONSTANT");
  IElementType OPERATOR_ASSIGNMENT = new GlslTokenType("OPERATOR_ASSIGNMENT");
  IElementType SEMICOLON = new GlslTokenType("SEMICOLON");
  IElementType STRUCT = new GlslTokenType("struct");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DECLARATION) {
        return new GlslDeclarationImpl(node);
      }
      else if (type == IDENTIFIER_TYPE) {
        return new GlslIdentifierTypeImpl(node);
      }
      else if (type == STRUCT_DEFINITION) {
        return new GlslStructDefinitionImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new GlslVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_VAL) {
        return new GlslVariableValImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
