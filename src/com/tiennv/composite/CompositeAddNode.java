package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeAddNode extends CompositeBinaryNode {

	public CompositeAddNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}

	@Override
	public int item() {
		return '+';
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
