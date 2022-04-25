package glsl.language.psi.stub;

import com.intellij.lang.Language;
import com.intellij.psi.stubs.PsiFileStubImpl;
import com.intellij.psi.tree.IStubFileElementType;
import glsl.language.property.GlslLanguage;

public class GlslFileStub extends PsiFileStubImpl<GlslPsiFile> {
    public GlslFileStub(GlslPsiFile file) {
        super(file);
    }
}

class LuaFileElementType extends IStubFileElementType<GlslFileStub> {
    public LuaFileElementType() {
        super(GlslLanguage.INSTANCE);
    }
}