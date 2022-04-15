package glsl.language;

import com.intellij.lexer.FlexAdapter;

public class GlslLexerAdapter extends FlexAdapter {
    public GlslLexerAdapter() {
        super(new GlslLexer(null));
    }
}
