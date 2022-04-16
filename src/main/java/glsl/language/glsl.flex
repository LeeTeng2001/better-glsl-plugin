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

// Basic types --------------------------------------------
void                                { return GlslTypes.VOID; }
int                                { return GlslTypes.INT; }
uint                                { return GlslTypes.UINT; }
float                                { return GlslTypes.FLOAT; }
double                                { return GlslTypes.DOUBLE; }
bool                                { return GlslTypes.BOOL; }
struct                                { return GlslTypes.STRUCT; }

// Symbols ------------------------------------------------d
";"                                { return GlslTypes.SEMICOLON; }
"{"                                { return GlslTypes.BRACKET_L; }
"}"                                { return GlslTypes.BRACKET_R; }

// Storage qualifier ------------------------------------------------
const                   {return GlslTypes.CONST; }
in                   {return GlslTypes.IN; }
out                   {return GlslTypes.OUT; }
attribute               {return GlslTypes.ATTRIBUTE; }
uniform                 {return GlslTypes.UNIFORM; }
varying                 {return GlslTypes.VARYING; }
buffer                  {return GlslTypes.BUFFER; }
shared                  {return GlslTypes.SHARED; }

//centroid                {return CENTROID_KEYWORD; }
//patch                   {return PATCH_KEYWORD; }
//sample                  {return SAMPLE_KEYWORD; }

<YYINITIAL> {ASSIGNMENT_OP}                                { return GlslTypes.OPERATOR_ASSIGNMENT; }
<YYINITIAL> {END_OF_LINE_COMMENT}                           { return GlslTypes.COMMENT; }
<YYINITIAL> {INTEGER_CONSTANT}                                { return GlslTypes.INTEGER_CONSTANT; }
<YYINITIAL> {FLOAT_CONSTANT}                                { return GlslTypes.FLOAT_CONSTANT; }
<YYINITIAL> {IDENTIFIER}                                { return GlslTypes.IDENTIFIER; }


<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }


[^]                                                         { return TokenType.BAD_CHARACTER; }