package tree;

/**
 */
public class PrintTreeDFS {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode setLeft(int val) {
			this.left = new TreeNode(val);
			return this.left;
		}

		public TreeNode setRight(int val) {
			this.right = new TreeNode(val);
			return this.right;
		}
	}

	public static void printTreeNodeDfs(TreeNode node) {
		System.out.println(printTreeNodeDfsHelper(node, 0));
	}

	private static String printTreeNodeDfsHelper(TreeNode node, int i) {
		if (node == null) {
			return "";
		} else {
			StringBuilder padding = new StringBuilder();
			for (int j = 0; j < i; j++) {
				padding.append("-");
			}

			return "\n" + padding + node.val + printTreeNodeDfsHelper(node.left, i + 1) + printTreeNodeDfsHelper(node.right, i + 1);
		}
	}


	public static void main(String...args) {
		TreeNode root = new TreeNode(3);
		root.setLeft(3).setRight(4).setLeft(5);

		printTreeNodeDfs(root);
	}
}
