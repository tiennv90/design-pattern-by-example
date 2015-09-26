package com.tiennv.composite;

public class CompositeNegateNode extends CompositeUnaryNode {

	public CompositeNegateNode(ComponentNode right) {
		super(right);
	}

	@Override
	public int item() {
		return '-';
	}
	
	@Override
	public void accept() {
		super.accept();
	}
}
