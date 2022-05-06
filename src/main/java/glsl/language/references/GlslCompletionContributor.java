package glsl.language.references;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.icons.AllIcons.Nodes;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import glsl.language.references.handles.GlslCallClause;
import glsl.language.references.handles.GlslIncludeClause;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;

import static com.intellij.codeInsight.lookup.LookupElementBuilder.create;
import static com.intellij.patterns.PlatformPatterns.psiElement;
import static glsl.language.references.GlslCompletionUtils.*;

public class GlslCompletionContributor extends CompletionContributor {

    public GlslCompletionContributor() {
        // Completion for type
        extend(CompletionType.BASIC, psiElement(GlslTypes.IDENTIFIER), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        var node = parameters.getPosition();
                        var nodeParentType = node.getParent().getNode().getElementType();
//                        System.out.println("Cur nod parent: " + nodeParentType);
                        var lookBack = node.getPrevSibling();
                        var lookBackType = lookBack == null ? GlslTypes.NULL_TOKEN : lookBack.getNode().getElementType();
//                        System.out.println("Step back: " + 1 + ", " + lookBack + ", " + lookBackType);

                        // Only add prefix, for built-in type, we hardly want to match everything by context
                        // contextText has IntellijIdeaRulezzz to prevent empty string
                        var cursorText = node.getText().replace("IntellijIdeaRulezzz", "").toLowerCase();
//                        System.out.println(cursorText);

                        // Stop if we have numeric number or empty string
                        if (cursorText.isEmpty() || cursorText.matches("(\\+-)?\\d+(\\.\\d+)?"))
                            return;

                        // Look max 2 step behind (skip whitespace token)
                        for (int i = 0; i < 1; i++) {
                            if (lookBack == null) break;
                            // No completion if we already have primitive/identifier types before us, or we're
                            // an implementation origin identifier, or we're preceded by assignment operator
                            if (GlslGroupTypes.PRIMITIVE_TYPES_KEYWORDS.contains(lookBackType) ||
                                    lookBackType.equals(GlslTypes.IDENTIFIER) ||
                                    GlslGroupTypes.ASSIGNMENT_OP_KEYWORDS.contains(lookBackType)
                            ) return;

                            lookBack = lookBack.getPrevSibling();
                            lookBackType = lookBack == null ? GlslTypes.NULL_TOKEN : lookBack.getNode().getElementType();
//                            System.out.println("Step back: " + (i + 2) + ", " + lookBack + ", " + lookBackType);
                        }

                        // only add types & qualifier if we're not access variable
                        if (!nodeParentType.equals(GlslTypes.VAR_NAME_ACCESS_VAR)) {
                            // Add primitive types and extra keyword based on context
                            addMatchingPrefixOnly(cursorText, resultSet, PRIMITIVE_LOOKUP_STRING, PRIMITIVE_LOOKUP);
                            addExtraByContext(cursorText, resultSet);

                            // Add storage qualifier only if we do not have preceding storage qualifier
                            if (!GlslGroupTypes.STORAGE_QUALIFIER_KEYWORDS.contains(lookBackType)) {
                                addMatchingPrefixOnly(cursorText, resultSet, STORAGE_QUALIFIER_LOOKUP_STRING, STORAGE_QUALIFIER_LOOKUP);
                            }

                            // Add struct names
                            var definedStruct = GlslUtil.findDefinedStruct(node.getContainingFile(), node.getTextOffset());
                            for (var struct : definedStruct) {
                                resultSet.addElement(LookupElementBuilder.create(struct.getText())
                                        .withTypeText("struct").withIcon(Nodes.Class));
                            }
                        }

                        // Add general expression

                        // Add functions
                        var definedFunc = GlslUtil.findDefinedFunctions(node.getContainingFile(), node.getTextOffset());
                        var callClause = new GlslCallClause();
                        for (var func : definedFunc) {
                            resultSet.addElement(LookupElementBuilder.create(func.getText()).withInsertHandler(callClause)
                                    .withTypeText("user func").withIcon(Nodes.Function));
                        }

                        // Add variables
                        var definedVariables = GlslUtil.findDefinedVariables(node.getContainingFile(), node.getTextOffset());
                        for (var variable : definedVariables) {
                            resultSet.addElement(LookupElementBuilder.create(variable.getText())
                                    .withTypeText("variable").withIcon(Nodes.Variable));
                        }
                    }
                }
        );


        // Macro definition
        extend(CompletionType.BASIC, psiElement().afterLeaf(psiElement(GlslTypes.HASHTAG)), new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        var includeClause = new GlslIncludeClause();
                        for (var elementBuilder : BUILT_IN_MACRO_LOOKUP) {
                            resultSet.addElement(elementBuilder);
                        }
                        // Special keyword
                        resultSet.addElement(create("include").withTypeText("macro include").withInsertHandler(includeClause)
                                .withIcon(AllIcons.Nodes.Controller));
                    }
                }
        );
    }
}
