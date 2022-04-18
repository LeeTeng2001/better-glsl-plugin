package glsl.language.utility;

import com.intellij.psi.tree.IElementType;
import glsl.language.psi.GlslTypes;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Group terminal tokens into utility group
public class GlslGroupTypes {
    public static final Set<IElementType> PRIMITIVE_TYPES_KEYWORDS = Stream.of(
            GlslTypes.VOID,
            GlslTypes.INT,
            GlslTypes.UINT,
            GlslTypes.FLOAT,
            GlslTypes.DOUBLE,
            GlslTypes.BOOL,
            GlslTypes.STRUCT
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> STORAGE_QUALIFIER_KEYWORDS = Stream.of(
            GlslTypes.CONST,
            GlslTypes.IN,
            GlslTypes.OUT,
            GlslTypes.ATTRIBUTE,
            GlslTypes.UNIFORM,
            GlslTypes.VARYING,
            GlslTypes.BUFFER,
            GlslTypes.SHARED
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> ASSIGNMENT_OP_KEYWORDS = Stream.of(
            GlslTypes.EQ_OP,
            GlslTypes.ANGLE_L,
            GlslTypes.ANGLE_R,
            GlslTypes.GE_OP,
            GlslTypes.LE_OP,
            GlslTypes.NE_OP,
            GlslTypes.AND_OP,
            GlslTypes.OR_OP,
            GlslTypes.XOR_OP
    ).collect(Collectors.toUnmodifiableSet());
}
