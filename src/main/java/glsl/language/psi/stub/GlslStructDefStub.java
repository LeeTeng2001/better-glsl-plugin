package glsl.language.psi.stub;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import glsl.language.psi.GlslVarNameOriginStruct;
import kotlin.Pair;

import java.util.ArrayList;

public interface GlslStructDefStub extends StubElement<GlslVarNameOriginStruct> {
    String getName();  // name of this struct
    ArrayList<Pair<String, String>> getMembers();  // type, id
}
