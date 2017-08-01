package tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by liuben10 on 7/20/17.
 */
public class BranchCountTree {
	private static class Tree {
		int node;
		Tree left;
		Tree right;

		public Tree(int node) {
			this.node = node;
			this.left = null;
			this.right = null;
		}


		public int getNode() {
			return node;
		}

		public void setNode(int node) {
			this.node = node;
		}

		public Tree getLeft() {
			return left;
		}

		public void setLeft(Tree left) {
			this.left = left;
		}

		public Tree getRight() {
			return right;
		}

		public void setRight(Tree right) {
			this.right = right;
		}

		public static TreeBuilder builder(int value) {
			return new TreeBuilder(new Tree(value));
		}

		public TreeBuilder toBuilder() {
			return new TreeBuilder(this);
		}

		private static class TreeBuilder {
			Tree build;

			public TreeBuilder(Tree build) {
				this.build = build;
			}

			public TreeBuilder setLeft(Tree t) {
				build.left = t;
				return this;
			}

			public TreeBuilder setRight(int value) {
				build.right = new Tree(value);
				return this;
			}

			public TreeBuilder setLeft(int value) {
				build.left = new Tree(value);
				return this;
			}

			public TreeBuilder setRight(Tree t) {
				build.right = t;
				return this;
			}

			public Tree build() {
				return build;
			}
		}
	}

	private static boolean checkHasSum(final Tree t, int target) {
		Stack<Tree> fringe = new Stack<>();
		Set<Tree> visited = new HashSet<>();
		int sum = target;
		fringe.push(t);
		while(!fringe.isEmpty()) {
			Tree popped = fringe.pop();
			visited.add(popped);
			sum -= popped.getNode();
			if (sum == 0) {

				if ((popped.getLeft() != null && !visited.contains(popped.getLeft())) ||
						(popped.getRight() != null && !visited.contains(popped.getRight()))) {
					sum += popped.getNode();
				} else {
					return true;
				}

			}
			if ((popped.getLeft() == null && popped.getRight() == null) ||
					(visited.contains(popped.getLeft()) && visited.contains(popped.getRight()))) {
				sum += popped.getNode();
				continue;
			}
			if (popped.getLeft() != null && !visited.contains(popped.getLeft())) {
				fringe.add(popped.getLeft());
			}
			if (popped.getRight() != null && !visited.contains(popped.getRight())) {
				fringe.add(popped.getRight());
			}
		}
		return false;
	}

	public static void main(String...args) {
		Tree tb = Tree.builder(10)
									.setLeft(
											Tree.builder(4)
													.setLeft(6)
													.setRight(5)
													.build())
									.setRight(Tree.builder(3).build()).build();

		System.out.println(checkHasSum(tb, 13));
	}
}
