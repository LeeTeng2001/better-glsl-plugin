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
  IElementType VARIABLE_DEFINITION = new GlslElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_VAL = new GlslElementType("VARIABLE_VAL");
  IElementType VAR_NAME = new GlslElementType("VAR_NAME");

  IElementType ATTRIBUTE = new GlslTokenType("attribute");
  IElementType BOOL = new GlslTokenType("bool");
  IElementType BUFFER = new GlslTokenType("buffer");
  IElementType COMMA = new GlslTokenType("COMMA");
  IElementType COMMENT = new GlslTokenType("COMMENT");
  IElementType CONST = new GlslTokenType("const");
  IElementType CRLF = new GlslTokenType("CRLF");
  IElementType C_BRACKET_L = new GlslTokenType("C_BRACKET_L");
  IElementType C_BRACKET_R = new GlslTokenType("C_BRACKET_R");
  IElementType DOUBLE = new GlslTokenType("double");
  IElementType FLOAT = new GlslTokenType("float");
  IElementType FLOAT_CONSTANT = new GlslTokenType("FLOAT_CONSTANT");
  IElementType IDENTIFIER = new GlslTokenType("IDENTIFIER");
  IElementType IN = new GlslTokenType("in");
  IElementType INT = new GlslTokenType("int");
  IElementType INTEGER_CONSTANT = new GlslTokenType("INTEGER_CONSTANT");
  IElementType OPERATOR_ASSIGNMENT = new GlslTokenType("OPERATOR_ASSIGNMENT");
  IElementType OUT = new GlslTokenType("out");
  IElementType PAREN_L = new GlslTokenType("PAREN_L");
  IElementType PAREN_R = new GlslTokenType("PAREN_R");
  IElementType SEMICOLON = new GlslTokenType("SEMICOLON");
  IElementType SHARED = new GlslTokenType("shared");
  IElementType STRUCT = new GlslTokenType("struct");
  IElementType UINT = new GlslTokenType("uint");
  IElementType UNIFORM = new GlslTokenType("uniform");
  IElementType VARYING = new GlslTokenType("varying");
  IElementType VOID = new GlslTokenType("void");

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
      else if (type == VARIABLE_DEFINITION) {
        return new GlslVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_VAL) {
        return new GlslVariableValImpl(node);
      }
      else if (type == VAR_NAME) {
        return new GlslVarNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
