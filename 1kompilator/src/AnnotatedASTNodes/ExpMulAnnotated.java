package AnnotatedASTNodes;

import ASTNodes.ExpMul;
import interfaces.ASTNode;
import interfaces.AnnotatedAST;
import interfaces.AnnotatedASTNode;

public class ExpMulAnnotated extends ExpMul implements AnnotatedASTNode {

    public ExpMulAnnotated() {
    }

    public ExpMulAnnotated(AnnotatedASTNode var1, AnnotatedASTNode var2) {
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
}
