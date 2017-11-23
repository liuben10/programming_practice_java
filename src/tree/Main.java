package tree;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 */
public class Main {

	@AllArgsConstructor
	static class TreeNode {
		Integer value;
		TreeNode left;
		TreeNode right;
	}


	static String printTree(TreeNode root, int depth) {
		if (root == null) {
			return "";
		} else {
			return "\n" + StringUtils.leftPad("", depth) + root.value + printTree(root.left, depth + 1) + printTree(root.right, depth + 1);
		}
	}

	public static void main(String...args) {
		TreeNode node = new TreeNode(3,
				new TreeNode(4, null, null),
				new TreeNode(5, null, null));


		System.out.println(printTree(node, 0));
	}
}
