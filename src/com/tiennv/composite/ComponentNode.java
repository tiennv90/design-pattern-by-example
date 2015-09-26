package com.tiennv.composite;

public abstract class ComponentNode {

	public int item() {
		throw new UnsupportedOperationException(
				"Component Node::item called improperly");
	}

	public ComponentNode right() {
		return null;
	}

	public ComponentNode left() {
		return null;
	}

	public void accept() {
		throw new UnsupportedOperationException(
				"ComponentNode::accept called improperly");
	}
}
