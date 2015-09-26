package com.tiennv.composite;

public class CompositeDivideNode extends CompositeBinaryNode {
	
	public CompositeDivideNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}

	@Override
	public int item() {
		return '/';
	}

	@Override
	public void accept() {
		super.accept();
	}
}
