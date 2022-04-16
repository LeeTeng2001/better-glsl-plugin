package glsl.language.utility;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import glsl.language.property.GlslIcons;
import glsl.language.psi.GlslProperty;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GlslReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String myType;

    public GlslReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        var typeNode = element.getNode().getFirstChildNode().findChildByType(GlslTypes.IDENTIFIER_TYPE);
        if (typeNode != null) {
//            System.out.println(typeNode.getText());
            myType = typeNode.getText();
        }
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        if (myType == null) return new ResolveResult[0];

        var project = myElement.getProject();
        var definedStruct = GlslUtil.findDefinedStruct(project);
        List<ResolveResult> results = new ArrayList<>();

        // Find exact match for complete code
        for (var struct : definedStruct) {
            if (!incompleteCode) {
                var name = struct.getName();
                if (name == null) continue;
                if (name.equals(myType)) return new ResolveResult[]{new PsiElementResolveResult(struct)};
            }
            else results.add(new PsiElementResolveResult(struct));
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

        System.out.println("Variant: " + myType);
        for (var struct : definedStruct) {
            var name = struct.getName();
            if (name == null) continue;

            variants.add(LookupElementBuilder.create(name)
                    .withIcon(AllIcons.Nodes.Class)
                    .withTypeText("struct")
            );
        }

        return variants.toArray();
    }

}