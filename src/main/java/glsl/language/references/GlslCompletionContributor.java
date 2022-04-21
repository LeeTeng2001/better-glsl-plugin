package glsl.language.references;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons.Nodes;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class GlslCompletionContributor extends CompletionContributor {
    private static final LookupElementBuilder[] PRIMITIVE_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("void").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("int").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("uint").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("float").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("double").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("bool").withTypeText("primitive").withIcon(Nodes.Type),
            LookupElementBuilder.create("struct").withTypeText("primitive").withIcon(Nodes.Type),
    };

    private static final LookupElementBuilder[] STORAGE_QUALIFIER_LOOKUP = new LookupElementBuilder[] {
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
                        var node = parameters.getPosition();
                        var nodeParentType = node.getParent().getNode().getElementType();
                        var lookBack = node;
                        // Look 2 step behind (skip whitespace token)
                        for (int i = 0; i < 2; i++) {
                            if (lookBack != null)
                                lookBack = lookBack.getPrevSibling();
                        }
                        var lookBackType = lookBack == null ? GlslTypes.NULL_TOKEN : lookBack.getNode().getElementType();

                        // No completion if we already have primitive/identifier types before us, or we're
                        // an implementation origin identifier, or we're preceded by assignment operator
                        if (GlslGroupTypes.PRIMITIVE_TYPES_KEYWORDS.contains(lookBackType) ||
                                lookBackType.equals(GlslTypes.IDENTIFIER) ||
                                GlslGroupTypes.ASSIGNMENT_OP_KEYWORDS.contains(lookBackType) ||
                                GlslGroupTypes.IDENTIFIER_ORIGIN.contains(nodeParentType) ||
                                GlslTypes.INIT_VAL.equals(nodeParentType)
                        ) return;

                        // Add primitive types
                        for (var elementBuilder : PRIMITIVE_LOOKUP) {
                            resultSet.addElement(elementBuilder);
                        }

                        // Add struct names
                        var definedStruct = GlslUtil.findDefinedStruct(node.getContainingFile());
                        for (var struct : definedStruct) {
                            resultSet.addElement(LookupElementBuilder.create(struct.getText())
                                    .withTypeText("struct").withIcon(Nodes.Class));
                        }

                        // Add storage qualifier only if we do not have preceding storage qualifier
                        if (!GlslGroupTypes.STORAGE_QUALIFIER_KEYWORDS.contains(lookBackType)) {
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
