// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import glsl.language.psi.impl.*;

public interface GlslTypes {

  IElementType DECLARATION = new GlslElementType("DECLARATION");
  IElementType FUNCTION_ARGS = new GlslElementType("FUNCTION_ARGS");
  IElementType FUNCTION_DEFINITION = new GlslElementType("FUNCTION_DEFINITION");
  IElementType IDENTIFIER_TYPE = new GlslElementType("IDENTIFIER_TYPE");
  IElementType STORAGE_QUALIFIER = new GlslElementType("STORAGE_QUALIFIER");
  IElementType STRUCT_DEFINITION = new GlslElementType("STRUCT_DEFINITION");
  IElementType SWIZZLE_ACCESS = new GlslElementType("SWIZZLE_ACCESS");
  IElementType SWIZZLE_PROP = new GlslElementType("SWIZZLE_PROP");
  IElementType VARIABLE_DEFINITION = new GlslElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_VAL = new GlslElementType("VARIABLE_VAL");

  IElementType A = new GlslTokenType("a");
  IElementType ATTRIBUTE = new GlslTokenType("attribute");
  IElementType B = new GlslTokenType("b");
  IElementType BOOL = new GlslTokenType("bool");
  IElementType BUFFER = new GlslTokenType("buffer");
  IElementType COMMA = new GlslTokenType("COMMA");
  IElementType COMMENT = new GlslTokenType("COMMENT");
  IElementType CONST = new GlslTokenType("const");
  IElementType CRLF = new GlslTokenType("CRLF");
  IElementType C_BRACKET_L = new GlslTokenType("C_BRACKET_L");
  IElementType C_BRACKET_R = new GlslTokenType("C_BRACKET_R");
  IElementType DOT = new GlslTokenType("DOT");
  IElementType DOUBLE = new GlslTokenType("double");
  IElementType FLOAT = new GlslTokenType("float");
  IElementType FLOAT_CONSTANT = new GlslTokenType("FLOAT_CONSTANT");
  IElementType G = new GlslTokenType("g");
  IElementType IDENTIFIER = new GlslTokenType("IDENTIFIER");
  IElementType IN = new GlslTokenType("in");
  IElementType INT = new GlslTokenType("int");
  IElementType INTEGER_CONSTANT = new GlslTokenType("INTEGER_CONSTANT");
  IElementType OPERATOR_ASSIGNMENT = new GlslTokenType("OPERATOR_ASSIGNMENT");
  IElementType OUT = new GlslTokenType("out");
  IElementType P = new GlslTokenType("p");
  IElementType PAREN_L = new GlslTokenType("PAREN_L");
  IElementType PAREN_R = new GlslTokenType("PAREN_R");
  IElementType Q = new GlslTokenType("q");
  IElementType R = new GlslTokenType("r");
  IElementType S = new GlslTokenType("s");
  IElementType SEMICOLON = new GlslTokenType("SEMICOLON");
  IElementType SHARED = new GlslTokenType("shared");
  IElementType STRUCT = new GlslTokenType("struct");
  IElementType T = new GlslTokenType("t");
  IElementType UINT = new GlslTokenType("uint");
  IElementType UNIFORM = new GlslTokenType("uniform");
  IElementType VARYING = new GlslTokenType("varying");
  IElementType VOID = new GlslTokenType("void");
  IElementType W = new GlslTokenType("w");
  IElementType X = new GlslTokenType("x");
  IElementType Y = new GlslTokenType("y");
  IElementType Z = new GlslTokenType("z");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DECLARATION) {
        return new GlslDeclarationImpl(node);
      }
      else if (type == FUNCTION_ARGS) {
        return new GlslFunctionArgsImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new GlslFunctionDefinitionImpl(node);
      }
      else if (type == IDENTIFIER_TYPE) {
        return new GlslIdentifierTypeImpl(node);
      }
      else if (type == STORAGE_QUALIFIER) {
        return new GlslStorageQualifierImpl(node);
      }
      else if (type == STRUCT_DEFINITION) {
        return new GlslStructDefinitionImpl(node);
      }
      else if (type == SWIZZLE_ACCESS) {
        return new GlslSwizzleAccessImpl(node);
      }
      else if (type == SWIZZLE_PROP) {
        return new GlslSwizzlePropImpl(node);
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
