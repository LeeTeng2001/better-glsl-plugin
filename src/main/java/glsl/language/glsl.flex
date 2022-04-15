package glsl.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import glsl.language.psi.GlslTypes;  // contain token we'll use

%%

%class GlslLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

END_OF_LINE_COMMENT="//"[^\r\n]*
INTEGER_CONSTANT=\d+
FLOAT_CONSTANT=\d+\.\d+
IDENTIFIER=[:jletter:][:jletterdigit:]*
ASSIGNMENT_OP=("=")|("+=")|("-=")

%state WAITING_VALUE

%%

<YYINITIAL> "int"                                { return GlslTypes.INT; }
<YYINITIAL> "float"                                { return GlslTypes.FLOAT; }
<YYINITIAL> "struct"                                { return GlslTypes.STRUCT; }
<YYINITIAL> {
    ";"                                { return GlslTypes.SEMICOLON; }
    "{"                                { return GlslTypes.BRACKET_L; }
    "}"                                { return GlslTypes.BRACKET_R; }
}
<YYINITIAL> {ASSIGNMENT_OP}                                { return GlslTypes.OPERATOR_ASSIGNMENT; }
<YYINITIAL> {END_OF_LINE_COMMENT}                           { return GlslTypes.COMMENT; }
<YYINITIAL> {INTEGER_CONSTANT}                                { return GlslTypes.INTEGER_CONSTANT; }
<YYINITIAL> {FLOAT_CONSTANT}                                { return GlslTypes.FLOAT_CONSTANT; }
<YYINITIAL> {IDENTIFIER}                                { return GlslTypes.IDENTIFIER; }


<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }


[^]                                                         { return TokenType.BAD_CHARACTER; }