package glsl.language.utility;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import glsl.language.property.GlslFileType;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslFile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GlslUtil {
    public static List<GlslDeclaration> findDefinedStruct(Project project) {
        List<GlslDeclaration> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(GlslFileType.INSTANCE, GlobalSearchScope.allScope(project));

        // Get all defined struct
        for (VirtualFile virtualFile : virtualFiles) {
            GlslFile glslFile = (GlslFile) PsiManager.getInstance(project).findFile(virtualFile);

            if (glslFile != null) {
                GlslDeclaration[] declarations = PsiTreeUtil.getChildrenOfType(glslFile, GlslDeclaration.class);
                if (declarations != null) {
                    for (var declare: declarations) {
                        if (declare.getStructDefinition() != null)
                            result.add(declare);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Attempts to collect any comment elements above the Simple key/value pair.
     */
//    public static @NotNull String findDocumentationComment(GlslProperty property) {
//        List<String> result = new LinkedList<>();
//        PsiElement element = property.getPrevSibling();
//        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
//            if (element instanceof PsiComment) {
//                String commentText = element.getText().replaceFirst("//+", "");
//                result.add(commentText);
//            }
//            element = element.getPrevSibling();
//        }
//        return StringUtil.join(Lists.reverse(result),"\n ");
//    }


}
