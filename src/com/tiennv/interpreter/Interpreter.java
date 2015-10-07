package com.tiennv.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

import com.tiennv.bridge.ExpressionTree;
import com.tiennv.composite.ComponentNode;
import com.tiennv.composite.CompositeAddNode;
import com.tiennv.composite.CompositeDivideNode;
import com.tiennv.composite.CompositeMutiplyNode;
import com.tiennv.composite.CompositeNegateNode;
import com.tiennv.composite.CompositeSubtractNode;
import com.tiennv.composite.LeafNode;
import com.tiennv.factorymethod.ExpressionTreeFactory;

/**
 * @class Interpreter
 *
 * @brief Parses incoming expression strings into a parse tree and
 *        builds an expression tree from the parse tree.  This class
 *        plays the role of the "Interpreter" in the Interpreter
 *        pattern, tweaked to use the precedence of operators/operands
 *        to guide the creation of the parse tree.  It also uses the
 *        Builder pattern to build the component nodes in the
 *        Composite-based expression tree.
 */
public class Interpreter {
	
	private int multiDigitNumbers;
	private Symbol lastValidInput;
	private int accumulatedPrecedence;
	
	final static int ADD_SUB_PRECEDENCE = 1;
	final static int MUL_DIV_PRECEDENCE = 2;
	final static int NEGATE_PRECEDENCE = 3;
	final static int NUMBER_PRECEDENCE = 4;
	final static int PAREN_PRECENDENCE = 5;
	
	private ExpressionTreeFactory expressionTreeFactory;
	
    /**
     * @class SymbolTable
     * 
     * @brief This class stores variables and their values for use by
     *        the Interpreter.  It plays the role of the "Context" in
     *        the Interpreter pattern.
     */
	public class SymbolTable {
		
		private HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		public SymbolTable() {
		}
		
		public int get(String variable) {
			
			if (map.get(variable) != null) {
				return map.get(variable);
			} else {
				map.put(variable, 0);
				return map.get(variable);
			}
		}
		
		public void set(String variable, int value) {
			map.put(variable, value);
		}
		
        /** 
         * Print all variables and their values as an aid for
         * debugging.
         */
		public void print() {
			for (Iterator<Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
				Entry<String, Integer> entry = it.next();
//				Platform.instance().outputLine((x.getKey()
//                        + " = "
//                        + x.getValue()));
			}
		}
		
		public void reset() {
			map.clear();
		}
	}
	
	private SymbolTable symbolTable = new SymbolTable();
	
	public Interpreter() {
		this.expressionTreeFactory = new ExpressionTreeFactory();
	}
	
	public Interpreter(ExpressionTreeFactory expressionTreeFactory) {
		this.expressionTreeFactory = expressionTreeFactory;
	}
	
    /**
     * This method first converts a string into a parse tree and then
     * build an expression tree out of the parse tree.  It's
     * implemented using the Template Method pattern.
     */
	ExpressionTree interpret(String inputExpression) {
		Stack<Symbol> parseTree = buildParseTree(inputExpression);
		if (!parseTree.isEmpty()) {
			
			optimizeParseTree(parseTree);
			
			return buildExpressionTree(parseTree);
		}
			
		return expressionTreeFactory.makeExpressionTree(null); 
		
	}
	
    /** 
     * Invoke a recursive build of the ExpressionTree, starting with
     * the root symbol, which should be the one and only item in the
     * linked list.  The Builder pattern is used at each node to
     * create the appropriate subclass of @a ComponentNode.
     */
	public ExpressionTree buildExpressionTree(Stack<Symbol> parseTree) {
		return expressionTreeFactory.makeExpressionTree(parseTree.peek().build());
	}

    /**
     * This hook method can be overridden to conduct optimization on
     * the @a parseTree prior to generating the @a ExpressionTree.  By
     * default it's a no-op.
     */
	private void optimizeParseTree(Stack<Symbol> parseTree) {
		
	}

	public Stack<Symbol> buildParseTree(String inputExpression) {
		Stack<Symbol> parseTree = new Stack<>();
		
		lastValidInput = null;
		boolean handled = false;
		accumulatedPrecedence = 0;
		multiDigitNumbers = 0;
		
		for (int index = 0; index < inputExpression.length(); ++index) {
			parseTree = parseNextSymbol(inputExpression, index, handled, parseTree);
		}
		return null;
	}
	
