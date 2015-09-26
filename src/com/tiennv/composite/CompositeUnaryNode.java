package com.tiennv.composite;

public class CompositeUnaryNode extends ComponentNode {
	
	private ComponentNode right;
	
	public CompositeUnaryNode(ComponentNode right) {
		this.right = right;
	}
	
	@Override
	public ComponentNode right() {
		return this.right;
	}
}
