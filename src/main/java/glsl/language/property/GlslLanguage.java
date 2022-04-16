package glsl.language.property;

import com.intellij.lang.Language;

public class GlslLanguage extends Language {
    public static final GlslLanguage INSTANCE = new GlslLanguage();

    private GlslLanguage() {
        super("Glsl");
    }
}
