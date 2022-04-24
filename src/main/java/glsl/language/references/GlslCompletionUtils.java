package glsl.language.references;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;

public class GlslCompletionUtils {
    public static final LookupElementBuilder[] PRIMITIVE_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("void").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("int").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("uint").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("float").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("double").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("bool").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            LookupElementBuilder.create("struct").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            // Advance type
            LookupElementBuilder.create("bvec2").withTypeText("bool vec2").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("bvec3").withTypeText("bool vec3").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("bvec4").withTypeText("bool vec4").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("ivec2").withTypeText("int vec2").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("ivec3").withTypeText("int vec3").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("ivec4").withTypeText("int vec4").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("uvec2").withTypeText("uint vec2").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("uvec3").withTypeText("uint vec3").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("uvec4").withTypeText("uint vec4").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("vec2").withTypeText("float vec2").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("vec3").withTypeText("float vec3").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("vec4").withTypeText("float vec4").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("dvec2").withTypeText("double vec2").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("dvec3").withTypeText("double vec3").withIcon(AllIcons.Nodes.Lambda),
            LookupElementBuilder.create("dvec4").withTypeText("double vec4").withIcon(AllIcons.Nodes.Lambda),
    };

    public static final LookupElementBuilder[] STORAGE_QUALIFIER_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("const").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("in").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("out").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("uniform").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("layout").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("buffer").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("shared").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
    };

    public static final LookupElementBuilder[] BUILT_IN_MACRO_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("define").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("undef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("if").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("ifdef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("ifndef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("else").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("elif").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("endif").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("error").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("pragma").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("extension").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("version").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("line").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
    };

    // TODO: Not complete
    public static final LookupElementBuilder[] LAYOUT_QUALIFIER_ID_ONLY = new LookupElementBuilder[] {
            LookupElementBuilder.create("shared").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("packed").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("std140").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("std430").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("row_major").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("column_major").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("push_constant").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("triangles").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("quads").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("isolines").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("equal_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("fractional_equal_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("fractional_odd_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("cw").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("ccw").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("point_mode").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("points").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
    };

    public static final LookupElementBuilder[] LAYOUT_QUALIFIER_ASSIGNMENT = new LookupElementBuilder[] {
            LookupElementBuilder.create("binding").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("offset").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("align").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("set").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("input_attachment_index").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("location").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("component").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            LookupElementBuilder.create("index").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
    };
}
