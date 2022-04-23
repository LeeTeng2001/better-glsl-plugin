package glsl.language.psi.impl;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import glsl.language.psi.GlslVarNameOriginStruct;
import glsl.language.psi.stub.GlslStructDefStub;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class GlslStructDefStubImpl extends StubBase<GlslVarNameOriginStruct> implements GlslStructDefStub {
    protected GlslStructDefStubImpl(@Nullable StubElement parent, IStubElementType elementType) {
        super(parent, elementType);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ArrayList<Pair<String, String>> getMembers() {
        return null;
    }
}
