package glsl.language.references;

import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import glsl.language.references.handles.GlslCallClause;
import glsl.language.references.handles.GlslInsertExtraSpaceClause;

import java.util.ArrayList;

import static com.intellij.codeInsight.lookup.LookupElementBuilder.create;

public class GlslCompletionUtils {
    public static final String[] PRIMITIVE_LOOKUP_STRING = new String[]{
            "void", "int", "uint", "float", "double", "bool", "struct", "bvec2", "bvec3",
            "bvec4", "ivec2", "ivec3", "ivec4", "uvec2", "uvec3", "uvec4", "vec2", "vec3",
            "vec4", "dvec2", "dvec3", "dvec4", "mat1", "mat2", "mat3", "mat4", "dmat1",
            "dmat2", "dmat3", "dmat4"
    };

    public static final LookupElementBuilder[] PRIMITIVE_LOOKUP = new LookupElementBuilder[] {
            create("void").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("int").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("uint").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("float").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("double").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("bool").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            create("struct").withTypeText("primitive").withIcon(AllIcons.Nodes.Type),
            // Advance built in type
            create("bvec2").withTypeText("bool vec2").withIcon(AllIcons.Nodes.Lambda),
            create("bvec3").withTypeText("bool vec3").withIcon(AllIcons.Nodes.Lambda),
            create("bvec4").withTypeText("bool vec4").withIcon(AllIcons.Nodes.Lambda),
            create("ivec2").withTypeText("int vec2").withIcon(AllIcons.Nodes.Lambda),
            create("ivec3").withTypeText("int vec3").withIcon(AllIcons.Nodes.Lambda),
            create("ivec4").withTypeText("int vec4").withIcon(AllIcons.Nodes.Lambda),
            create("uvec2").withTypeText("uint vec2").withIcon(AllIcons.Nodes.Lambda),
            create("uvec3").withTypeText("uint vec3").withIcon(AllIcons.Nodes.Lambda),
            create("uvec4").withTypeText("uint vec4").withIcon(AllIcons.Nodes.Lambda),
            create("vec2").withTypeText("float vec2").withIcon(AllIcons.Nodes.Lambda),
            create("vec3").withTypeText("float vec3").withIcon(AllIcons.Nodes.Lambda),
            create("vec4").withTypeText("float vec4").withIcon(AllIcons.Nodes.Lambda),
            create("dvec2").withTypeText("double vec2").withIcon(AllIcons.Nodes.Lambda),
            create("dvec3").withTypeText("double vec3").withIcon(AllIcons.Nodes.Lambda),
            create("dvec4").withTypeText("double vec4").withIcon(AllIcons.Nodes.Lambda),
            // Matrix, I fell like people don't use n * m matrix a lot?
            create("mat1").withTypeText("1x1 f matrix").withIcon(AllIcons.Nodes.Lambda),
            create("mat2").withTypeText("2x2 f matrix").withIcon(AllIcons.Nodes.Lambda),
            create("mat3").withTypeText("3x3 f matrix").withIcon(AllIcons.Nodes.Lambda),
            create("mat4").withTypeText("4x4 f matrix").withIcon(AllIcons.Nodes.Lambda),
            create("dmat1").withTypeText("1x1 d matrix").withIcon(AllIcons.Nodes.Lambda),
            create("dmat2").withTypeText("2x2 d matrix").withIcon(AllIcons.Nodes.Lambda),
            create("dmat3").withTypeText("3x3 d matrix").withIcon(AllIcons.Nodes.Lambda),
            create("dmat4").withTypeText("4x4 d matrix").withIcon(AllIcons.Nodes.Lambda),
    };

    public static final String[] STORAGE_QUALIFIER_LOOKUP_STRING = new String[]{
            "const", "in", "out", "inout", "uniform", "layout", "buffer", "shared"
    };

    public static final LookupElementBuilder[] STORAGE_QUALIFIER_LOOKUP = new LookupElementBuilder[] {
            create("const").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("in").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("out").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("inout").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("uniform").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("layout").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("buffer").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
            create("shared").withTypeText("storage qualifier").withIcon(AllIcons.Nodes.Controller),
    };

