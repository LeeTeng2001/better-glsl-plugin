package glsl.language.property;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class GlslFileType extends LanguageFileType {
    public static final GlslFileType INSTANCE = new GlslFileType();
//    public static final Set<String> EXTENSIONS = new HashSet<>();
//
//    static {
//        EXTENSIONS.add("glsl");
//        EXTENSIONS.add("vert");
//        EXTENSIONS.add("frag");
//        EXTENSIONS.add("fsh");
//        EXTENSIONS.add("vsh");
//        EXTENSIONS.add("tesc");
//        EXTENSIONS.add("tese");
//        EXTENSIONS.add("geom");
//        EXTENSIONS.add("comp");
//        EXTENSIONS.add("shader");
//    }

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
