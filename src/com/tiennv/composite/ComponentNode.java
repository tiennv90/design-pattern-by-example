package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

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

	public void accept(Visitor visitor) {
		throw new UnsupportedOperationException(
				"ComponentNode::accept called improperly");
	}
}
