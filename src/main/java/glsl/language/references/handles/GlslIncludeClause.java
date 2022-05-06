package glsl.language.references.handles;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

// Reference: https://www.tabnine.com/web/assistant/code/rs/5c76b5f496b4b300015c1caa#L22
// Define how the auto complete should be performed
public class GlslIncludeClause implements InsertHandler<LookupElement> {
    @Override
    public void handleInsert(@NotNull InsertionContext context, @NotNull LookupElement item) {
        int tailOffset = context.getTailOffset();
        Document document = context.getDocument();
        int documentTextLength = document.getTextLength();
        boolean insertAngle;

        if (documentTextLength > tailOffset) {
            String currentTail = document.getText(new TextRange(tailOffset, tailOffset + 1));
            char firstChar = currentTail.charAt(0);
            insertAngle = firstChar != '<';
        } else {
            insertAngle = true;
        }

        if (insertAngle) {
            context.getDocument().insertString(tailOffset, " <>");
            context.getEditor().getCaretModel().moveToOffset(tailOffset + 2);  // + 1 to put between the `(`  and `)`
        }
    }
}
