package glsl.language.references;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import glsl.language.psi.GlslFile;
import glsl.language.psi.GlslTypes;
import glsl.language.psi.GlslVarNameOriginStruct;
import glsl.language.utility.GlslStdLibraryProvider;
import glsl.language.utility.GlslSyntaxHighlighter;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

public class GlslAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        var node = element.getNode();

        // Get identifier that's being use as a type node
        if (node.getElementType().equals(GlslTypes.VAR_NAME_TYPE)) {
            // It has an identifier class type, highlight it
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(GlslSyntaxHighlighter.KEY)
                    .create();

            var definedStruct = GlslUtil.findDefinedStruct(element.getContainingFile(), element.getTextOffset());
            boolean isDefined = false;
            GlslVarNameOriginStruct defined = null;

            var myText = element.getText();
            for (var struct : definedStruct) {
                var structName = struct.getText();
                if (structName != null && structName.equals(myText)) {
                    isDefined = true;
                    defined = struct;
                    break;
                }
            }

            // Usage of undefined type
            if (!isDefined) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined type")
                        .range(element)
                        .create();
            }
        }
        else if (node.getElementType().equals(GlslTypes.VAR_NAME_ACCESS_FUNC) ||
                node.getElementType().equals(GlslTypes.VAR_NAME_ACCESS_VAR)) {
            var resolve = node.getPsi().getReference();
            assert resolve != null;

            if (!resolve.getElement().getNode().equals(node)) {
                GlslFile stdGlslFile = (GlslFile) PsiManager.getInstance(node.getPsi().getProject()).findFile(GlslStdLibraryProvider.stdLibFiles.get(0));
                // We have a reference, check if it's coming from standard library
                if (resolve.getElement().getContainingFile().equals(stdGlslFile)) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(element)
                            .textAttributes(GlslSyntaxHighlighter.FROM_STANDARD_LIB)
                            .create();
                }
                return;
            }

            // Undefined function/variable access
            String message = node.getElementType().equals(GlslTypes.VAR_NAME_ACCESS_FUNC) ?
                    "Call to undefined function" : "Call to undefined variable";
            holder.newAnnotation(HighlightSeverity.ERROR, message)
                    .range(element)
                    .create();
        }
        else if (node.getElementType().equals(GlslTypes.MACRO)) {
            // Highlight keyword in macro
            var hashTag = node.findChildByType(GlslTypes.HASHTAG);
            var id = node.findChildByType(GlslTypes.IDENTIFIER);

            if (hashTag != null) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(hashTag)
                        .textAttributes(GlslSyntaxHighlighter.KEY)
                        .create();
            }
            if (id != null) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(id)
                        .textAttributes(GlslSyntaxHighlighter.KEY)
                        .create();
            }
        }
    }
}
