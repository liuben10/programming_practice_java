package tree;

import java.util.Arrays;

/**
 */
public class SerialTree {

	static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;

		public TreeNode(Integer val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int height(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}

	public static Integer[] serialize(TreeNode node) {
		int height = height(node);
		int len = (int) (Math.pow(2, height) - 1);
		Integer[] serialized = new Integer[len];
		serializeHelp(node, 0, serialized);
		return serialized;
	}


	public static TreeNode deserialize(Integer[] serialized) {
		return deserializeHelp(serialized, 0);
	}

	public static TreeNode deserializeHelp(Integer[] serialized, int idx) {
		if (idx >= serialized.length) {
			return null;
		} else {
			TreeNode newTNode = new TreeNode(serialized[idx], null, null);
			TreeNode left = deserializeHelp(serialized, 2*idx+1);
			TreeNode right = deserializeHelp(serialized, 2*idx+2);
			newTNode.left = left;
			newTNode.right = right;
			return newTNode;
		}
	}


	private static void serializeHelp(TreeNode node, int idx, Integer[] serialized) {
		if (node == null) {
			serialized[idx] = null;
		} else {
			serialized[idx] = node.val;

			if (2 * idx + 1 < serialized.length) serializeHelp(node.left, 2 * idx + 1, serialized);
			if (2 * idx + 2 < serialized.length) serializeHelp(node.right, 2 * idx + 2, serialized);
		}
	}



	public static void main(String...args) {
		TreeNode root = new TreeNode(44,
				new TreeNode(12,
						new TreeNode(3,
								null,
								null),
						null
				),
				new TreeNode(32,
						new TreeNode(
								4,
								new TreeNode(5,
										new TreeNode(6, null, null),
										null
								),
								new TreeNode(10, null, null)
						),
						null
				)
		);


		Integer[] serialized = serialize(root);
		System.out.println(Arrays.toString(serialized));

		TreeNode deserialized = deserialize(serialized);

		System.out.println(deserialized.left.left.val);

	}
}
