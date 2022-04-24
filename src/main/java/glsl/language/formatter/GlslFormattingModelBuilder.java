package glsl.language.formatter;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import glsl.language.property.GlslLanguage;
import org.jetbrains.annotations.NotNull;

import static glsl.language.psi.GlslTypes.*;

// reference: https://github.com/Benjamin-Dobell/IntelliJ-Luanalysis/blob/0b53e920af6f1e56a9e39f2ba57a77dde93055f7/src/main/java/com/tang/intellij/lua/editor/formatter/LuaFormattingModelBuilder.kt
public class GlslFormattingModelBuilder implements FormattingModelBuilder {
    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new GlslBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                Indent.getNoneIndent(),
                                createSpaceBuilder(codeStyleSettings)), codeStyleSettings);
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, GlslLanguage.INSTANCE)
                .after(C_BRACKET_L).lineBreakInCode()
                .before(C_BRACKET_R).lineBreakInCode()
                .after(S_BRACKET_L).none()
                .before(S_BRACKET_R).none()
                .after(PAREN_L).none()
                .before(PAREN_R).none();
    }
}
