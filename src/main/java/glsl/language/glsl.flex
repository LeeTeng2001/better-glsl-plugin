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
TO_LINE_END=[^\r\n]*[\r\n]
SPACE_SEPARATOR=[\ ]+
INTEGER_CONSTANT=\d+(u|U)?
FLOAT_CONSTANT=\d*\.\d+(lf|f|F|LF)?
IDENTIFIER=[:jletter:][:jletterdigit:]*

NATIVE_VECTOR=(bvec|ivec|uvec|vec|dvec)[234]
NATIVE_MATRIX=d?mat[234](x[234])?
NATIVE_SAMPLER=[iu]?sampler([123]D|Cube|2DRect|[12]DArray|CubeArray|Buffer|2DMS(Array)?)
NATIVE_SAMPLER_SHADOW=sampler([12]D|Cube|2DRect|[12]DArray|CubeArray)Shadow
NATIVE_IMAGES=[iu]?image([123]D|Cube|2DRect|[12]DArray|CubeArray|Buffer|2DMS(Array)?)  // essentially same as sampler but with images
NATIVE_VULKAN_TEXTURE=[iu]?texture([123]D|Cube|2DRect|[12]DArray|CubeArray|Buffer|2DMS(Array)?)
NATIVE_VULKAN_TEXTURE_EXTRA=(sampler(Shadow)?)|([iu]?subpassInput(MS)?)
MACRO_GENERIC_KEYWORD=(bvec|ivec|uvec|vec|dvec)[234]

%state WAITING_VALUE
%xstate MACRO_KEYWORD
%xstate MACRO_SPACE_FIRST
%xstate MACRO_DEFINE
%xstate TO_LINE_END

%%

// Basic types --------------------------------------------
void                                { return GlslTypes.VOID; }
int                                { return GlslTypes.INT; }
uint                                { return GlslTypes.UINT; }
float                                { return GlslTypes.FLOAT; }
double                                { return GlslTypes.DOUBLE; }
bool                                { return GlslTypes.BOOL; }
struct                                { return GlslTypes.STRUCT; }

true                                { return GlslTypes.TRUE; }
false                                { return GlslTypes.FALSE; }

// Advance type
<YYINITIAL> {NATIVE_VECTOR}                                { return GlslTypes.NATIVE_VECTOR; }
<YYINITIAL> {NATIVE_MATRIX}                                { return GlslTypes.NATIVE_MATRIX; }
<YYINITIAL> {NATIVE_SAMPLER}                                { return GlslTypes.NATIVE_SAMPLER; }
<YYINITIAL> {NATIVE_SAMPLER_SHADOW}                          { return GlslTypes.NATIVE_SAMPLER; }
<YYINITIAL> {NATIVE_IMAGES}                          { return GlslTypes.NATIVE_IMAGES; }
<YYINITIAL> {NATIVE_VULKAN_TEXTURE}                          { return GlslTypes.NATIVE_VULKAN_TEXTURE; }
<YYINITIAL> {NATIVE_VULKAN_TEXTURE_EXTRA}                          { return GlslTypes.NATIVE_VULKAN_TEXTURE; }

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


// Storage qualifier ------------------------------------------------
const                   {return GlslTypes.CONST; }
in                   {return GlslTypes.IN; }
out                   {return GlslTypes.OUT; }
inout                   {return GlslTypes.INOUT; }
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

// Macro keyword ----------------------------------------------------
<MACRO_KEYWORD> {
    define               { yybegin(MACRO_SPACE_FIRST); return GlslTypes.DEFINE; }
    version               { yybegin(TO_LINE_END); return GlslTypes.VERSION; }
    include               { yybegin(TO_LINE_END); return GlslTypes.INCLUDE; }
    undef               { yybegin(TO_LINE_END); return GlslTypes.UNDEF; }
    if               { yybegin(TO_LINE_END); return GlslTypes.IF; }
    ifdef               { yybegin(TO_LINE_END); return GlslTypes.IFDEF; }
    ifndef               { yybegin(TO_LINE_END); return GlslTypes.IFNDEF; }
    else               { yybegin(TO_LINE_END); return GlslTypes.ELSE; }
    elif               { yybegin(TO_LINE_END); return GlslTypes.ELIF; }
    endif               { yybegin(TO_LINE_END); return GlslTypes.ENDIF; }
    error               { yybegin(TO_LINE_END); return GlslTypes.ERROR; }
    pragma               { yybegin(TO_LINE_END); return GlslTypes.PRAGMA; }
    extension               { yybegin(TO_LINE_END); return GlslTypes.EXTENSION; }
    line               { yybegin(TO_LINE_END); return GlslTypes.LINE; }
    {IDENTIFIER}  {yybegin(YYINITIAL); return GlslTypes.IDENTIFIER; }  // fallback
    [^]                 { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<MACRO_SPACE_FIRST> {
    {SPACE_SEPARATOR}  {yybegin(MACRO_DEFINE); return TokenType.WHITE_SPACE; }
    [^]                 { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<MACRO_DEFINE> {
    {IDENTIFIER}  {yybegin(TO_LINE_END); return GlslTypes.IDENTIFIER; }
    [^]                 { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<TO_LINE_END> {
    {TO_LINE_END} {yybegin(YYINITIAL); return GlslTypes.MACRO_TO_END; }
    [^]                 { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

// Reserved keyword for future use, result in compile time error ------------
common                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
partition                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
active                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
asm                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
class                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
union                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
enum                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
typedef                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
template                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
this                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
resource                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
goto                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
inline                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
noinline                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
public                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
static                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
extern                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
external                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
interface                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
long                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
short                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
half                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
fixed                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
unsigned                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
superp                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
input                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
output                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
hvec2                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
hvec3                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
hvec4                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
fvec2                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
fvec3                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
fvec4                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
filter                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
sizeof                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
cast                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
namespace                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
using                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }
sampler3DRect                                { return GlslTypes.RESERVED_FUTURE_KEYWORD; }


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
"#"                                { yybegin(MACRO_KEYWORD); return GlslTypes.HASHTAG; }

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

// Unary like symbols --------------------------------------------
"!"                     {return GlslTypes.EXCLAMATION; }
"++"                     {return GlslTypes.INCREMENT; }
"--"                     {return GlslTypes.DECREMENT; }

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

<YYINITIAL> {END_OF_LINE_COMMENT}                           { return GlslTypes.COMMENT; }
<YYINITIAL> {INTEGER_CONSTANT}                                { return GlslTypes.INTEGER_CONSTANT; }
<YYINITIAL> {FLOAT_CONSTANT}                                { return GlslTypes.FLOAT_CONSTANT; }
<YYINITIAL> {IDENTIFIER}                                { return GlslTypes.IDENTIFIER; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }


[^]                                                         { return TokenType.BAD_CHARACTER; }