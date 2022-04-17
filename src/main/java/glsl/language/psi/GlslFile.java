package glsl.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import glsl.language.property.GlslFileType;
import glsl.language.property.GlslLanguage;
import org.jetbrains.annotations.NotNull;

public class GlslFile extends PsiFileBase {

    public GlslFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GlslLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return GlslFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Glsl File";
    }
}
