package glsl.language.references;

import com.intellij.psi.tree.IElementType;
import glsl.language.psi.GlslTypes;

import javax.xml.bind.util.ValidationEventCollector;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static glsl.language.psi.GlslTypes.*;

// Group terminal tokens into utility group
public class GlslGroupTypes {
    public static final Set<IElementType> PRIMITIVE_TYPES_KEYWORDS = Stream.of(
            VOID,
            INT,
            UINT,
            FLOAT,
            DOUBLE,
            BOOL,
            NATIVE_VECTOR,
            NATIVE_MATRIX,
            STRUCT
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> STORAGE_QUALIFIER_KEYWORDS = Stream.of(
            CONST,
            IN,
            OUT,
            UNIFORM,
            BUFFER,
            SHARED,
            LAYOUT
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> CONTROL_FLOW_KEYWORDS = Stream.of(
            IF,
            ELSE,
            SWITCH,
            CASE,
            DEFAULT,
            DO,
            WHILE,
            FOR,
            BREAK,
            CONTINUE,
            RETURN,
            DISCARD
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> ASSIGNMENT_OP_KEYWORDS = Stream.of(
            EQ_OP,
            ANGLE_L,
            ANGLE_R,
            GE_OP,
            LE_OP,
            NE_OP,
            AND_OP,
            OR_OP,
            XOR_OP
    ).collect(Collectors.toUnmodifiableSet());

    public static final Set<IElementType> IDENTIFIER_ORIGIN = Stream.of(
            VAR_NAME_ORIGIN_STRUCT,
            VAR_NAME_ORIGIN_FUNC,
            VAR_NAME_ORIGIN_VARIABLE
    ).collect(Collectors.toUnmodifiableSet());
}
