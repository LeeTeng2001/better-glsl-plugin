package glsl.language.references.handles;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

public class GlslInsertExtraSpaceClause implements InsertHandler<LookupElement> {
    @Override
    public void handleInsert(@NotNull InsertionContext context, @NotNull LookupElement item) {
        int tailOffset = context.getTailOffset();
        context.getDocument().insertString(tailOffset, " ");
        context.getEditor().getCaretModel().moveToOffset(tailOffset + 1);
    }
}
