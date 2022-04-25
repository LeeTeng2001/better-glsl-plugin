package glsl.language.psi.stub;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.Key;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import glsl.language.property.GlslFileType;
import glsl.language.property.GlslLanguage;
import org.jetbrains.annotations.NotNull;

public class GlslPsiFile extends PsiFileBase {
//    private static Key<Object> KEY_CACHED_MODULE_NAME = Key.create("glsl.file.std");;

    public GlslPsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GlslLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return GlslFileType.INSTANCE;
    }

//    private String findCachedModule() {
//        return CachedValuesManager.getCachedValue(this,  {
//                CachedValueProvider.Result.create(findModuleName(), this);
//        }) ;
//    }
}
