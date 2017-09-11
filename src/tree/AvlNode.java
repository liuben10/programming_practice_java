package tree;

import java.util.Comparator;

/**
 * Created by liuben10 on 8/15/17.
 */
class AvlNode<TYPE extends Comparable> {

	private TYPE val;

	private AvlNode left;

	private AvlNode right;

	@Override
	public String toString() {
		return val.toString();
	}

	public AvlNode(TYPE val, AvlNode left, AvlNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public boolean hasChildren() {
		return this.left != null || this.right != null;
	}

	public TYPE getVal() {
		return val;
	}

	public void setVal(TYPE val) {
		this.val = val;
	}

	public AvlNode getLeft() {
		return left;
	}

	public void setLeft(AvlNode left) {
		this.left = left;
	}

	public AvlNode getRight() {
		return right;
	}

	public void setRight(AvlNode right) {
		this.right = right;
	}
}
