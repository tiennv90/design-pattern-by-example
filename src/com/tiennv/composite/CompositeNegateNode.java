package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeNegateNode extends CompositeUnaryNode {

	public CompositeNegateNode(ComponentNode right) {
		super(right);
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
