package com.tiennv.bridge;

import com.tiennv.composite.ComponentNode;
import com.tiennv.visitor.Visitor;

public class ExpressionTree {
	
	protected ComponentNode root= null;
	
	public ExpressionTree(ComponentNode root) {
		this.root = root;
	}
	
	public boolean isNull() {
		return (root == null);
	}
	
	public ComponentNode getRoot() {
		return root;
	}
	
	public ExpressionTree left() {
		return new ExpressionTree(root.left());
	}
	
	public ExpressionTree right() {
		return new ExpressionTree(root.right());
	}
	
	public int item() throws Exception {
		return root.item();
	}
	
	public void accept(Visitor visitor) {
		root.accept(visitor);
	}
	
}
