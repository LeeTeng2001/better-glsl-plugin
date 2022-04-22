package glsl.language.references;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class GlslReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(psiElement(GlslTypes.VAR_NAME_TYPE),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        return new GlslReference[]{new GlslReference(element, new TextRange(0, element.getText().length()))};
                    }
//                PsiReferenceRegistrar.HIGHER_PRIORITY  // specify priority
                }
        );

        registrar.registerReferenceProvider(psiElement(GlslTypes.VAR_NAME_ACCESS),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        return new GlslReference[]{new GlslReference(element, new TextRange(0, element.getText().length()))};
                    }
//                PsiReferenceRegistrar.HIGHER_PRIORITY  // specify priority
                }
        );

        registrar.registerReferenceProvider(psiElement(GlslTypes.VAR_NAME_ORIGIN_STRUCT),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        return new GlslReferenceSelf[]{new GlslReferenceSelf(element, new TextRange(0, element.getText().length()))};
                    }
//                PsiReferenceRegistrar.HIGHER_PRIORITY  // specify priority
                }
        );

        registrar.registerReferenceProvider(psiElement(GlslTypes.VAR_NAME_ORIGIN_VARIABLE),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        return new GlslReferenceSelf[]{new GlslReferenceSelf(element, new TextRange(0, element.getText().length()))};
                    }
//                PsiReferenceRegistrar.HIGHER_PRIORITY  // specify priority
                }
        );

        registrar.registerReferenceProvider(psiElement(GlslTypes.VAR_NAME_ORIGIN_FUNC),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        return new GlslReferenceSelf[]{new GlslReferenceSelf(element, new TextRange(0, element.getText().length()))};
                    }
//                PsiReferenceRegistrar.HIGHER_PRIORITY  // specify priority
                }
        );
    }
}
