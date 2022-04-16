package glsl.language.property;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GlslFileType extends LanguageFileType {
    public static final GlslFileType INSTANCE = new GlslFileType();

    private GlslFileType() {
        super(GlslLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Glsl Shader File";
    }

    @Override
    @NotNull
    public String getDescription() {
        return "Glsl shader language version 330 or 450/460";
    }

    @Override
    @NotNull
    public String getDefaultExtension() {
        return "glsl";
    }

    @Override
    @Nullable
    public Icon getIcon() {
        return GlslIcons.FILE;
    }
}
