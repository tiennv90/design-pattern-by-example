package com.tiennv.composite;

public class CompositeBinaryNode extends CompositeUnaryNode {

	private ComponentNode left;
	
	public CompositeBinaryNode(ComponentNode left, ComponentNode right) {
		super(right);
		this.left = left;
	}
	
	@Override
	public ComponentNode left() {
		return left;
	}
	
}
