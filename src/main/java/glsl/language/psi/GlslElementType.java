package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import glsl.language.GlslLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GlslElementType extends IElementType {

    public GlslElementType(@NonNls @NotNull String debugName) {
        super(debugName, GlslLanguage.INSTANCE);
    }
}
