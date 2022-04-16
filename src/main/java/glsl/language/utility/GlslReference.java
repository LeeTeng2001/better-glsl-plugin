package glsl.language.utility;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import glsl.language.property.GlslIcons;
import glsl.language.psi.GlslProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GlslReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String myType;

    public GlslReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
//        myType = element.getFirstChild()
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        var project = myElement.getProject();
        var definedStruct = GlslUtil.findDefinedStruct(project);
        List<ResolveResult> results = new ArrayList<>();

        for (var struct : definedStruct) {
//            if (!incompleteCode && )
            results.add(new PsiElementResolveResult(struct));
        }

        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);

        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        var definedStruct = GlslUtil.findDefinedStruct(project);
        List<LookupElement> variants = new ArrayList<>();

        for (var struct : definedStruct) {
            variants.add(LookupElementBuilder.create(struct)
                    .withIcon(AllIcons.Nodes.Class)
                    .withTypeText("struct")
            );
        }

        return variants.toArray();
    }

}