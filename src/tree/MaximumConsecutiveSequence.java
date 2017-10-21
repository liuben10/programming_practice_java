package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 */
public class MaximumConsecutiveSequence {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		@Override
		public String toString() {
			return "TreeNode{" +
					"val=" + val +
					'}';
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public TreeNode(int val, int left, int right) {
			this.val = val;
			this.left = new TreeNode(left);
			this.right = new TreeNode(right);
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

	static class Wrapper {
		TreeNode node;
		List<TreeNode> path;

		public Wrapper(TreeNode node, List<TreeNode> path) {
			this.node = node;
			this.path = path;
		}
	}

	public static List<TreeNode> maximumLengthSequence(TreeNode input) {
		Stack<Wrapper> fringe = new Stack<>();

		fringe.push(new Wrapper(input, new ArrayList<>()));

		List<TreeNode> maxSoFar = new ArrayList<>();

		while (!fringe.isEmpty()) {
			Wrapper wrapper = fringe.pop();
			TreeNode current = wrapper.node;
			List<TreeNode> path = wrapper.path;
			if (!path.isEmpty() && current.val < path.get(path.size() - 1).val) {
				if (path.size() > maxSoFar.size()) {
					maxSoFar = path;
				}
				path = new ArrayList<>();
			} else {
				path.add(current);
			}
			if (current.left != null) {
				fringe.push(new Wrapper(current.left, path));
			}
			if (current.right != null) {
				fringe.push(new Wrapper(current.right, path));
			}
		}

		return maxSoFar;
	}

	public static void main(String...args) {
		TreeNode tNode = new TreeNode(12, 13, 2);

		System.out.println(maximumLengthSequence(tNode));
	}
}
