package tree;

import lombok.Builder;

/**
 */
public class BinaryTree {

	TNode root;

	@Builder(toBuilder = true)
	static class TNode {
		int val;
		TNode left;
		TNode right;

		public TNode(int val) {
			this.val = val;
		}

		public TNode(int val, TNode left, TNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "{" + this.val + "}";
		}

		public static TNodeBuilder builder(int val) {
			return new TNode(val).toBuilder();
		}

		public TNodeBuilder left(int val) {
			return this.toBuilder().left(TNode.builder(val).build());
		}

		public TNodeBuilder right(int val) {
			return this.toBuilder().right(TNode.builder(val).build());
		}
	}

	public BinaryTree(int val) {
		this.root = new TNode(val);
	}


	public void morrisTraversal() {
		TNode cur = root;

		while(cur != null) {
			if (cur.left == null) {
				System.out.println(cur.val + " ");
				cur = cur.right;
			} else {
				TNode iter = cur.left;
				while(iter.right != null && iter.right != cur) {
					iter = iter.right;
				}

				if (iter.right == null) {
					iter.right = cur;
					cur = cur.left;
				} else {
					iter.right = null;
					System.out.print(cur.val + " ");
					cur = cur.right;
				}
			}
		}
	}


	public static void main(String...args){
		BinaryTree t = new BinaryTree(10);
		t.root.left = TNode.builder(10)
				.right(TNode.builder(20)
						.left(TNode.builder(100)
								.left(TNode.builder(400).build())
								.build())
						.build())
				.left(TNode.builder(33).build())
				.build();

		t.root.right = TNode.builder(5)
				.right(TNode.builder(9).left(TNode.builder(12)
						.right(TNode.builder(34).build()).build()).build())
				.left(TNode.builder(44).build()).build();

		t.morrisTraversal();
	}

}
