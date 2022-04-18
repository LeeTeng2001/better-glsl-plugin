package glsl.language.references;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GlslReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    public GlslReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
//        var project = myElement.getProject();
        var eleReference = myElement.getReference();
        if (eleReference != null)
            return new ResolveResult[]{new PsiElementResolveResult(eleReference.getElement())};
        else return new ResolveResult[0];
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }


    // TODO: Feel like getVariants doesn't work that well, might try again in the future
//    @Override
//    public Object @NotNull [] getVariants() {
//        var definedStruct = GlslUtil.findDefinedStruct(myElement.getContainingFile());
//        List<LookupElement> variants = new ArrayList<>();
//
////        System.out.println("Variant calling ");
//        for (var struct : definedStruct) {
//            variants.add(LookupElementBuilder.create(struct)
//                    .withIcon(AllIcons.Nodes.Class)
//                    .withTypeText("struct")
//            );
//        }
//
//        return variants.toArray();
//    }

}