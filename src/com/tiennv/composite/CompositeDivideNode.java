package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeDivideNode extends CompositeBinaryNode {
	
	public CompositeDivideNode(ComponentNode left, ComponentNode right) {
		super(left, right);
	}

	@Override
	public int item() {
		return '/';
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
