package tree;

public class GetKthNodeInBTree {

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
		System.out.println(getKthValueInTree(treeNode, 3));
	}
	
	public static Integer getKthValueInTree(TreeNode node, Integer k) {
		if (node == null || k == 0) {
			return null;
		}
		return getKthValueInTreeCore(node, k).value;
	}

	private static TreeNode getKthValueInTreeCore(TreeNode node, Integer k) {
		TreeNode target = null;
		if (node.left != null) {
			target = getKthValueInTreeCore(node.left, k);
		}
		if (target == null) {
			if (k == 1)
				target = node;
			k -= 1;
		}
		if (target == null && node.right != null) {
			target = getKthValueInTreeCore(node.right, k);
		}
		return target;
	}
	
	
}
