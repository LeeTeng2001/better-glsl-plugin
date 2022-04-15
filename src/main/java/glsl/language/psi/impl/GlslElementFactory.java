package glsl.language.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import glsl.language.property.GlslFileType;
import glsl.language.psi.GlslFile;
import glsl.language.psi.GlslProperty;

public class GlslElementFactory {
    public static GlslProperty createProperty(Project project, String name) {
        GlslFile file = createFile(project, name);
        return (GlslProperty) file.getFirstChild();
    }

    public static GlslFile createFile(Project project, String text) {
        String name = "dummy.glsl";
        return (GlslFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, GlslFileType.INSTANCE, text);
    }
}
