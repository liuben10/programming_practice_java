package tree;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by liuben10 on 8/6/17.
 */
public class PrintBinaryTreeAlternating {

	public static class TreeNode {
		public String getVal() {
			return val;
		}

		public void setVal(String val) {
			this.val = val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public List<TreeNode> leftToRight() {
			return Arrays.asList(this.left, this.right);
		}

		public List<TreeNode> rightToLeft() {
			return Arrays.asList(this.right, this.left);
		}

		String val;
		TreeNode left;
		TreeNode right;

		public TreeNode(String val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public TreeNode(String val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public TreeNodeBuilder builder() {
			return new TreeNodeBuilder(this);
		}

		public static TreeNodeBuilder builder(String val) {
			return new TreeNodeBuilder(val);
		}
	}

	public static class TreeNodeBuilder {

		TreeNode toBuild;

		public TreeNodeBuilder(final TreeNode treeNode) {
			this.toBuild = treeNode;
		}

		public TreeNodeBuilder(String val) {
			this.toBuild = new TreeNode(val);
		}

		public TreeNodeBuilder left(TreeNode node) {
			this.toBuild.left = node;
			return this;
		}

		public TreeNodeBuilder right(TreeNode node) {
			this.toBuild.right = node;
			return this;
		}

		public TreeNode build() {
			return this.toBuild;
		}
	}

	public static class TreeNodeLevelAndIndex {
		TreeNode node;
		int level;
		int index;

		@Override
		public String toString() {
			return "TreeNodeLevelAndIndex{" +
					"node=" + node +
					", level=" + level +
					", index=" + index +
					'}';
		}

		public TreeNodeLevelAndIndex(TreeNode node, int level, int index) {
			this.node = node;
			this.level = level;
			this.index = index;
		}
	}

	public static String printAlternating(TreeNode root) {
		PriorityQueue<TreeNodeLevelAndIndex> pq = new PriorityQueue<>(10, (node1, node2) -> {
			if (node1.level == node2.level) {
				return Integer.compare(node2.index, node1.index);
			} else {
				return Integer.compare(node1.level, node2.level);
			}
		});

		pq.add(new TreeNodeLevelAndIndex(root, 0, 0));
		StringBuilder results = new StringBuilder();
		int levelIndex = 0;
		int curLevel = 0;
		while(!pq.isEmpty()) {
			TreeNodeLevelAndIndex visiting = pq.remove();
			results.append(visiting.node.val);
			if (visiting.level > curLevel) {
				curLevel = visiting.level;
				levelIndex = 0;
			}
			if (visiting.level % 2 == 0) {
				for (TreeNode treeNode : visiting.node.leftToRight()) {
					if (treeNode != null) {
						pq.add(new TreeNodeLevelAndIndex(treeNode, visiting.level + 1, levelIndex));
						levelIndex += 1;
					}
				}
			} else {
				for (TreeNode treeNode : visiting.node.rightToLeft()) {
					if (treeNode != null) {
						pq.add(new TreeNodeLevelAndIndex(treeNode, visiting.level + 1, levelIndex));
						levelIndex += 1;
					}
				}
			}
		}
		return results.toString();
	}

	public static void main(String...args) {
		TreeNode node = TreeNode.builder("a")
				.left(
					TreeNode.builder("b")
						.left(TreeNode.builder("c").build())
						.right(TreeNode.builder("f")
											.left(TreeNode.builder("t").build())
											.right(TreeNode.builder("z").build()).build()).build())
				.right(
						TreeNode.builder("k")
							.left(TreeNode.builder("j")
													.left(TreeNode.builder("l").build()).build()).build()
				).build();

		System.out.println(printAlternating(node));
	}
}
