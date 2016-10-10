package AnnotatedASTNodes;

import ASTNodes.ExpMod;
import SyntaxTree.SymbolicTable;
import interfaces.ASTNode;
import interfaces.AnnotatedASTNode;

public class ExpModAnnotated extends ExpMod implements AnnotatedASTNode {

    private Integer value;

    public ExpModAnnotated(AnnotatedASTNode var1, AnnotatedASTNode var2) {
        super(var1, var2);
    }

    @Override
    public Integer getHeight() {
        Integer maxChildHeight = 0;
        Integer height;

        for (ASTNode child : getChildren()) {
            AnnotatedASTNode childCasted = (AnnotatedASTNode) child;

            height = childCasted.getHeight();
            if (childCasted.getHeight() > maxChildHeight) {
                maxChildHeight = height;
            }
        }

        return maxChildHeight + 1;
    }

    @Override
    public Integer getValue(SymbolicTable symbolicTable, Integer[] currentValues) {
        if (value == null) {
            AnnotatedASTNode exp = (AnnotatedASTNode) getChildren().get(0);
            AnnotatedASTNode mod = (AnnotatedASTNode) getChildren().get(1);

            value = exp.getValue(symbolicTable, currentValues) % mod.getValue(symbolicTable, currentValues);
        }

        return value;
    }
}
