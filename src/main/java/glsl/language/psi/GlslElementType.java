package glsl.language.psi;

import com.intellij.psi.tree.IElementType;
import glsl.language.property.GlslLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

// This is the internal node
public class GlslElementType extends IElementType {

    public GlslElementType(@NonNls @NotNull String debugName) {
        super(debugName, GlslLanguage.INSTANCE);
    }
}
