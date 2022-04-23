// This is a generated file. Not intended for manual editing.
package glsl.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static glsl.language.psi.GlslTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GlslParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return glslFile(b, l + 1);
  }

  /* ********************************************************** */
  // PLUS | DASH | STAR | SLASH | PERCENT | LEFT_OP | RIGHT_OP | AMPERSAND | CARET | VERTICAL_BAR
  public static boolean arithmetic_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arithmetic_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITHMETIC_OP, "<arithmetic op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, LEFT_OP);
    if (!r) r = consumeToken(b, RIGHT_OP);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, VERTICAL_BAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUAL | MUL_ASSIGN | DIV_ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MOD_ASSIGN | LEFT_ASSIGN | RIGHT_ASSIGN | AND_ASSIGN | XOR_ASSIGN | OR_ASSIGN
  public static boolean assign_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OP, "<assign op>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, DIV_ASSIGN);
    if (!r) r = consumeToken(b, ADD_ASSIGN);
    if (!r) r = consumeToken(b, SUB_ASSIGN);
    if (!r) r = consumeToken(b, MOD_ASSIGN);
    if (!r) r = consumeToken(b, LEFT_ASSIGN);
    if (!r) r = consumeToken(b, RIGHT_ASSIGN);
    if (!r) r = consumeToken(b, AND_ASSIGN);
    if (!r) r = consumeToken(b, XOR_ASSIGN);
    if (!r) r = consumeToken(b, OR_ASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // struct_definition | function_definition | variable_definition
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = struct_definition(b, l + 1);
    if (!r) r = function_definition(b, l + 1);
    if (!r) r = variable_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression_assign SEMICOLON
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_assign(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (expression_no_assign | expression_assign_paren) (assign_op expression_assign)?
  public static boolean expression_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION_ASSIGN, "<expression assign>");
    r = expression_assign_0(b, l + 1);
    r = r && expression_assign_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_no_assign | expression_assign_paren
  private static boolean expression_assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign_0")) return false;
    boolean r;
    r = expression_no_assign(b, l + 1);
    if (!r) r = expression_assign_paren(b, l + 1);
    return r;
  }

  // (assign_op expression_assign)?
  private static boolean expression_assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign_1")) return false;
    expression_assign_1_0(b, l + 1);
    return true;
  }

  // assign_op expression_assign
  private static boolean expression_assign_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assign_op(b, l + 1);
    r = r && expression_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PAREN_L expression_assign PAREN_R
  public static boolean expression_assign_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign_paren")) return false;
    if (!nextTokenIs(b, PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_L);
    r = r && expression_assign(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, EXPRESSION_ASSIGN_PAREN, r);
    return r;
  }

  /* ********************************************************** */
  // (expression_unit | expression_no_assign_paren) ((arithmetic_op | relational_op) expression_no_assign)?
  public static boolean expression_no_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION_NO_ASSIGN, "<expression no assign>");
    r = expression_no_assign_0(b, l + 1);
    r = r && expression_no_assign_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_unit | expression_no_assign_paren
  private static boolean expression_no_assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign_0")) return false;
    boolean r;
    r = expression_unit(b, l + 1);
    if (!r) r = expression_no_assign_paren(b, l + 1);
    return r;
  }

  // ((arithmetic_op | relational_op) expression_no_assign)?
  private static boolean expression_no_assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign_1")) return false;
    expression_no_assign_1_0(b, l + 1);
    return true;
  }

  // (arithmetic_op | relational_op) expression_no_assign
  private static boolean expression_no_assign_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_no_assign_1_0_0(b, l + 1);
    r = r && expression_no_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arithmetic_op | relational_op
  private static boolean expression_no_assign_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign_1_0_0")) return false;
    boolean r;
    r = arithmetic_op(b, l + 1);
    if (!r) r = relational_op(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PAREN_L expression_no_assign PAREN_R
  public static boolean expression_no_assign_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_no_assign_paren")) return false;
    if (!nextTokenIs(b, PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_L);
    r = r && expression_no_assign(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, EXPRESSION_NO_ASSIGN_PAREN, r);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_CONSTANT | INTEGER_CONSTANT | function_call | member_access
  public static boolean expression_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_unit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_UNIT, "<expression unit>");
    r = consumeToken(b, FLOAT_CONSTANT);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = member_access(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier_type var_name_origin_variable (COMMA function_args)?
  public static boolean function_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_ARGS, "<function args>");
    r = identifier_type(b, l + 1);
    r = r && var_name_origin_variable(b, l + 1);
    r = r && function_args_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA function_args)?
  private static boolean function_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_args_2")) return false;
    function_args_2_0(b, l + 1);
    return true;
  }

  // COMMA function_args
  private static boolean function_args_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_args_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && function_args(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_func PAREN_L (expression_no_assign (COMMA expression_no_assign)*)? PAREN_R
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, null);
    r = var_name_access_func(b, l + 1);
    r = r && consumeToken(b, PAREN_L);
    p = r; // pin = 2
    r = r && report_error_(b, function_call_2(b, l + 1));
    r = p && consumeToken(b, PAREN_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (expression_no_assign (COMMA expression_no_assign)*)?
  private static boolean function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2")) return false;
    function_call_2_0(b, l + 1);
    return true;
  }

  // expression_no_assign (COMMA expression_no_assign)*
  private static boolean function_call_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_no_assign(b, l + 1);
    r = r && function_call_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression_no_assign)*
  private static boolean function_call_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_call_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_call_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA expression_no_assign
  private static boolean function_call_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression_no_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier_type var_name_origin_func PAREN_L function_args? PAREN_R (C_BRACKET_L segment* C_BRACKET_R)? SEMICOLON?
  public static boolean function_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINITION, "<function definition>");
    r = identifier_type(b, l + 1);
    r = r && var_name_origin_func(b, l + 1);
    r = r && consumeToken(b, PAREN_L);
    p = r; // pin = 3
    r = r && report_error_(b, function_definition_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, PAREN_R)) && r;
    r = p && report_error_(b, function_definition_5(b, l + 1)) && r;
    r = p && function_definition_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // function_args?
  private static boolean function_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_3")) return false;
    function_args(b, l + 1);
    return true;
  }

  // (C_BRACKET_L segment* C_BRACKET_R)?
  private static boolean function_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_5")) return false;
    function_definition_5_0(b, l + 1);
    return true;
  }

  // C_BRACKET_L segment* C_BRACKET_R
  private static boolean function_definition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, C_BRACKET_L);
    r = r && function_definition_5_0_1(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // segment*
  private static boolean function_definition_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_definition_5_0_1", c)) break;
    }
    return true;
  }

  // SEMICOLON?
  private static boolean function_definition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_6")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // segment*
  static boolean glslFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "glslFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "glslFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // void | int | uint | float | double | bool | var_name_type
  public static boolean identifier_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_TYPE, "<identifier type>");
    r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, UINT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = var_name_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_CONSTANT | INTEGER_CONSTANT | IDENTIFIER
  public static boolean init_val(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_val")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INIT_VAL, "<init val>");
    r = consumeToken(b, FLOAT_CONSTANT);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_var (S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R)? (DOT member_access)?
  public static boolean member_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_access_var(b, l + 1);
    r = r && member_access_1(b, l + 1);
    r = r && member_access_2(b, l + 1);
    exit_section_(b, m, MEMBER_ACCESS, r);
    return r;
  }

  // (S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R)?
  private static boolean member_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_1")) return false;
    member_access_1_0(b, l + 1);
    return true;
  }

  // S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R
  private static boolean member_access_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, S_BRACKET_L, INTEGER_CONSTANT, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT member_access)?
  private static boolean member_access_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_2")) return false;
    member_access_2_0(b, l + 1);
    return true;
  }

  // DOT member_access
  private static boolean member_access_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && member_access(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !SEMICOLON
  static boolean recover_to_semicolon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_to_semicolon")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQ_OP | ANGLE_L | ANGLE_R | GE_OP | LE_OP | NE_OP | AND_OP | OR_OP | XOR_OP
  public static boolean relational_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_OP, "<relational op>");
    r = consumeToken(b, EQ_OP);
    if (!r) r = consumeToken(b, ANGLE_L);
    if (!r) r = consumeToken(b, ANGLE_R);
    if (!r) r = consumeToken(b, GE_OP);
    if (!r) r = consumeToken(b, LE_OP);
    if (!r) r = consumeToken(b, NE_OP);
    if (!r) r = consumeToken(b, AND_OP);
    if (!r) r = consumeToken(b, OR_OP);
    if (!r) r = consumeToken(b, XOR_OP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression | declaration | COMMENT | CRLF
  static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    boolean r;
    r = expression(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // const | in | out | attribute | uniform | varying | buffer | shared
  public static boolean storage_qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_qualifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STORAGE_QUALIFIER, "<storage qualifier>");
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OUT);
    if (!r) r = consumeToken(b, ATTRIBUTE);
    if (!r) r = consumeToken(b, UNIFORM);
    if (!r) r = consumeToken(b, VARYING);
    if (!r) r = consumeToken(b, BUFFER);
    if (!r) r = consumeToken(b, SHARED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // struct var_name_origin_struct C_BRACKET_L variable_definition* C_BRACKET_R SEMICOLON
  public static boolean struct_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEFINITION, null);
    r = consumeToken(b, STRUCT);
    p = r; // pin = 1
    r = r && report_error_(b, var_name_origin_struct(b, l + 1));
    r = p && report_error_(b, consumeToken(b, C_BRACKET_L)) && r;
    r = p && report_error_(b, struct_definition_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, C_BRACKET_R, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // variable_definition*
  private static boolean struct_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_definition_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NULL_TOKEN
  static boolean useless_expression(PsiBuilder b, int l) {
    return consumeToken(b, NULL_TOKEN);
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_access_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_access_func")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ACCESS_FUNC, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_access_var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_access_var")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ACCESS_VAR, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_origin_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_origin_func")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ORIGIN_FUNC, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_origin_struct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_origin_struct")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ORIGIN_STRUCT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_origin_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_origin_variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ORIGIN_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_name_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // storage_qualifier? identifier_type var_name_origin_variable
  //                         (S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R)? (EQUAL init_val)? SEMICOLON
  public static boolean variable_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = variable_definition_0(b, l + 1);
    r = r && identifier_type(b, l + 1);
    r = r && var_name_origin_variable(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, variable_definition_3(b, l + 1));
    r = p && report_error_(b, variable_definition_4(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // storage_qualifier?
  private static boolean variable_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_0")) return false;
    storage_qualifier(b, l + 1);
    return true;
  }

  // (S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R)?
  private static boolean variable_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_3")) return false;
    variable_definition_3_0(b, l + 1);
    return true;
  }

  // S_BRACKET_L INTEGER_CONSTANT S_BRACKET_R
  private static boolean variable_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, S_BRACKET_L, INTEGER_CONSTANT, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQUAL init_val)?
  private static boolean variable_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_4")) return false;
    variable_definition_4_0(b, l + 1);
    return true;
  }

  // EQUAL init_val
  private static boolean variable_definition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && init_val(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
