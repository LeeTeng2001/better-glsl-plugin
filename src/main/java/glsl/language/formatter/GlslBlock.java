package glsl.language.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import glsl.language.psi.GlslTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GlslBlock extends AbstractBlock {
    private final boolean childShouldIndent;
    private final SpacingBuilder spacingBuilder;
    private final Indent indent;

    protected GlslBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, Indent indent, SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
        this.indent = indent;
        childShouldIndent = node.getElementType().equals(GlslTypes.FUNCTION_DEFINITION) ||
                            node.getElementType().equals(GlslTypes.STRUCT_DEFINITION);
    }

    // Important method to build children
    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();

        // Add indentation for content inside braces
        boolean hasBraces = false;
        while (child != null) {
            if (child.getElementType().equals(GlslTypes.C_BRACKET_L)) hasBraces = true;
            else if (child.getElementType().equals(GlslTypes.C_BRACKET_R)) hasBraces = false;

            if (child.getElementType() != TokenType.WHITE_SPACE) {
                Block block = new GlslBlock(child,
                        Wrap.createWrap(WrapType.NONE, false),
                        Alignment.createAlignment(),
                        hasBraces ? Indent.getNormalIndent() : Indent.getNoneIndent(),
                        spacingBuilder);
                blocks.add(block);
            }

            child = child.getTreeNext();
        }

        return blocks;
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @Override
    public Indent getIndent() {
        return indent;
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        // Add indentation if we're inside block that contains curly braces
        return new ChildAttributes(childShouldIndent ? Indent.getNormalIndent() : Indent.getNoneIndent(), null);
    }
}
