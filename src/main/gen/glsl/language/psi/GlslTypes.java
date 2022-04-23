// This is a generated file. Not intended for manual editing.
package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import glsl.language.psi.impl.*;

public interface GlslTypes {

  IElementType ARITHMETIC_OP = new GlslElementType("ARITHMETIC_OP");
  IElementType ASSIGN_OP = new GlslElementType("ASSIGN_OP");
  IElementType DECLARATION = new GlslElementType("DECLARATION");
  IElementType EXPRESSION = new GlslElementType("EXPRESSION");
  IElementType EXPRESSION_ASSIGN = new GlslElementType("EXPRESSION_ASSIGN");
  IElementType EXPRESSION_ASSIGN_PAREN = new GlslElementType("EXPRESSION_ASSIGN_PAREN");
  IElementType EXPRESSION_NO_ASSIGN = new GlslElementType("EXPRESSION_NO_ASSIGN");
  IElementType EXPRESSION_NO_ASSIGN_PAREN = new GlslElementType("EXPRESSION_NO_ASSIGN_PAREN");
  IElementType EXPRESSION_UNIT = new GlslElementType("EXPRESSION_UNIT");
  IElementType FUNCTION_ARGS = new GlslElementType("FUNCTION_ARGS");
  IElementType FUNCTION_CALL = new GlslElementType("FUNCTION_CALL");
  IElementType FUNCTION_DEFINITION = new GlslElementType("FUNCTION_DEFINITION");
  IElementType IDENTIFIER_TYPE = new GlslElementType("IDENTIFIER_TYPE");
  IElementType INIT_VAL = new GlslElementType("INIT_VAL");
  IElementType MEMBER_ACCESS = new GlslElementType("MEMBER_ACCESS");
  IElementType RELATIONAL_OP = new GlslElementType("RELATIONAL_OP");
  IElementType STORAGE_QUALIFIER = new GlslElementType("STORAGE_QUALIFIER");
  IElementType STRUCT_DEFINITION = new GlslElementType("STRUCT_DEFINITION");
  IElementType VARIABLE_DEFINITION = new GlslElementType("VARIABLE_DEFINITION");
  IElementType VAR_NAME_ACCESS_FUNC = new GlslElementType("VAR_NAME_ACCESS_FUNC");
  IElementType VAR_NAME_ACCESS_VAR = new GlslElementType("VAR_NAME_ACCESS_VAR");
  IElementType VAR_NAME_ORIGIN_FUNC = new GlslElementType("VAR_NAME_ORIGIN_FUNC");
  IElementType VAR_NAME_ORIGIN_STRUCT = new GlslElementType("VAR_NAME_ORIGIN_STRUCT");
  IElementType VAR_NAME_ORIGIN_VARIABLE = new GlslElementType("VAR_NAME_ORIGIN_VARIABLE");
  IElementType VAR_NAME_TYPE = new GlslElementType("VAR_NAME_TYPE");

