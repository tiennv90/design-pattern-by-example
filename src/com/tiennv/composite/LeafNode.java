package com.tiennv.composite;

public class LeafNode extends ComponentNode {
	private int item;
	
	public LeafNode(int item) {
		this.item = item;
	}
	
	@Override
	public int item() {
		return item;
	}
	
	@Override
	public void accept() {
		//will improve in future
	}
}
