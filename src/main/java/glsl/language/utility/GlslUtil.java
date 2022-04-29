package glsl.language.utility;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PsiModificationTracker;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.psi.*;

import java.util.ArrayList;
import java.util.Collection;
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
        var functionsStd = getStdLibFunctions(glslFile.getProject());
        var functions = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginFunc.class);

        List<GlslVarNameOriginFunc> result = new ArrayList<>();

        // Add local first, then global
        for (var node : functions) {
            if (node.getTextOffset() < curAt) {
                result.add(node);
            }
        }
        result.addAll(functionsStd);

        return result;
    }

    public static List<GlslVarNameOriginVariable> findDefinedVariables(PsiFile glslFile, int curAt) {
        // Not sure about performance impact of findChildren vs getChildren, virtual file vs custom language file
        var declarationsStd = getStdLibVariables(glslFile.getProject());
        var declarations = PsiTreeUtil.findChildrenOfType(glslFile, GlslVarNameOriginVariable.class);

        List<GlslVarNameOriginVariable> result = new ArrayList<>();

        // Filter by current cursor position in current file
        for (var node : declarations) {
            if (node.getTextOffset() < curAt) {
                result.add(node);
            }
        }
        result.addAll(declarationsStd);

        return result;
    }

    // TODO: Custom cache because idk how to use stub and cache manager
    private static Collection<GlslVarNameOriginVariable> stdLibVariables;
    private static Collection<GlslVarNameOriginFunc> stdLibFunctions;

    private static Collection<GlslVarNameOriginVariable> getStdLibVariables(Project project) {
        if (stdLibVariables != null) return stdLibVariables;
        GlslFile stdGlslFile = (GlslFile) PsiManager.getInstance(project).findFile(GlslStdLibraryProvider.stdLibFiles.get(0));
        stdLibVariables = PsiTreeUtil.findChildrenOfType(stdGlslFile, GlslVarNameOriginVariable.class);

        // Filter global variable node only
        List<GlslVarNameOriginVariable> result = new ArrayList<>();
        for (var node : stdLibVariables) {
            if (!node.getParent().getNode().getElementType().equals(GlslTypes.FUNCTION_ARGS)) {
                result.add(node);
            }
        }
        stdLibVariables = result;

        return stdLibVariables;
    }

    private static Collection<GlslVarNameOriginFunc> getStdLibFunctions(Project project) {
        if (stdLibFunctions != null) return stdLibFunctions;
        GlslFile stdGlslFile = (GlslFile) PsiManager.getInstance(project).findFile(GlslStdLibraryProvider.stdLibFiles.get(0));
        stdLibFunctions = PsiTreeUtil.findChildrenOfType(stdGlslFile, GlslVarNameOriginFunc.class);
        return stdLibFunctions;
    }

//    private void buildCaches(Project project) {
//        final CachedValuesManager manager = CachedValuesManager.getManager(project);
//        final Object[] dependencies = {PsiModificationTracker.MODIFICATION_COUNT};
//    }
}
