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
  // struct_definition | variable_definition
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = struct_definition(b, l + 1);
    if (!r) r = variable_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // void | int | uint | float | double | bool | IDENTIFIER
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
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // declaration | COMMENT | CRLF
  static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    boolean r;
    r = declaration(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // struct IDENTIFIER BRACKET_L variable_definition* BRACKET_R SEMICOLON
  public static boolean struct_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_definition")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STRUCT, IDENTIFIER, BRACKET_L);
    r = r && struct_definition_3(b, l + 1);
    r = r && consumeTokens(b, 0, BRACKET_R, SEMICOLON);
    exit_section_(b, m, STRUCT_DEFINITION, r);
    return r;
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
  // identifier_type IDENTIFIER (OPERATOR_ASSIGNMENT variable_val)? SEMICOLON
  public static boolean variable_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = identifier_type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && variable_definition_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OPERATOR_ASSIGNMENT variable_val)?
  private static boolean variable_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_2")) return false;
    variable_definition_2_0(b, l + 1);
    return true;
  }

  // OPERATOR_ASSIGNMENT variable_val
  private static boolean variable_definition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR_ASSIGNMENT);
    r = r && variable_val(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | FLOAT_CONSTANT | INTEGER_CONSTANT
  public static boolean variable_val(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_val")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_VAL, "<variable val>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, FLOAT_CONSTANT);
    if (!r) r = consumeToken(b, INTEGER_CONSTANT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
