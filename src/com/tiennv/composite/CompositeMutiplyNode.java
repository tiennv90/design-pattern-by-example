package com.tiennv.composite;

public class CompositeMutiplyNode extends CompositeBinaryNode {
	
	public CompositeMutiplyNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}

	@Override
	public int item() {
		return '*';
	}

	@Override
	public void accept() {
		super.accept();
	}
	
}
