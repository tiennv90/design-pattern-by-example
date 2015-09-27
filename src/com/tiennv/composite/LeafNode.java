package com.tiennv.composite;

import com.tiennv.visitor.Visitor;

public class LeafNode extends ComponentNode {
	private int item;
	
	public LeafNode(int item) {
		this.item = item;
	}
	
	@Override
	public int item() {
		return item;
	}
	
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
