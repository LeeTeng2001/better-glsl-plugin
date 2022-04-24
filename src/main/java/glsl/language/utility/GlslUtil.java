package glsl.language.utility;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.property.GlslFileType;
import glsl.language.psi.GlslFile;
import glsl.language.psi.GlslVarNameOriginFunc;
import glsl.language.psi.GlslVarNameOriginStruct;
import glsl.language.psi.GlslVarNameOriginVariable;
import org.apache.tools.ant.types.selectors.TypeSelector;

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
        GlslFile stdGlslFile = (GlslFile) PsiManager.getInstance(glslFile.getProject()).findFile(GlslStdLibraryProvider.stdLibFiles.get(0));

        var functionsStd = PsiTreeUtil.findChildrenOfType(stdGlslFile, GlslVarNameOriginFunc.class);
        var functions = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginFunc.class);

        List<GlslVarNameOriginFunc> result = new ArrayList<>(functionsStd);

        for (var node : functions) {
            if (node.getTextOffset() < curAt) {
                result.add(node);
            }
        }

        return result;
    }

    public static List<GlslVarNameOriginVariable> findDefinedVariables(PsiFile glslFile, int curAt) {
        GlslFile stdGlslFile = (GlslFile) PsiManager.getInstance(glslFile.getProject()).findFile(GlslStdLibraryProvider.stdLibFiles.get(0));

        // Not sure about performance impact of findChildren vs getChildren, virtual file vs custom language file
        var declarationsStd = PsiTreeUtil.findChildrenOfType(stdGlslFile, GlslVarNameOriginVariable.class);
        var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginVariable.class);

        List<GlslVarNameOriginVariable> result = new ArrayList<>(declarationsStd);

        // Filter by current cursor position in current file
        for (var node : declarations) {
            if (node.getTextOffset() < curAt) {
                result.add(node);
            }
        }

        return result;
    }
}
