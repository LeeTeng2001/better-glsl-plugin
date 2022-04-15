package glsl.language.utility;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

public class GlslCompletionContributor extends CompletionContributor {
    public GlslCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(GlslTypes.VALUE), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {



                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                        resultSet.addElement(LookupElementBuilder.create("Peter"));
                    }
                }
        );
    }
}
