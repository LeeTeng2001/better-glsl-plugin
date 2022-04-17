package glsl.language.utility;

//import com.intellij.psi.PsiLiteralExpression;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import glsl.language.psi.GlslDeclaration;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

public class GlslAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        var node = element.getNode();

        // Custom class
        if (node.getElementType().equals(GlslTypes.VARIABLE_DEFINITION)) {
            var declarationType = node.findChildByType(GlslTypes.IDENTIFIER_TYPE);
            if (declarationType == null) return;
            var selfClassNode = declarationType.findChildByType(GlslTypes.IDENTIFIER);
            if (selfClassNode == null) return;

            // It has an identifier class type, highlight it
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(selfClassNode)
                    .textAttributes(GlslSyntaxHighlighter.KEY)
                    .create();

            var definedStruct = GlslUtil.findDefinedStruct(element.getProject());
            boolean isDefined = false;
            GlslDeclaration defined = null;
            for (var struct : definedStruct) {
                var structName = struct.getName();
                if (structName != null && structName.equals(selfClassNode.getText())) {
                    isDefined = true;
                    defined = struct;
                    break;
                }
            }

            // Not defined struct
            if (!isDefined) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Undefined type")
                        .range(selfClassNode)
                        .create();
                return;
            }

            // Use before define struct
            if (defined.getTextOffset() > element.getTextOffset()) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Use before declaration")
                        .range(selfClassNode)
                        .create();
                return;
            }
        }
    }
}
