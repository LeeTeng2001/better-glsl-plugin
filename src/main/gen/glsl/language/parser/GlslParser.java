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
  // return expression_no_assign?
  public static boolean exit_control_return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_control_return")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && exit_control_return_1(b, l + 1);
    exit_section_(b, m, EXIT_CONTROL_RETURN, r);
    return r;
  }

  // expression_no_assign?
  private static boolean exit_control_return_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_control_return_1")) return false;
    expression_no_assign(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // discard | break | continue
  public static boolean exit_control_single(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_control_single")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXIT_CONTROL_SINGLE, "<exit control single>");
    r = consumeToken(b, DISCARD);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (exit_control_return | exit_control_single | expression_assign) SEMICOLON
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // exit_control_return | exit_control_single | expression_assign
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    r = exit_control_return(b, l + 1);
    if (!r) r = exit_control_single(b, l + 1);
    if (!r) r = expression_assign(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (expression_no_assign | expression_assign_paren | initializer) (assign_op expression_assign)?
  public static boolean expression_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION_ASSIGN, "<expression assign>");
    r = expression_assign_0(b, l + 1);
    r = r && expression_assign_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_no_assign | expression_assign_paren | initializer
  private static boolean expression_assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_assign_0")) return false;
    boolean r;
    r = expression_no_assign(b, l + 1);
    if (!r) r = expression_assign_paren(b, l + 1);
    if (!r) r = initializer(b, l + 1);
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
  // unary_front_op? (FLOAT_CONSTANT | INTEGER_CONSTANT | function_call | member_access_head) unary_back_op?
  public static boolean expression_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_unit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_UNIT, "<expression unit>");
    r = expression_unit_0(b, l + 1);
    r = r && expression_unit_1(b, l + 1);
    r = r && expression_unit_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_front_op?
  private static boolean expression_unit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_unit_0")) return false;
    unary_front_op(b, l + 1);
    return true;
  }

  // FLOAT_CONSTANT | INTEGER_CONSTANT | function_call | member_access_head
  private static boolean expression_unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_unit_1")) return false;
    boolean r;
    r = consumeToken(b, FLOAT_CONSTANT);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = member_access_head(b, l + 1);
    return r;
  }

  // unary_back_op?
  private static boolean expression_unit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_unit_2")) return false;
    unary_back_op(b, l + 1);
    return true;
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
  // void | int | uint | float | double | bool | NATIVE_VECTOR | NATIVE_MATRIX | NATIVE_SAMPLER | NATIVE_IMAGES | NATIVE_VULKAN_TEXTURE | var_name_type
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
    if (!r) r = consumeToken(b, NATIVE_VECTOR);
    if (!r) r = consumeToken(b, NATIVE_MATRIX);
    if (!r) r = consumeToken(b, NATIVE_SAMPLER);
    if (!r) r = consumeToken(b, NATIVE_IMAGES);
    if (!r) r = consumeToken(b, NATIVE_VULKAN_TEXTURE);
    if (!r) r = var_name_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // true | false | (unary_sign_op? (FLOAT_CONSTANT | INTEGER_CONSTANT)) | member_access_head | initializer
  public static boolean init_val(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_val")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INIT_VAL, "<init val>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = init_val_2(b, l + 1);
    if (!r) r = member_access_head(b, l + 1);
    if (!r) r = initializer(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_sign_op? (FLOAT_CONSTANT | INTEGER_CONSTANT)
  private static boolean init_val_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_val_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = init_val_2_0(b, l + 1);
    r = r && init_val_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_sign_op?
  private static boolean init_val_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_val_2_0")) return false;
    unary_sign_op(b, l + 1);
    return true;
  }

  // FLOAT_CONSTANT | INTEGER_CONSTANT
  private static boolean init_val_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_val_2_1")) return false;
    boolean r;
    r = consumeToken(b, FLOAT_CONSTANT);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    return r;
  }

  /* ********************************************************** */
  // identifier_type (S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R)?
  //                 PAREN_L expression_no_assign? (COMMA expression_no_assign)* PAREN_R
  public static boolean initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INITIALIZER, "<initializer>");
    r = identifier_type(b, l + 1);
    r = r && initializer_1(b, l + 1);
    r = r && consumeToken(b, PAREN_L);
    r = r && initializer_3(b, l + 1);
    r = r && initializer_4(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R)?
  private static boolean initializer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_1")) return false;
    initializer_1_0(b, l + 1);
    return true;
  }

  // S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R
  private static boolean initializer_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && initializer_1_0_1(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // INTEGER_CONSTANT?
  private static boolean initializer_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_1_0_1")) return false;
    consumeToken(b, INTEGER_CONSTANT);
    return true;
  }

  // expression_no_assign?
  private static boolean initializer_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_3")) return false;
    expression_no_assign(b, l + 1);
    return true;
  }

  // (COMMA expression_no_assign)*
  private static boolean initializer_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!initializer_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "initializer_4", c)) break;
    }
    return true;
  }

  // COMMA expression_no_assign
  private static boolean initializer_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializer_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression_no_assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // layout PAREN_L layout_qualifier_param? (COMMA layout_qualifier_param)* PAREN_R
  public static boolean layout_qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier")) return false;
    if (!nextTokenIs(b, LAYOUT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LAYOUT_QUALIFIER, null);
    r = consumeTokens(b, 2, LAYOUT, PAREN_L);
    p = r; // pin = 2
    r = r && report_error_(b, layout_qualifier_2(b, l + 1));
    r = p && report_error_(b, layout_qualifier_3(b, l + 1)) && r;
    r = p && consumeToken(b, PAREN_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // layout_qualifier_param?
  private static boolean layout_qualifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_2")) return false;
    layout_qualifier_param(b, l + 1);
    return true;
  }

  // (COMMA layout_qualifier_param)*
  private static boolean layout_qualifier_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!layout_qualifier_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "layout_qualifier_3", c)) break;
    }
    return true;
  }

  // COMMA layout_qualifier_param
  private static boolean layout_qualifier_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && layout_qualifier_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER | shared) (EQUAL INTEGER_CONSTANT)?
  public static boolean layout_qualifier_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_param")) return false;
    if (!nextTokenIs(b, "<layout qualifier param>", IDENTIFIER, SHARED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAYOUT_QUALIFIER_PARAM, "<layout qualifier param>");
    r = layout_qualifier_param_0(b, l + 1);
    r = r && layout_qualifier_param_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | shared
  private static boolean layout_qualifier_param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_param_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SHARED);
    return r;
  }

  // (EQUAL INTEGER_CONSTANT)?
  private static boolean layout_qualifier_param_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_param_1")) return false;
    layout_qualifier_param_1_0(b, l + 1);
    return true;
  }

  // EQUAL INTEGER_CONSTANT
  private static boolean layout_qualifier_param_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layout_qualifier_param_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUAL, INTEGER_CONSTANT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HASHTAG (macro_define | macro_declare)
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, HASHTAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASHTAG);
    r = r && macro_1(b, l + 1);
    exit_section_(b, m, MACRO, r);
    return r;
  }

  // macro_define | macro_declare
  private static boolean macro_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1")) return false;
    boolean r;
    r = macro_define(b, l + 1);
    if (!r) r = macro_declare(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // macro_keyword_generic MACRO_TO_END
  public static boolean macro_declare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_declare")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_DECLARE, "<macro declare>");
    r = macro_keyword_generic(b, l + 1);
    r = r && consumeToken(b, MACRO_TO_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // define var_name_origin_variable MACRO_TO_END
  public static boolean macro_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_define")) return false;
    if (!nextTokenIs(b, DEFINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE);
    r = r && var_name_origin_variable(b, l + 1);
    r = r && consumeToken(b, MACRO_TO_END);
    exit_section_(b, m, MACRO_DEFINE, r);
    return r;
  }

  /* ********************************************************** */
  // undef | if | ifdef | ifndef | else | elif | endif | error | pragma | version | extension | line | include
  public static boolean macro_keyword_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_keyword_generic")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_KEYWORD_GENERIC, "<macro keyword generic>");
    r = consumeToken(b, UNDEF);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, IFDEF);
    if (!r) r = consumeToken(b, IFNDEF);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, ELIF);
    if (!r) r = consumeToken(b, ENDIF);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, PRAGMA);
    if (!r) r = consumeToken(b, VERSION);
    if (!r) r = consumeToken(b, EXTENSION);
    if (!r) r = consumeToken(b, LINE);
    if (!r) r = consumeToken(b, INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_member member_access_postfix
  public static boolean member_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_access_member(b, l + 1);
    r = r && member_access_postfix(b, l + 1);
    exit_section_(b, m, MEMBER_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // S_BRACKET_L valid_access_index S_BRACKET_R (S_BRACKET_L valid_access_index S_BRACKET_R)?
  static boolean member_access_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_array")) return false;
    if (!nextTokenIs(b, S_BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && valid_access_index(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    r = r && member_access_array_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (S_BRACKET_L valid_access_index S_BRACKET_R)?
  private static boolean member_access_array_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_array_3")) return false;
    member_access_array_3_0(b, l + 1);
    return true;
  }

  // S_BRACKET_L valid_access_index S_BRACKET_R
  private static boolean member_access_array_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_array_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && valid_access_index(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PAREN_L PAREN_R
  static boolean member_access_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_func")) return false;
    if (!nextTokenIs(b, PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PAREN_L, PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_var member_access_postfix
  public static boolean member_access_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_head")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_access_var(b, l + 1);
    r = r && member_access_postfix(b, l + 1);
    exit_section_(b, m, MEMBER_ACCESS_HEAD, r);
    return r;
  }

  /* ********************************************************** */
  // (member_access_array | member_access_func)?  (DOT member_access)?
  static boolean member_access_postfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_postfix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = member_access_postfix_0(b, l + 1);
    r = r && member_access_postfix_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (member_access_array | member_access_func)?
  private static boolean member_access_postfix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_postfix_0")) return false;
    member_access_postfix_0_0(b, l + 1);
    return true;
  }

  // member_access_array | member_access_func
  private static boolean member_access_postfix_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_postfix_0_0")) return false;
    boolean r;
    r = member_access_array(b, l + 1);
    if (!r) r = member_access_func(b, l + 1);
    return r;
  }

  // (DOT member_access)?
  private static boolean member_access_postfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_postfix_1")) return false;
    member_access_postfix_1_0(b, l + 1);
    return true;
  }

  // DOT member_access
  private static boolean member_access_postfix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_access_postfix_1_0")) return false;
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
  // reserved_future_keyword
  static boolean reserved_keyword(PsiBuilder b, int l) {
    return consumeToken(b, RESERVED_FUTURE_KEYWORD);
  }

  /* ********************************************************** */
  // macro | statement | expression | declaration | COMMENT | CRLF
  static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    boolean r;
    r = macro(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // statement_if | statement_else | statement_switch | statement_do_while | statement_while_normal | statement_for
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_if(b, l + 1);
    if (!r) r = statement_else(b, l + 1);
    if (!r) r = statement_switch(b, l + 1);
    if (!r) r = statement_do_while(b, l + 1);
    if (!r) r = statement_while_normal(b, l + 1);
    if (!r) r = statement_for(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // do C_BRACKET_L segment* C_BRACKET_R statement_while_header SEMICOLON
  public static boolean statement_do_while(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_do_while")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DO, C_BRACKET_L);
    r = r && statement_do_while_2(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    r = r && statement_while_header(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, STATEMENT_DO_WHILE, r);
    return r;
  }

  // segment*
  private static boolean statement_do_while_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_do_while_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_do_while_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // else (statement_if | (C_BRACKET_L segment* C_BRACKET_R))
  public static boolean statement_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_else")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && statement_else_1(b, l + 1);
    exit_section_(b, m, STATEMENT_ELSE, r);
    return r;
  }

  // statement_if | (C_BRACKET_L segment* C_BRACKET_R)
  private static boolean statement_else_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_else_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_if(b, l + 1);
    if (!r) r = statement_else_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // C_BRACKET_L segment* C_BRACKET_R
  private static boolean statement_else_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_else_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, C_BRACKET_L);
    r = r && statement_else_1_1_1(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // segment*
  private static boolean statement_else_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_else_1_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_else_1_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // for PAREN_L statement_for_paren PAREN_R C_BRACKET_L segment* C_BRACKET_R
  public static boolean statement_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, PAREN_L);
    r = r && statement_for_paren(b, l + 1);
    r = r && consumeTokens(b, 0, PAREN_R, C_BRACKET_L);
    r = r && statement_for_5(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, STATEMENT_FOR, r);
    return r;
  }

  // segment*
  private static boolean statement_for_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_for_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // statement_for_var_initialise SEMICOLON statement_for_var_termination SEMICOLON statement_for_var_increment
  static boolean statement_for_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_paren")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_for_var_initialise(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && statement_for_var_termination(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && statement_for_var_increment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_var ((INCREMENT | DECREMENT) | ((ADD_ASSIGN | SUB_ASSIGN) unary_sign_op? (INTEGER_CONSTANT | FLOAT_CONSTANT)))
  static boolean statement_for_var_increment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_access_var(b, l + 1);
    r = r && statement_for_var_increment_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INCREMENT | DECREMENT) | ((ADD_ASSIGN | SUB_ASSIGN) unary_sign_op? (INTEGER_CONSTANT | FLOAT_CONSTANT))
  private static boolean statement_for_var_increment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_for_var_increment_1_0(b, l + 1);
    if (!r) r = statement_for_var_increment_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INCREMENT | DECREMENT
  private static boolean statement_for_var_increment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1_0")) return false;
    boolean r;
    r = consumeToken(b, INCREMENT);
    if (!r) r = consumeToken(b, DECREMENT);
    return r;
  }

  // (ADD_ASSIGN | SUB_ASSIGN) unary_sign_op? (INTEGER_CONSTANT | FLOAT_CONSTANT)
  private static boolean statement_for_var_increment_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_for_var_increment_1_1_0(b, l + 1);
    r = r && statement_for_var_increment_1_1_1(b, l + 1);
    r = r && statement_for_var_increment_1_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ADD_ASSIGN | SUB_ASSIGN
  private static boolean statement_for_var_increment_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1_1_0")) return false;
    boolean r;
    r = consumeToken(b, ADD_ASSIGN);
    if (!r) r = consumeToken(b, SUB_ASSIGN);
    return r;
  }

  // unary_sign_op?
  private static boolean statement_for_var_increment_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1_1_1")) return false;
    unary_sign_op(b, l + 1);
    return true;
  }

  // INTEGER_CONSTANT | FLOAT_CONSTANT
  private static boolean statement_for_var_increment_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_increment_1_1_2")) return false;
    boolean r;
    r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = consumeToken(b, FLOAT_CONSTANT);
    return r;
  }

  /* ********************************************************** */
  // identifier_type var_name_origin_variable EQUAL unary_sign_op? (INTEGER_CONSTANT | FLOAT_CONSTANT)
  static boolean statement_for_var_initialise(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_initialise")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_type(b, l + 1);
    r = r && var_name_origin_variable(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && statement_for_var_initialise_3(b, l + 1);
    r = r && statement_for_var_initialise_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_sign_op?
  private static boolean statement_for_var_initialise_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_initialise_3")) return false;
    unary_sign_op(b, l + 1);
    return true;
  }

  // INTEGER_CONSTANT | FLOAT_CONSTANT
  private static boolean statement_for_var_initialise_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_initialise_4")) return false;
    boolean r;
    r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = consumeToken(b, FLOAT_CONSTANT);
    return r;
  }

  /* ********************************************************** */
  // var_name_access_var relational_op unary_sign_op? (INTEGER_CONSTANT | FLOAT_CONSTANT)
  static boolean statement_for_var_termination(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_termination")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_access_var(b, l + 1);
    r = r && relational_op(b, l + 1);
    r = r && statement_for_var_termination_2(b, l + 1);
    r = r && statement_for_var_termination_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_sign_op?
  private static boolean statement_for_var_termination_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_termination_2")) return false;
    unary_sign_op(b, l + 1);
    return true;
  }

  // INTEGER_CONSTANT | FLOAT_CONSTANT
  private static boolean statement_for_var_termination_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_for_var_termination_3")) return false;
    boolean r;
    r = consumeToken(b, INTEGER_CONSTANT);
    if (!r) r = consumeToken(b, FLOAT_CONSTANT);
    return r;
  }

  /* ********************************************************** */
  // if PAREN_L expression_no_assign PAREN_R C_BRACKET_L segment* C_BRACKET_R
  public static boolean statement_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_if")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, PAREN_L);
    r = r && expression_no_assign(b, l + 1);
    r = r && consumeTokens(b, 0, PAREN_R, C_BRACKET_L);
    r = r && statement_if_5(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, STATEMENT_IF, r);
    return r;
  }

  // segment*
  private static boolean statement_if_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_if_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_if_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // switch PAREN_L expression_unit PAREN_R C_BRACKET_L statement_switch_case* C_BRACKET_R
  public static boolean statement_switch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SWITCH, PAREN_L);
    r = r && expression_unit(b, l + 1);
    r = r && consumeTokens(b, 0, PAREN_R, C_BRACKET_L);
    r = r && statement_switch_5(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, STATEMENT_SWITCH, r);
    return r;
  }

  // statement_switch_case*
  private static boolean statement_switch_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement_switch_case(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_switch_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (default | (case unary_sign_op? INTEGER_CONSTANT)) COLON expression*
  static boolean statement_switch_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_case")) return false;
    if (!nextTokenIs(b, "", CASE, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_switch_case_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && statement_switch_case_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // default | (case unary_sign_op? INTEGER_CONSTANT)
  private static boolean statement_switch_case_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_case_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    if (!r) r = statement_switch_case_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case unary_sign_op? INTEGER_CONSTANT
  private static boolean statement_switch_case_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_case_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && statement_switch_case_0_1_1(b, l + 1);
    r = r && consumeToken(b, INTEGER_CONSTANT);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_sign_op?
  private static boolean statement_switch_case_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_case_0_1_1")) return false;
    unary_sign_op(b, l + 1);
    return true;
  }

  // expression*
  private static boolean statement_switch_case_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_switch_case_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_switch_case_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // while PAREN_L expression_no_assign PAREN_R
  static boolean statement_while_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_while_header")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHILE, PAREN_L);
    r = r && expression_no_assign(b, l + 1);
    r = r && consumeToken(b, PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement_while_header C_BRACKET_L segment* C_BRACKET_R
  public static boolean statement_while_normal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_while_normal")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_while_header(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_L);
    r = r && statement_while_normal_2(b, l + 1);
    r = r && consumeToken(b, C_BRACKET_R);
    exit_section_(b, m, STATEMENT_WHILE_NORMAL, r);
    return r;
  }

  // segment*
  private static boolean statement_while_normal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_while_normal_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_while_normal_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // const | uniform | buffer | shared | (layout_qualifier? (in | out | inout))
  public static boolean storage_qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_qualifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STORAGE_QUALIFIER, "<storage qualifier>");
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, UNIFORM);
    if (!r) r = consumeToken(b, BUFFER);
    if (!r) r = consumeToken(b, SHARED);
    if (!r) r = storage_qualifier_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // layout_qualifier? (in | out | inout)
  private static boolean storage_qualifier_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_qualifier_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = storage_qualifier_4_0(b, l + 1);
    r = r && storage_qualifier_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // layout_qualifier?
  private static boolean storage_qualifier_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_qualifier_4_0")) return false;
    layout_qualifier(b, l + 1);
    return true;
  }

  // in | out | inout
  private static boolean storage_qualifier_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_qualifier_4_1")) return false;
    boolean r;
    r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OUT);
    if (!r) r = consumeToken(b, INOUT);
    return r;
  }

  /* ********************************************************** */
  // (layout_qualifier? (in | out))? struct var_name_origin_struct C_BRACKET_L
  //                         variable_definition* C_BRACKET_R var_name_origin_variable? SEMICOLON
  public static boolean struct_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEFINITION, "<struct definition>");
    r = struct_definition_0(b, l + 1);
    r = r && consumeToken(b, STRUCT);
    p = r; // pin = 2
    r = r && report_error_(b, var_name_origin_struct(b, l + 1));
    r = p && report_error_(b, consumeToken(b, C_BRACKET_L)) && r;
    r = p && report_error_(b, struct_definition_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, C_BRACKET_R)) && r;
    r = p && report_error_(b, struct_definition_6(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (layout_qualifier? (in | out))?
  private static boolean struct_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_0")) return false;
    struct_definition_0_0(b, l + 1);
    return true;
  }

  // layout_qualifier? (in | out)
  private static boolean struct_definition_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = struct_definition_0_0_0(b, l + 1);
    r = r && struct_definition_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // layout_qualifier?
  private static boolean struct_definition_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_0_0_0")) return false;
    layout_qualifier(b, l + 1);
    return true;
  }

  // in | out
  private static boolean struct_definition_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_0_0_1")) return false;
    boolean r;
    r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OUT);
    return r;
  }

  // variable_definition*
  private static boolean struct_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_definition_4", c)) break;
    }
    return true;
  }

  // var_name_origin_variable?
  private static boolean struct_definition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition_6")) return false;
    var_name_origin_variable(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // INCREMENT | DECREMENT
  public static boolean unary_back_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_back_op")) return false;
    if (!nextTokenIs(b, "<unary back op>", DECREMENT, INCREMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_BACK_OP, "<unary back op>");
    r = consumeToken(b, INCREMENT);
    if (!r) r = consumeToken(b, DECREMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INCREMENT | DECREMENT | EXCLAMATION | unary_sign_op
  public static boolean unary_front_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_front_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_FRONT_OP, "<unary front op>");
    r = consumeToken(b, INCREMENT);
    if (!r) r = consumeToken(b, DECREMENT);
    if (!r) r = consumeToken(b, EXCLAMATION);
    if (!r) r = unary_sign_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLUS | DASH
  public static boolean unary_sign_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_sign_op")) return false;
    if (!nextTokenIs(b, "<unary sign op>", DASH, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_SIGN_OP, "<unary sign op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, DASH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NULL_TOKEN
  static boolean useless_expression(PsiBuilder b, int l) {
    return consumeToken(b, NULL_TOKEN);
  }

  /* ********************************************************** */
  // var_name_access_var | INTEGER_CONSTANT
  static boolean valid_access_index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valid_access_index")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, INTEGER_CONSTANT)) return false;
    boolean r;
    r = var_name_access_var(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    return r;
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
  public static boolean var_name_access_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name_access_member")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NAME_ACCESS_MEMBER, r);
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
  // storage_qualifier? identifier_type variable_definition_body (COMMA variable_definition_body)* SEMICOLON
  public static boolean variable_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = variable_definition_0(b, l + 1);
    r = r && identifier_type(b, l + 1);
    r = r && variable_definition_body(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, variable_definition_3(b, l + 1));
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

  // (COMMA variable_definition_body)*
  private static boolean variable_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_definition_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_definition_3", c)) break;
    }
    return true;
  }

  // COMMA variable_definition_body
  private static boolean variable_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variable_definition_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_name_origin_variable (S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R)? (EQUAL init_val)?
  static boolean variable_definition_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name_origin_variable(b, l + 1);
    r = r && variable_definition_body_1(b, l + 1);
    r = r && variable_definition_body_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R)?
  private static boolean variable_definition_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body_1")) return false;
    variable_definition_body_1_0(b, l + 1);
    return true;
  }

  // S_BRACKET_L INTEGER_CONSTANT? S_BRACKET_R
  private static boolean variable_definition_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && variable_definition_body_1_0_1(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // INTEGER_CONSTANT?
  private static boolean variable_definition_body_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body_1_0_1")) return false;
    consumeToken(b, INTEGER_CONSTANT);
    return true;
  }

  // (EQUAL init_val)?
  private static boolean variable_definition_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body_2")) return false;
    variable_definition_body_2_0(b, l + 1);
    return true;
  }

  // EQUAL init_val
  private static boolean variable_definition_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_body_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && init_val(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
