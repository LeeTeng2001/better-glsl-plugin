package glsl.language.utility;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.ProcessingContext;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class GlslReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {


        registrar.registerReferenceProvider(psiElement(GlslTypes.DECLARATION),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
//                        System.out.println(element);
//                        System.out.println(element.getFirstChild().getNode().getText());
                        return new GlslReference[]{new GlslReference(element, new TextRange(0, element.getText().length()))};
                    }
                }
//                PsiReferenceRegistrar.HIGHER_PRIORITY
        );
    }
}