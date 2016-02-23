package tree;

public class VerifyBinarySearchTree {

	public static void main(String...args) {
		TreeNode treeNode = new TreeNode(12,
								new TreeNode(4,
										new TreeNode(1, null, null),
										new TreeNode(8, null, null)),
								new TreeNode(18,
										new TreeNode(14,
												new TreeNode(13, null, null),
												new TreeNode(15, null, null)),
										new TreeNode(21, null, null)));
		System.out.println(verify(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static void printTree(TreeNode node, String padding) {
		if (node == null) {
			return;
		} else {
			System.out.println(padding + node.value);
			printTree(node.left, padding + "     ");
			printTree(node.right, padding + "     ");
		}
	}
	
	public static boolean verify(TreeNode node, Integer minVal, Integer maxVal) {
		if (node == null) {
			return true;
		}
		if (node.value < minVal || node.value > maxVal) {
			return false;
		} else {
			return verify(node.left, minVal, node.value) &&
					verify(node.right, node.value, maxVal);
		}
	}
}
