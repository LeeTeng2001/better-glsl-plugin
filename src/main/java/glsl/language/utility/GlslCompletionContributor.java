package glsl.language.utility;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;
import static com.intellij.patterns.PlatformPatterns.psiElement;

public class GlslCompletionContributor extends CompletionContributor {
    public GlslCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(GlslTypes.IDENTIFIER), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
//                        System.out.println(parameters);
//                        System.out.println(parameters.getPosition().getOriginalElement());
//                        System.out.println(parameters.getPosition().getParent().getOriginalElement());
//                        if (!context.toString().equals("xd")) return;

                        resultSet.addElement(LookupElementBuilder.create("int").withTypeText("pri"));
                        resultSet.addElement(LookupElementBuilder.create("float").withTypeText("pri"));
                        resultSet.addElement(LookupElementBuilder.create("bool").withTypeText("pri"));
                        resultSet.addElement(LookupElementBuilder.create("void").withTypeText("pri"));
                        resultSet.addElement(LookupElementBuilder.create("struct").withTypeText("pri"));

                        var definedStruct = GlslUtil.findDefinedStruct(parameters.getEditor().getProject());
//                        System.out.println(definedStruct);
                        var curPrefix = resultSet.getPrefixMatcher().getPrefix();
                        for (var struct : definedStruct) {
                            if (struct.getName().startsWith(curPrefix)) {
                                resultSet.addElement(LookupElementBuilder.create(struct.getName()).withTypeText("struct"));
                            }
                        }
                    }
                }
        );

    }
}
