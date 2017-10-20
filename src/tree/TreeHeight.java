package tree;

/**
 */
public class TreeHeight {


	static class TreeNode {
		Integer value;
		TreeNode left;
		TreeNode right;

		public TreeNode(Integer value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public TreeNode(Integer value) {
			this.value = value;
		}

		public TreeNode setLeft(int val) {
			this.left = new TreeNode(val);
			return left;
		}

		public TreeNode setRight(int val) {
			this.right = new TreeNode(val);
			return this.right;
		}
	}

	public static int maxDistanceTree(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 0;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		return leftHeight + rightHeight;
	}

	public static int height(TreeNode node) {
		return heightHelp(node);
	}

	private static int heightHelp(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(heightHelp(node.left)+1, heightHelp(node.right)+1);
	}


	public static void main(String...args) {
		TreeNode treeNode = new TreeNode(100);
		treeNode.setLeft(100);
		treeNode.setRight(100);
//		TreeNode treeNode1 = treeNode.setRight(30);
//		treeNode1.setLeft(55);
//		treeNode1.setRight(100);
//		TreeNode tNode = treeNode.setLeft(100);
//		TreeNode tNode1 = tNode.setLeft(15);
//		tNode1.setRight(100);
//		tNode1.setLeft(200).setRight(300).setLeft(100).setRight(400).setLeft(500).setRight(100);
//		TreeNode tNode2 = tNode.setRight(120);
//		tNode2.setLeft(1000);
//		System.out.println(height(treeNode));
		System.out.println(maxDistanceTree(treeNode));
	}
}
