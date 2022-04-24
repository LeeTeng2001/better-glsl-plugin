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
INTEGER_CONSTANT=[+-]?\d+
FLOAT_CONSTANT=[+-]?\d+\.\d+
IDENTIFIER=[:jletter:][:jletterdigit:]*

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

// Control flow keyword ------------------------------------------------
if                                { return GlslTypes.IF; }
else                                { return GlslTypes.ELSE; }
switch                                { return GlslTypes.SWITCH; }
case                                { return GlslTypes.CASE; }
default                                { return GlslTypes.DEFAULT; }
do                                { return GlslTypes.DO; }
while                                { return GlslTypes.WHILE; }
for                                { return GlslTypes.FOR; }
// exit control keyword
break                                { return GlslTypes.BREAK; }
continue                                { return GlslTypes.CONTINUE; }
return                                { return GlslTypes.RETURN; }
discard                                { return GlslTypes.DISCARD; }


// Other symbols ------------------------------------------------
";"                                { return GlslTypes.SEMICOLON; }
":"                                { return GlslTypes.COLON; }
"{"                                { return GlslTypes.C_BRACKET_L; }
"}"                                { return GlslTypes.C_BRACKET_R; }
"["                                { return GlslTypes.S_BRACKET_L; }
"]"                                { return GlslTypes.S_BRACKET_R; }
"("                                { return GlslTypes.PAREN_L; }
")"                                { return GlslTypes.PAREN_R; }
","                                { return GlslTypes.COMMA; }
"."                                { return GlslTypes.DOT; }
"#"                                { return GlslTypes.HASHTAG; }

// Assignment symbols --------------------------------------------
"="                     {return GlslTypes.EQUAL; }
"*="                    {return GlslTypes.MUL_ASSIGN; }
"/="                    {return GlslTypes.DIV_ASSIGN; }
"+="                    {return GlslTypes.ADD_ASSIGN; }
"-="                    {return GlslTypes.SUB_ASSIGN; }
"%="                    {return GlslTypes.MOD_ASSIGN; }
"<<="                   {return GlslTypes.LEFT_ASSIGN; }
">>="                   {return GlslTypes.RIGHT_ASSIGN; }
"&="                    {return GlslTypes.AND_ASSIGN; }
"^="                    {return GlslTypes.XOR_ASSIGN; }
"|="                    {return GlslTypes.OR_ASSIGN; }

// Non-assignment symbols --------------------------------------------
"+"                     {return GlslTypes.PLUS; }
"-"                     {return GlslTypes.DASH; }
"*"                     {return GlslTypes.STAR; }
"/"                     {return GlslTypes.SLASH; }
"%"                     {return GlslTypes.PERCENT; }
"<<"                    {return GlslTypes.LEFT_OP; }
">>"                    {return GlslTypes.RIGHT_OP; }
"&"                     {return GlslTypes.AMPERSAND; }
"^"                     {return GlslTypes.CARET; }
"|"                     {return GlslTypes.VERTICAL_BAR; }

// Relational symbols ------------------------------------------------
"=="                    {return GlslTypes.EQ_OP; }
"<"                     {return GlslTypes.ANGLE_L; }
">"                     {return GlslTypes.ANGLE_R; }
">="                    {return GlslTypes.GE_OP; }
"<="                    {return GlslTypes.LE_OP; }
"!="                    {return GlslTypes.NE_OP; }
"&&"                    {return GlslTypes.AND_OP; }
"||"                    {return GlslTypes.OR_OP; }
"^^"                    {return GlslTypes.XOR_OP; }

// Storage qualifier ------------------------------------------------
const                   {return GlslTypes.CONST; }
in                   {return GlslTypes.IN; }
out                   {return GlslTypes.OUT; }
uniform                 {return GlslTypes.UNIFORM; }
buffer                  {return GlslTypes.BUFFER; }
shared                  {return GlslTypes.SHARED; }
layout                  {return GlslTypes.LAYOUT; }
//attribute               {return GlslTypes.ATTRIBUTE; }  // drop support for deprecated keyword
//varying                 {return GlslTypes.VARYING; }

// Layout qualifier keyword?

//centroid                {return CENTROID_KEYWORD; }
//patch                   {return PATCH_KEYWORD; }
//sample                  {return SAMPLE_KEYWORD; }

<YYINITIAL> {END_OF_LINE_COMMENT}                           { return GlslTypes.COMMENT; }
<YYINITIAL> {INTEGER_CONSTANT}                                { return GlslTypes.INTEGER_CONSTANT; }
<YYINITIAL> {FLOAT_CONSTANT}                                { return GlslTypes.FLOAT_CONSTANT; }
<YYINITIAL> {IDENTIFIER}                                { return GlslTypes.IDENTIFIER; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }


[^]                                                         { return TokenType.BAD_CHARACTER; }