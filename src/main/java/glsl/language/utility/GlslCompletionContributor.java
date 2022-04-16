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
            LookupElementBuilder.create("void").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("int").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("uint").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("float").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("double").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("bool").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("struct").withTypeText("primitive").withIcon(Nodes.Type),
    };

    private static LookupElementBuilder[] STORAGE_QUALIFIER_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("const").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("in").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("out").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("attribute").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("uniform").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("varying").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("buffer").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("shared").withTypeText("primitive").withIcon(Nodes.Type),
    };

    public GlslCompletionContributor() {
//        System.out.println("ONCE!");

        // Completion for type
        extend(CompletionType.BASIC, psiElement(GlslTypes.IDENTIFIER), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Look 2 step behind
                        var lookBack2 = parameters.getOriginalPosition();
                        for (int i = 0; i < 2; i++) {
                            if (lookBack2 != null)
                                lookBack2 = lookBack2.getPrevSibling();
                        }

                        // No completion if we already have type
                        if (lookBack2 != null && (GlslGroupTypes.PRIMITIVE_TYPES_KEYWORDS.contains(lookBack2.getNode().getElementType()) ||
                                lookBack2.getNode().getElementType().equals(GlslTypes.IDENTIFIER)))
                            return;

                        // Add primitive types
                        for (var elementBuilder : PRIMITIVE_LOOKUP) {
                            resultSet.addElement(elementBuilder);
                        }

                        // Add struct names
                        var definedStruct = GlslUtil.findDefinedStruct(parameters.getEditor().getProject());
                        var curPrefix = resultSet.getPrefixMatcher().getPrefix();
                        for (var struct : definedStruct) {
                            resultSet.addElement(LookupElementBuilder.create(struct.getName())
                                    .withTypeText("struct").withIcon(Nodes.Class));
                        }

                        // Add storage qualifier only if we do not have preceding storage qualifier
                        if (lookBack2 == null || !GlslGroupTypes.STORAGE_QUALIFIER_KEYWORDS.contains(lookBack2.getNode().getElementType())) {
                            for (var elementBuilder : STORAGE_QUALIFIER_LOOKUP) {
                                resultSet.addElement(elementBuilder);
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
