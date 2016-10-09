package AnnotatedASTNodes;

import ASTNodes.ExpDiv;
import interfaces.ASTNode;
import interfaces.AnnotatedASTNode;

public class ExpDivAnnotated extends ExpDiv implements AnnotatedASTNode {

    public ExpDivAnnotated(AnnotatedASTNode var1, AnnotatedASTNode var2) {
        super(var1, var2);
    }

    public ExpDivAnnotated() {
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