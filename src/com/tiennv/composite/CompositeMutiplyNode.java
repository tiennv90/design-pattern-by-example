package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class CompositeMutiplyNode extends CompositeBinaryNode {
	
	public CompositeMutiplyNode(ComponentNode left, ComponentNode right) {
		super(left, right);
	}

	@Override
	public int item() {
		return '*';
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
