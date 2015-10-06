package com.tiennv.bridge;

import com.tiennv.composite.ComponentNode;
import com.tiennv.visitor.Visitor;

public class IntrustmentedExpressionTree extends ExpressionTree {

	public IntrustmentedExpressionTree(ComponentNode root) {
		super(root);
	}

	@Override
	public boolean isNull() {
		System.out.println("starting isNull() call");
		boolean temp = super.isNull();
		System.out.println("finish isNull() call");
		return temp;
	}
	@Override
    public void accept(Visitor visitor) {
        System.out.println("starting accept() call");
        super.accept(visitor);
        System.out.println("finished accept() call");
    }
	
	@Override
	public ComponentNode getRoot() {
		System.out.println("starting getRoot() call");
		ComponentNode temp = root;
		System.out.println("finished getRoot() call");
		return temp;
	}
	
	public int item() throws Exception {
		System.out.println("starting item() call");
		int temp = super.item();
		System.out.println("finish item() call");
		return temp;
	}
	
    public ExpressionTree left() {
        System.out.println("starting left() call");
        ExpressionTree temp = super.left();
        System.out.println("finished right() call");
        return temp;
    }

    public ExpressionTree right() {
        System.out.println("starting right() call");
        ExpressionTree temp = super.right();
        System.out.println("finished right() call");
        return temp;
    }

}
