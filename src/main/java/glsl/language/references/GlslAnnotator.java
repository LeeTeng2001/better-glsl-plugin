package glsl.language.references;

//import com.intellij.psi.PsiLiteralExpression;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslTypes;
import glsl.language.psi.GlslVarNameOriginStruct;
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
        else if (node.getElementType().equals(GlslTypes.VAR_NAME_ACCESS_FUNC)) {
            var resolve = node.getPsi().getReference();
            assert resolve != null;
            if (!resolve.getElement().getNode().equals(node)) return;

            // Undefined function access
            holder.newAnnotation(HighlightSeverity.ERROR, "Call to undefined function")
                    .range(element)
                    .create();
        }
    }
}
