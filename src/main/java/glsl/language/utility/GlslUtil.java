package glsl.language.utility;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.property.GlslFileType;
import glsl.language.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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

    public static List<GlslVarNameOriginVariable> findDefinedVariables(PsiFile glslFile) {
        List<GlslVarNameOriginVariable> result = new ArrayList<>();
        // Not sure about performance of findChildren vs getChildren, virtual file vs custom language file
        if (glslFile != null) {
            var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginVariable.class);
            result.addAll(declarations);
        }
        return result;
    }
}
