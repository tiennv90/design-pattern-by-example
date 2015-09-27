package com.tiennv.visitor;

import com.tiennv.composite.ComponentNode;

public interface Visitor {
	public void visit(ComponentNode node);
}
