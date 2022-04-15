package glsl.language.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import glsl.language.property.GlslFileType;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslFile;

public class GlslElementFactory {
    public static GlslDeclaration createDeclaration(Project project, String name) {
        GlslFile file = createFile(project, name);
        return (GlslDeclaration) file.getFirstChild();
    }

    public static GlslFile createFile(Project project, String text) {
        String name = "dummy.glsl";
        return (GlslFile) PsiFileFactory.getInstance(project).createFileFromText(name, GlslFileType.INSTANCE, text);
    }
}
