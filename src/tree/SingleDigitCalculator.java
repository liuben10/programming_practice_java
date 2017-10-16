package tree;

/**
 * Created by liuben10 on 10/12/17.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

Write a function/method that takes a mathematical expression represented as a string and returns the value of the expression.

The expression is written in infix notation (number operator number) with a single space between operators and operands.

You only need to support four operations: addition, subtraction, division and multiplication (+ - * /)

No parenthesis.

Valid input:
"15 + 2 - 3" -> 14
"145" -> 145
"1 + 233 / 233 * 2 - 3" -> 1
            -
          /   3
        +
      /   \
    15     2
 */

class SingleDigitCalculator {

	public static Map<Character, Integer> ops = new HashMap<>();

	static {
		ops.put('+', 1);
		ops.put('-', 2);
		ops.put('/', 3);
		ops.put('*', 4);
	}

	static class TNode {
		Object val;
		TNode left;
		TNode right;

		public TNode(Object val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public TNode(Object val, TNode left, TNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public static TNode of(char val) {
			return new TNode(val);
		}

		public int evaluate() {
			if (Character.isDigit((char)val)) {
				return Character.getNumericValue((char)val);
			} else {
				int leftEval = this.left.evaluate(); //One of these nodes should never be null since otherwise it would be an invalid expression. This is for safety reason.
				int rightEval = this.right.evaluate();
				if (val instanceof Character) {
					char operation = ((char)val);
					if (operation == '+') {
						return leftEval + rightEval;
					} else if (operation == '-') {
						return leftEval - rightEval;
					} else if (operation == '*') {
						return leftEval * rightEval;
					} else {
						return leftEval / rightEval;
					}
				}

				throw new RuntimeException("What is this character?");
			}
		}
	}

	/**

	 3+4*5+6
	 +
	 / \
	 +   6
	 / \
	 3   *
	 / \
	 4   5


	 +
	 / \
	 ,+   6
	 / \
	 3  *
	 / \
	 4   5
	 _

	 */

	public static String printTree(TNode node, int depth) {
		if (node == null) {
			return "";
		} else {
			String padding = "";
			for(int i = 0; i < depth; i++ ){
				padding += "-";
			}
			String res = "";
			res += padding + node.val.toString() + "\n" + printTree(node.left, depth+1) + printTree(node.right, depth+1);
			return res;
		}
	}

	/**
	 * Currently only works for single digit calculations.
	 * @param input
	 * @return
	 */
	public static int evaluate(String input) {
		char[] characters = input.toCharArray();

		Stack<Character> tokens = new Stack<>();

		TNode root = null;

		for(int i = 0; i < characters.length; i++) {
			char current = characters[i];
			if (root == null) {
				root = new TNode(current);
				continue;
			}

			if (Character.isDigit(current)) {
				if (!tokens.isEmpty()) {
					char prev = tokens.peek();
					if (!Character.isDigit(prev)
							&& (!(i+1 < characters.length && ops.get(characters[i+1]) > ops.get(prev)))) {
						//I would have had to define is operation, also if the next character character is not an operation and is
						//not greater in the order of operations, or if its end of list,
						//Then I would enter this code, because this code basically builds the tree.
						char operation = tokens.pop();
						TNode leftNode = tokens.isEmpty() ? root : TNode.of(tokens.pop());
						TNode newTNode = new TNode(operation, leftNode, TNode.of(current));
						char lastOp = '\0';
						while(!tokens.isEmpty()) {
							lastOp = tokens.pop();
							if (!tokens.isEmpty()) {
								char left = tokens.pop();
								newTNode = new TNode(lastOp, TNode.of(left), newTNode);
							}
						}
						if (lastOp != '\0') {
							root = new TNode(lastOp, root, newTNode);
						} else {
							root =  newTNode;
						}
					} else {
						tokens.push(current); //The next operation is greater than my order of operations or I don't have a next operation.
					}
				} else {
					tokens.push(current); //If I have no tokens, then I push to my stack no matter what because I cannot have an invalid value otherwise.
				}
			} else {
				tokens.push(current); //If it's not a digit, I just push to the stack.
			}
		}
		System.out.println(printTree(root, 0));
		return root.evaluate();
	}
	public static void main(String[] args) {
		System.out.println(evaluate("3+4*2+5+3*3"));
	}
}
