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
//        System.out.println(psiElement(GlslTypes.IDENTIFIER).withParent(psiElement(GlslTypes.IDENTIFIER_TYPE)));
//        System.out.println(psiElement().withParent(psiElement(GlslTypes.IDENTIFIER_TYPE)));
//        System.out.println(psiElement(GlslTypes.IDENTIFIER));


        extend(CompletionType.BASIC, psiElement(GlslTypes.IDENTIFIER), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        System.out.println(parameters);
                        System.out.println(parameters.getPosition().getOriginalElement());
                        System.out.println(parameters.getPosition().getParent().getOriginalElement());
//                        if (!context.toString().equals("xd")) return;

                        var definedStruct = GlslUtil.findDefinedStruct(parameters.getEditor().getProject());
                        definedStruct.add("int");
                        definedStruct.add("float");

                        System.out.println(definedStruct);
                        var curPrefix = resultSet.getPrefixMatcher().getPrefix();
                        for (var structName : definedStruct) {
                            if (structName.startsWith(curPrefix)) {
                                resultSet.addElement(LookupElementBuilder.create(structName));
                            }
                        }
                    }
                }
        );

    }
}