  IElementType ADD_ASSIGN = new GlslTokenType("ADD_ASSIGN");
  IElementType AMPERSAND = new GlslTokenType("AMPERSAND");
  IElementType AND_ASSIGN = new GlslTokenType("AND_ASSIGN");
  IElementType AND_OP = new GlslTokenType("AND_OP");
  IElementType ANGLE_L = new GlslTokenType("ANGLE_L");
  IElementType ANGLE_R = new GlslTokenType("ANGLE_R");
  IElementType ATTRIBUTE = new GlslTokenType("attribute");
  IElementType BOOL = new GlslTokenType("bool");
  IElementType BUFFER = new GlslTokenType("buffer");
  IElementType CARET = new GlslTokenType("CARET");
  IElementType COMMA = new GlslTokenType("COMMA");
  IElementType COMMENT = new GlslTokenType("COMMENT");
  IElementType CONST = new GlslTokenType("const");
  IElementType CRLF = new GlslTokenType("CRLF");
  IElementType C_BRACKET_L = new GlslTokenType("C_BRACKET_L");
  IElementType C_BRACKET_R = new GlslTokenType("C_BRACKET_R");
  IElementType DASH = new GlslTokenType("DASH");
  IElementType DIV_ASSIGN = new GlslTokenType("DIV_ASSIGN");
  IElementType DOT = new GlslTokenType("DOT");
  IElementType DOUBLE = new GlslTokenType("double");
  IElementType EQUAL = new GlslTokenType("EQUAL");
  IElementType EQ_OP = new GlslTokenType("EQ_OP");
  IElementType FLOAT = new GlslTokenType("float");
  IElementType FLOAT_CONSTANT = new GlslTokenType("FLOAT_CONSTANT");
  IElementType GE_OP = new GlslTokenType("GE_OP");
  IElementType IDENTIFIER = new GlslTokenType("IDENTIFIER");
  IElementType IN = new GlslTokenType("in");
  IElementType INT = new GlslTokenType("int");
  IElementType INTEGER_CONSTANT = new GlslTokenType("INTEGER_CONSTANT");
  IElementType LEFT_ASSIGN = new GlslTokenType("LEFT_ASSIGN");
  IElementType LEFT_OP = new GlslTokenType("LEFT_OP");
  IElementType LE_OP = new GlslTokenType("LE_OP");
  IElementType MOD_ASSIGN = new GlslTokenType("MOD_ASSIGN");
  IElementType MUL_ASSIGN = new GlslTokenType("MUL_ASSIGN");
  IElementType NE_OP = new GlslTokenType("NE_OP");
  IElementType NULL_TOKEN = new GlslTokenType("NULL_TOKEN");
  IElementType OR_ASSIGN = new GlslTokenType("OR_ASSIGN");
  IElementType OR_OP = new GlslTokenType("OR_OP");
  IElementType OUT = new GlslTokenType("out");
  IElementType PAREN_L = new GlslTokenType("PAREN_L");
  IElementType PAREN_R = new GlslTokenType("PAREN_R");
  IElementType PERCENT = new GlslTokenType("PERCENT");
  IElementType PLUS = new GlslTokenType("PLUS");
  IElementType RIGHT_ASSIGN = new GlslTokenType("RIGHT_ASSIGN");
  IElementType RIGHT_OP = new GlslTokenType("RIGHT_OP");
  IElementType SEMICOLON = new GlslTokenType("SEMICOLON");
  IElementType SHARED = new GlslTokenType("shared");
  IElementType SLASH = new GlslTokenType("SLASH");
  IElementType STAR = new GlslTokenType("STAR");
  IElementType STRUCT = new GlslTokenType("struct");
  IElementType SUB_ASSIGN = new GlslTokenType("SUB_ASSIGN");
  IElementType S_BRACKET_L = new GlslTokenType("S_BRACKET_L");
  IElementType S_BRACKET_R = new GlslTokenType("S_BRACKET_R");
  IElementType UINT = new GlslTokenType("uint");
  IElementType UNIFORM = new GlslTokenType("uniform");
  IElementType VARYING = new GlslTokenType("varying");
  IElementType VERTICAL_BAR = new GlslTokenType("VERTICAL_BAR");
  IElementType VOID = new GlslTokenType("void");
  IElementType XOR_ASSIGN = new GlslTokenType("XOR_ASSIGN");
  IElementType XOR_OP = new GlslTokenType("XOR_OP");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARITHMETIC_OP) {
        return new GlslArithmeticOpImpl(node);
      }
      else if (type == ASSIGN_OP) {
        return new GlslAssignOpImpl(node);
      }
      else if (type == DECLARATION) {
        return new GlslDeclarationImpl(node);
      }
      else if (type == EXPRESSION) {
        return new GlslExpressionImpl(node);
      }
      else if (type == EXPRESSION_ASSIGN) {
        return new GlslExpressionAssignImpl(node);
      }
      else if (type == EXPRESSION_ASSIGN_PAREN) {
        return new GlslExpressionAssignParenImpl(node);
      }
      else if (type == EXPRESSION_NO_ASSIGN) {
        return new GlslExpressionNoAssignImpl(node);
      }
      else if (type == EXPRESSION_NO_ASSIGN_PAREN) {
        return new GlslExpressionNoAssignParenImpl(node);
      }
      else if (type == EXPRESSION_UNIT) {
        return new GlslExpressionUnitImpl(node);
      }
      else if (type == FUNCTION_ARGS) {
        return new GlslFunctionArgsImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new GlslFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new GlslFunctionDefinitionImpl(node);
      }
      else if (type == IDENTIFIER_TYPE) {
        return new GlslIdentifierTypeImpl(node);
      }
      else if (type == INIT_VAL) {
        return new GlslInitValImpl(node);
      }
      else if (type == MEMBER_ACCESS) {
        return new GlslMemberAccessImpl(node);
      }
      else if (type == RELATIONAL_OP) {
        return new GlslRelationalOpImpl(node);
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
      else if (type == VAR_NAME_ACCESS_FUNC) {
        return new GlslVarNameAccessFuncImpl(node);
      }
      else if (type == VAR_NAME_ACCESS_VAR) {
        return new GlslVarNameAccessVarImpl(node);
      }
      else if (type == VAR_NAME_ORIGIN_FUNC) {
        return new GlslVarNameOriginFuncImpl(node);
      }
      else if (type == VAR_NAME_ORIGIN_STRUCT) {
        return new GlslVarNameOriginStructImpl(node);
      }
      else if (type == VAR_NAME_ORIGIN_VARIABLE) {
        return new GlslVarNameOriginVariableImpl(node);
      }
      else if (type == VAR_NAME_TYPE) {
        return new GlslVarNameTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
