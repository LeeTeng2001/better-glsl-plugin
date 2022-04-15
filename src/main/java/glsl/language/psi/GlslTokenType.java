package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import glsl.language.GlslLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GlslTokenType extends IElementType {
    public GlslTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GlslLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "GlslTokenType." + super.toString();
    }
}
