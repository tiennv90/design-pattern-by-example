package com.tiennv.composite;

public class CompositeSubtractNode extends CompositeBinaryNode {

	public CompositeSubtractNode(ComponentNode right, ComponentNode left) {
		super(right, left);
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
