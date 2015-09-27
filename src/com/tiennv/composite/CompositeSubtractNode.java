package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeSubtractNode extends CompositeBinaryNode {

	public CompositeSubtractNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}
	
	@Override
	public int item() {
		return '-';
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
