package com.tiennv.bridge;

import com.tiennv.composite.ComponentNode;
import com.tiennv.visitor.Visitor;

public class ExpressionTree {
	
	protected ComponentNode root= null;
	
	public ExpressionTree(ComponentNode root) {
		this.root = root;
	}
	
	public void accept(Visitor visitor) {
		root.accept(visitor);
	}
}
