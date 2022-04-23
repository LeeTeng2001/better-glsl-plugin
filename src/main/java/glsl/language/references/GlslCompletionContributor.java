package glsl.language.references;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons.Nodes;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

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
            LookupElementBuilder.create("const").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("in").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("out").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("attribute").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("uniform").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("varying").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("buffer").withTypeText("storage qualifier").withIcon(Nodes.Controller),
            LookupElementBuilder.create("shared").withTypeText("storage qualifier").withIcon(Nodes.Controller),
    };

    private static final LookupElementBuilder[] BUILT_IN_MACRO_LOOKUP = new LookupElementBuilder[] {
            LookupElementBuilder.create("version").withTypeText("built in macro").withIcon(Nodes.Controller),
            LookupElementBuilder.create("extension").withTypeText("built in macro").withIcon(Nodes.Controller),
            LookupElementBuilder.create("line").withTypeText("built in macro").withIcon(Nodes.Controller),
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
                            if (lookBack == null) break;

                            // Macro definition
                            if (lookBack.getNode().getElementType().equals(GlslTypes.HASHTAG)) {
                                for (var elementBuilder : BUILT_IN_MACRO_LOOKUP) {
                                    resultSet.addElement(elementBuilder);
                                }
                                return;
                            }

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

                        // Add storage qualifier only if we do not have preceding storage qualifier
                        if (!GlslGroupTypes.STORAGE_QUALIFIER_KEYWORDS.contains(lookBackType)) {
                            for (var elementBuilder : STORAGE_QUALIFIER_LOOKUP) {
                                resultSet.addElement(elementBuilder);
                            }
                        }

                        // Add struct names
                        var definedStruct = GlslUtil.findDefinedStruct(node.getContainingFile(), node.getTextOffset());
                        for (var struct : definedStruct) {
                            resultSet.addElement(LookupElementBuilder.create(struct.getText())
                                    .withTypeText("struct").withIcon(Nodes.Class));
                        }

                        // Add functions
                        var definedFunc = GlslUtil.findDefinedFunctions(node.getContainingFile(), node.getTextOffset());
                        for (var func : definedFunc) {
                            resultSet.addElement(LookupElementBuilder.create(func.getText())
                                    .withTypeText("user func").withIcon(Nodes.Function));
                        }

                        // Add variables
                        var definedVariables = GlslUtil.findDefinedVariables(node.getContainingFile(), node.getTextOffset());
                        for (var variable : definedVariables) {
                            resultSet.addElement(LookupElementBuilder.create(variable.getText())
                                    .withTypeText("variable").withIcon(Nodes.Variable));
                        }

                        // TODO: Add built in function
                    }
                }
        );


    }
}