	private Stack<Symbol> parseNextSymbol(String inputExpression, int index, boolean handled, Stack<Symbol> parseTree) {
		handled = false;
		if (Character.isDigit(inputExpression.charAt(index))) {
			handled = true;
			parseTree = insertNumberOrVariable(inputExpression, index, parseTree, false);
		} else if (Character.isLetterOrDigit(inputExpression.charAt(index))) {
			handled = true;
			parseTree = insertNumberOrVariable(inputExpression, index, parseTree, true);
		} else if (inputExpression.charAt(index) == '+') {
			handled = true;
			Add op = new Add();
			op.addPrecedence(accumulatedPrecedence);
			lastValidInput = null;
			
			parseTree = insertSymbolByPrecedence(op, parseTree);
		} else if (inputExpression.charAt(index) == '-') {
			handled = true;
			Symbol op = null;
			Number number = null;
			if (lastValidInput == null) {
				op = new Negate();
				op.addPrecedence(accumulatedPrecedence);
			} else {
				op = new Subtract();
				op.addPrecedence(accumulatedPrecedence);
			}
			lastValidInput = null;
			parseTree = insertSymbolByPrecedence(op, parseTree);
		} else if (inputExpression.charAt(index) == '/') {
			
		} else if (inputExpression.charAt(index) == '*') {
			
		} else if (inputExpression.charAt(index) == '(') {
			
		} else if (inputExpression.charAt(index) == ' ' || inputExpression.charAt(index) == '\n') {
			handled = true;
		}
		return parseTree;
	}

	private Stack<Symbol> insertSymbolByPrecedence(Symbol op,
			Stack<Symbol> parseTree) {
		return null;
	}

	private Stack<Symbol> insertNumberOrVariable(String inputExpression, int index, Stack<Symbol> parseTree,
			boolean b) {
		return null;
	}

    /**
     * @class Symbol
     *
     * @brief Base class for the various parse tree subclasses.
     */
	abstract class Symbol {

		protected int precedence = 0;
		
		protected Symbol left;
		
		protected Symbol right;
		
		public Symbol(Symbol left, Symbol right, int precedence) {
			this.left = left;
			this.right = right;
			this.precedence = precedence;
		}
		
		public int precedence() {
			return precedence;
		}
		
		public abstract int addPrecedence(int accumulatedPrecedence);
		
		abstract ComponentNode build();
		
	}
	
	class Number extends Symbol {

		private int item;
		
		public Number(String input) {
			super(null, null, NUMBER_PRECEDENCE);
			item = Integer.parseInt(input);
		}
		
		public Number(int input) {
			super(null, null, NUMBER_PRECEDENCE);
			item = input;
		}
		
		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = NUMBER_PRECEDENCE + accumulatedPrecedence;
		}
		
		@Override
		public int precedence() {
			return precedence;
		}

		@Override
		ComponentNode build() {
			return new LeafNode(item);
		}
	}
	
    /**
     * @class Operator
     *
     * @brief Defines a base class in the parse tree for operator
     *        non-terminal expressions.
     */
	public abstract class Operator extends Symbol {
		public Operator(Symbol left, Symbol right, int precedence) {
			super(left, right, precedence);
		}
	}
	
	public abstract class UnaryOperator extends Symbol {
		public UnaryOperator(Symbol right, int precedence) {
			super(right, right, precedence);
		}
		
		abstract ComponentNode build();
	}
	
    /**
     * @class Negate
     *
     * @brief Defines a node in the parse tree for unary minus
     *        operator non-terminal expression.
     */
	class Negate extends UnaryOperator {

		public Negate() {
			super(null, NEGATE_PRECEDENCE);
		}

		@Override
		ComponentNode build() {
			return new CompositeNegateNode(right.build());
		}

		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = NEGATE_PRECEDENCE + accumulatedPrecedence;
		}
		
		@Override
		public int precedence() {
			return precedence;
		}
	}
	
	class Add extends Operator {

		public Add() {
			super(null, null, ADD_SUB_PRECEDENCE);
		}

		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = ADD_SUB_PRECEDENCE + accumulatedPrecedence;
		}

		@Override
		public int precedence() {
			return precedence;
		}
		
		@Override
		ComponentNode build() {
			return new CompositeAddNode(left.build(), right.build());
		}
		
	}
	
	class Subtract extends Operator {

		public Subtract() {
			super(null, null, ADD_SUB_PRECEDENCE);
		}

		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = ADD_SUB_PRECEDENCE + accumulatedPrecedence;
		}

		@Override
		public int precedence() {
			return precedence;
		}
		
		@Override
		ComponentNode build() {
			return new CompositeSubtractNode(left.build(), right.build());
		}
	}
	
	class Multiply extends Operator {
		
		public Multiply() {
			super(null, null, MUL_DIV_PRECEDENCE);
		}

		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = MUL_DIV_PRECEDENCE + accumulatedPrecedence;
		}

		@Override
		ComponentNode build() {
			return new CompositeMutiplyNode(left.build(), right.build());
		}
		
		@Override
		public int precedence() {
			return precedence;
		}
	}
	
	class Divide extends Operator {
		
        public Divide() {
            super(null, null, MUL_DIV_PRECEDENCE);
        }

        /** Returns the current precedence. */
        public int precedence() {
            return precedence;
        }

        /** Adds precedence to its current value. */
        @Override
        public int addPrecedence(int accumulatedPrecedence) {
            return precedence = 
                MUL_DIV_PRECEDENCE + accumulatedPrecedence;
        }

        ComponentNode build() {
            return new CompositeDivideNode(left.build(),
                                           right.build());
        }


	}
	
	
}
