package com.tiennv.bridge;

import com.tiennv.composite.ComponentNode;
import com.tiennv.visitor.Visitor;

public class IntrustmentedExpressionTree extends ExpressionTree {

	public IntrustmentedExpressionTree(ComponentNode root) {
		super(root);
	}

	@Override
    public void accept(Visitor visitor) {
        System.out.println("starting accept() call");
        super.accept(visitor);
        System.out.println("finished accept() call");
    }
}
