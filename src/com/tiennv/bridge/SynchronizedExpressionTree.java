package com.tiennv.bridge;

import com.tiennv.composite.ComponentNode;
import com.tiennv.visitor.Visitor;

public class SynchronizedExpressionTree extends ExpressionTree {

	public SynchronizedExpressionTree(ComponentNode root) {
		super(root);
	}

	public boolean isNull() {
		boolean temp;
		synchronized (this) {
			temp = super.isNull();
		}
		return temp;
	}
	
	@Override
	public ComponentNode getRoot() {
		ComponentNode temp;
		synchronized (this) {
			temp = root;
		}
		return temp;
	}
	
	public int item() throws Exception {
		int temp;
		synchronized (this) {
			temp = super.item();
		}
		return temp;
	}
	
    public ExpressionTree left() {
        ExpressionTree temp;
        synchronized(this) {
            temp = super.left();
        }
        return temp;
    }

    public ExpressionTree right() {
        ExpressionTree temp;
        synchronized(this) {
            temp = super.right();
        }
        return temp;
    }

    public void accept(Visitor visitor) {
        synchronized(this) {
            super.accept(visitor);
        }
    }
}
