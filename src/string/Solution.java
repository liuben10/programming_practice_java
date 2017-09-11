package string;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
	public static void main(String[] args) {
		TreeNode res = convert("a?b?f:h:c?hf:k");

		printPretty(res, 1);
	}

	public static void printPretty(TreeNode node, int depth) {
		if (node == null) {
			return;
		} else {
			System.out.println(StringUtils.leftPad(node.value, depth, "-"));
			printPretty(node.left, depth + 1);
			printPretty(node.right, depth + 1);
		}
	}

	public static TreeNode convert(String inputTern) {
		if (!inputTern.contains(":") && !inputTern.contains("?")) {
			return new TreeNode(inputTern);
		} else {
			Stack<String> expressions = new Stack<>();
			StringBuilder leftExpress = new StringBuilder();
			String rightExpress;
			boolean shouldAddQuestionMark = false;
			int lastIndex = 0;
			if (inputTern.length() < 5) {
				throw new IllegalArgumentException("Invalid ternary expression: " + inputTern);
			}
			for (int i = 1; i < inputTern.length(); i++) {
				String cur = inputTern.substring(i, i + 1);
				if (cur.equals("?")) {
					expressions.add(cur);
					if (!shouldAddQuestionMark) {
						shouldAddQuestionMark = true;
					} else {
						leftExpress.append(cur);
					}
				} else if (cur.equals(":")) {
					expressions.pop();
					if (!expressions.empty()) {
						leftExpress.append(cur);
					} else {
						lastIndex = i + 1;
						break;
					}
				} else {
					leftExpress.append(cur);
				}
			}

			if (lastIndex == inputTern.length() || !expressions.empty()) {
				throw new IllegalArgumentException("Unbalanced Ternary expression");
			}

			rightExpress = inputTern.substring(lastIndex, inputTern.length());

			final TreeNode left = convert(leftExpress.toString());
			final TreeNode right = convert(rightExpress);

			return new TreeNode(inputTern.substring(0, 1), left, right);
		}
	}

	public static class TreeNode {
		String value;
		TreeNode left;
		TreeNode right;

		public TreeNode(String value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public TreeNode(String value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}