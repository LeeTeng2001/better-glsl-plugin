package glsl.language.utility;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons.Nodes;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;
import static com.intellij.patterns.PlatformPatterns.psiElement;

public class GlslCompletionContributor extends CompletionContributor {
    private static LookupElementBuilder[] PRIMITIVE_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("int").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("float").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("bool").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("void").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("struct").withTypeText("primitive").withIcon(Nodes.Type),
    };

    public GlslCompletionContributor() {
        System.out.println("ONCE!");

        extend(CompletionType.BASIC, psiElement(GlslTypes.IDENTIFIER), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Add primitives
                        for (var elementBuilder : PRIMITIVE_LOOKUP) {
                            resultSet.addElement(elementBuilder);
                        }

                        // Add struct type
                        var definedStruct = GlslUtil.findDefinedStruct(parameters.getEditor().getProject());
                        var curPrefix = resultSet.getPrefixMatcher().getPrefix();
                        for (var struct : definedStruct) {
                            if (struct.getName().startsWith(curPrefix)) {
                                resultSet.addElement(LookupElementBuilder.create(struct.getName())
                                        .withTypeText("struct type").withIcon(Nodes.Class));
                            }
                        }

                        // TODO: Add variable lookup

                        // TODO: Add function lookup


                        // TODO: Add built in function
                    }
                }
        );

    }
}
