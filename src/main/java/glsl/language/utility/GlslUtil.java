package glsl.language.utility;

import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.GlslVarNameOriginFunc;
import glsl.language.psi.GlslVarNameOriginStruct;
import glsl.language.psi.GlslVarNameOriginVariable;

import java.util.ArrayList;
import java.util.List;

public class GlslUtil {
    public static List<GlslVarNameOriginStruct> findDefinedStruct(PsiFile glslFile, int curAt) {
        List<GlslVarNameOriginStruct> result = new ArrayList<>();
        // Not sure about performance of findChildren vs getChildren, virtual file vs custom language file
        if (glslFile != null) {
            var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginStruct.class);
            for (var node : declarations) {
                if (node.getTextOffset() < curAt) {
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static List<GlslVarNameOriginFunc> findDefinedFunctions(PsiFile glslFile, int curAt) {
        List<GlslVarNameOriginFunc> result = new ArrayList<>();
        // Not sure about performance of findChildren vs getChildren, virtual file vs custom language file
        if (glslFile != null) {
            var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginFunc.class);
            for (var node : declarations) {
                if (node.getTextOffset() < curAt) {
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static List<GlslVarNameOriginVariable> findDefinedVariables(PsiFile glslFile, int curAt) {
        List<GlslVarNameOriginVariable> result = new ArrayList<>();
        // Not sure about performance of findChildren vs getChildren, virtual file vs custom language file
        if (glslFile != null) {
            var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginVariable.class);
            for (var node : declarations) {
                if (node.getTextOffset() < curAt) {
                    result.add(node);
                }
            }
        }
        return result;
    }
}
