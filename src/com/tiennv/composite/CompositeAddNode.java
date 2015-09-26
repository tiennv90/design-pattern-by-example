package com.tiennv.composite;

public class CompositeAddNode extends CompositeBinaryNode {

	public CompositeAddNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}

	@Override
	public int item() {
		return '+';
	}
	
	@Override
	public void accept() {
		super.accept();
	}
}
