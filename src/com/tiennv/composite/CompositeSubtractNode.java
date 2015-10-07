package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeSubtractNode extends CompositeBinaryNode {

	public CompositeSubtractNode(ComponentNode left, ComponentNode right) {
		super(left, right);
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
