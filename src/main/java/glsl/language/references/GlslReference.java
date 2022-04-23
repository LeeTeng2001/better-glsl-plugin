package glsl.language.references;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import glsl.language.utility.GlslUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GlslReference extends PsiReferenceBase<PsiElement> {
    public GlslReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiElement psdd;
        var eleReference = myElement.getReference();
        return eleReference != null ? eleReference.getElement() : null;
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