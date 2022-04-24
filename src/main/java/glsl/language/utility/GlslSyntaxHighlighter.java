package glsl.language.utility;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import glsl.language.GlslLexerAdapter;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static glsl.language.references.GlslGroupTypes.*;

public class GlslSyntaxHighlighter extends SyntaxHighlighterBase {
    // Define the color attribute for token group, second arg is fallback
    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("GLSL_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("GLSL_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FROM_STANDARD_LIB =
            createTextAttributesKey("GLSL_STD_LIB", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("GLSL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("GLSL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("GLSL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    // color group?
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new GlslLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        // Use token group utility to determine which token belongs to which group
        if (ASSIGNMENT_OP_KEYWORDS.contains(tokenType)) {
            return OPERATOR_KEYS;
        }
        if (PRIMITIVE_TYPES_KEYWORDS.contains(tokenType) | STORAGE_QUALIFIER_KEYWORDS.contains(tokenType)) {
            return KEY_KEYS;
        }
        if (tokenType.equals(GlslTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        }
        if (tokenType.equals(GlslTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }

        return EMPTY_KEYS;
    }
}
