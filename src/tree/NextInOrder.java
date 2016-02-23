package tree;

public class NextInOrder {

	public static void main(String...args) {

		TreeNode k = new TreeNode(9, null, null);
		TreeNode f = new TreeNode(8, k, null);
		TreeNode e = new TreeNode(7, null, null);
		TreeNode d = new TreeNode(6, null, null);
		TreeNode c = new TreeNode(5, e, null);
		TreeNode b = new TreeNode(4, c, d);
		TreeNode a = new TreeNode(3, b, f);
		b.parent = a;
		c.parent = b;
		d.parent = b;
		e.parent = c;
		f.parent = a;
		k.parent = f;
		System.out.println(getNextNodeInOrder(f));
	}


	public static TreeNode getNextNodeInOrder(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			TreeNode iter = node.right;	
			while (iter.left != null) {
				iter = iter.left;
			}
			return iter;
		} else if (node.parent != null) {
			if (node.right == null) {
				TreeNode iter = node;
				TreeNode curParent = node.parent;
				while (curParent != null && iter == curParent.right ) {
					iter = iter.parent;
					curParent = curParent.parent;
				}
				return curParent;
			}
		}
		return null;
	}

}
