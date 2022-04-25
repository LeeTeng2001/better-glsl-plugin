package glsl.language.utility.livetemplate;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class GlslFileContext extends TemplateContextType {
    protected GlslFileContext() {
        super("GLSL", "Glsl shader file");
    }

    // Which file should trigger the life templates
    @Override
    public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getName().endsWith(".glsl") ||
                templateActionContext.getFile().getName().endsWith(".vert") ||
                templateActionContext.getFile().getName().endsWith(".frag");
    }
}
