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
import glsl.language.psi.GlslFile;
import glsl.language.psi.GlslProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GlslUtil {
    /**
     * Searches the entire project for Simple language files with instances of the Simple property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<GlslProperty> findProperties(Project project, String key) {
        List<GlslProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(GlslFileType.INSTANCE, GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            GlslFile simpleFile = (GlslFile) PsiManager.getInstance(project).findFile(virtualFile);

            if (simpleFile != null) {
                GlslProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, GlslProperty.class);
                if (properties != null) {
                    for (GlslProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static List<GlslProperty> findProperties(Project project) {
        List<GlslProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(GlslFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GlslFile simpleFile = (GlslFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                GlslProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, GlslProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    /**
     * Attempts to collect any comment elements above the Simple key/value pair.
     */
    public static @NotNull String findDocumentationComment(GlslProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result),"\n ");
    }
}
