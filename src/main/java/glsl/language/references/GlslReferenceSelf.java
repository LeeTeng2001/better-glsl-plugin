package glsl.language.references;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlslReferenceSelf extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    public GlslReferenceSelf(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        var eleReference = myElement.getReference();
        return eleReference != null ? new ResolveResult[]{new PsiElementResolveResult(eleReference.getElement())}
                : new ResolveResult[0];
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }
}