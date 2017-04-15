package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by benjaminliu on 4/15/17.
 */
public class InorderBinaryTree {

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
		System.out.println(getPostOrder(treeNode));
	}


	public static List<TreeNode> getInorderTraversal(final TreeNode binaryTree) {
		final Stack<TreeNode> fringe = new Stack<>();
		final List<TreeNode> visited = new ArrayList<>();
		fringe.push(binaryTree);

		while (!fringe.isEmpty()) {

			final TreeNode peeked = fringe.peek();
			if (peeked.left != null && !visited.contains(peeked.left)) {
				fringe.push(peeked.left);
			} else {
				final TreeNode popped = fringe.pop();
				visited.add(popped);
				if (popped.right != null) {
					fringe.push(popped.right);
				}
			}

		}
		return visited;
	}


	public static List<TreeNode> getPostOrder(final TreeNode binaryTree) {
		final Stack<TreeNode> fringe = new Stack<>();
		final List<TreeNode> visited = new ArrayList<>();
		fringe.push(binaryTree);

		while (!fringe.isEmpty()) {
			final TreeNode peeked = fringe.peek();
			if ((peeked.left == null || visited.contains(peeked.left)) && (peeked.right == null || visited.contains(peeked.right))) {
				visited.add(peeked);
				fringe.pop();
			} else {
				if (peeked.right != null) {
					fringe.add(peeked.right);
				}
				if (peeked.left != null) {
					fringe.add(peeked.left);
				}
			}
		}
		return visited;
	}

}