    public static final LookupElementBuilder[] BUILT_IN_MACRO_LOOKUP = new LookupElementBuilder[] {
            create("define").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("undef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("if").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("ifdef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("ifndef").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("else").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("elif").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("endif").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("error").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("pragma").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("extension").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("version").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
            create("line").withTypeText("built in macro").withIcon(AllIcons.Nodes.Controller),
    };

//    public static final String[]

    public static final String[] LAYOUT_QUALIFIER_ID_ONLY_STRING = new String[]{
            "shared", "packed", "std140", "std430", "row_major", "column_major", "push_constant",
            "triangles", "quads", "isolines", "equal_spacing", "fractional_equal_spacing",
            "fractional_odd_spacing", "cw", "ccw", "point_mode", "points"
    };

    // TODO: Not complete
    public static final LookupElementBuilder[] LAYOUT_QUALIFIER_ID_ONLY = new LookupElementBuilder[] {
            create("shared").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("packed").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("std140").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("std430").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("row_major").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("column_major").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("push_constant").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("triangles").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("quads").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("isolines").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("equal_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("fractional_equal_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("fractional_odd_spacing").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("cw").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("ccw").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("point_mode").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
            create("points").withTypeText("layoutQ id only").withIcon(AllIcons.Nodes.Controller),
    };

    public static final String[] LAYOUT_QUALIFIER_ASSIGNMENT_STRING = new String[]{
            "binding", "offset", "align", "set", "input_attachment_index", "location", "component", "index"
    };

    public static final LookupElementBuilder[] LAYOUT_QUALIFIER_ASSIGNMENT = new LookupElementBuilder[] {
            create("binding").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("offset").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("align").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("set").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("input_attachment_index").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("location").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("component").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
            create("index").withTypeText("layoutQ assignment").withIcon(AllIcons.Nodes.Controller),
    };

    // [iu]?texture([123]D|Cube|2DRect|[12]DArray|CubeArray|Buffer|2DMS(Array)?)
    public static final String[] TEXT_POSTFIX = new String[]{
            "1D", "2D", "3D", "Cube", "2DRect", "1DArray", "2DArray", "CubeArray",
            "Buffer", "2DMS", "2DMSArray"
    };

    private static final GlslInsertExtraSpaceClause extraSpaceHandle = new GlslInsertExtraSpaceClause();

    public static void addMatchingPrefixOnly(String curPrefix, CompletionResultSet addTo, final String[] lookupStrings, final LookupElementBuilder[] lookupElements) {
        if (lookupStrings.length != lookupElements.length) {
            System.err.println("lookup string != lookup elements");
        }

        for (int i = 0; i < lookupStrings.length; i++) {
            if (lookupStrings[i].startsWith(curPrefix)) {
                addTo.addElement(lookupElements[i].withInsertHandler(extraSpaceHandle));
            }
        }
    }
    public static void addExtraByContext(String curPrefix, CompletionResultSet addTo) {
        var sandwichKeyword = new ArrayList<String>();

        // User are likely searching for those if they contain or prefix is.
        if ("texture".startsWith(curPrefix))
            sandwichKeyword.add("texture");
        if ("utexture".startsWith(curPrefix))
            sandwichKeyword.add("utexture");
        if ("itexture".startsWith(curPrefix))
            sandwichKeyword.add("itexture");
        if ("sampler".startsWith(curPrefix))
            sandwichKeyword.add("sampler");
        if ("usampler".startsWith(curPrefix))
            sandwichKeyword.add("usampler");
        if ("isampler".startsWith(curPrefix))
            sandwichKeyword.add("isampler");
        if ("image".startsWith(curPrefix))
            sandwichKeyword.add("image");
        if ("uimage".startsWith(curPrefix))
            sandwichKeyword.add("uimage");
        if ("iimage".startsWith(curPrefix))
            sandwichKeyword.add("iimage");

//        System.out.println("Generating for: " + curPrefix);
        for (String pref : sandwichKeyword) {
            for (String textPostfix : TEXT_POSTFIX) {
                addTo.addElement(LookupElementBuilder.create(pref + textPostfix)
                        .withTypeText(pref).withIcon(AllIcons.Nodes.Type)
                        .withInsertHandler(extraSpaceHandle));
            }
        }
//        System.out.println("Generating Done");
    }
}
