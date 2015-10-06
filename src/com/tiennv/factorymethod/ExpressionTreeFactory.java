package com.tiennv.factorymethod;

import com.tiennv.bridge.ExpressionTree;
import com.tiennv.composite.ComponentNode;

public class ExpressionTreeFactory {
	public ExpressionTree makeExpressionTree(ComponentNode componentNodeRoot) {
		return new ExpressionTree(componentNodeRoot);
	}
}
