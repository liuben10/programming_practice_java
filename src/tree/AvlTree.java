package tree;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liuben10 on 8/15/17.
 */
public class AvlTree<TYPE extends Comparable> {

	AvlNode<TYPE> root;

	public AvlTree(AvlNode<TYPE> root) {
		this.root = root;
	}

	public AvlTree(TYPE val) {
		this.root = new AvlNode<>(val, null, null);
	}

	public AvlNode<TYPE> getRoot() {
		return root;
	}

	public void setRoot(AvlNode<TYPE> root) {
		this.root = root;
	}

	public void insert(AvlNode<TYPE> newNode) {
		insertHelper(root, newNode);

	}

	public void insert(TYPE val) {
		insertHelper(root, new AvlNode<>(val, null, null));
	}

	private void rebalance(AvlNode<TYPE> root) {
		int heightDiff = height(root.getLeft()) - height(root.getRight());
		if (heightDiff >= 2) {
			//TODO
		}
		return;
	}

	private boolean outOfBalance() {
		int heightDiff = height(root.getLeft()) - height(root.getRight());
		return heightDiff >= -1 && heightDiff <= 1;
	}

	private int height(AvlNode<TYPE> node) {
		if (node == null) {
			return 0;
		} else {
			return Integer.max(height(node.getLeft()), height(node.getRight()));
		}
	}

	@Override
	public String toString() {
		return stringify(root, 1);
	}

	private String stringify(AvlNode<TYPE> root, int padding) {
		if (root == null) {
			return "";
		} else {
			String paddedRoot = "\n" + StringUtils.leftPad(root.getVal().toString(), padding, '-');
			paddedRoot = paddedRoot + stringify(root.getLeft(), padding+1);
			paddedRoot = paddedRoot + stringify(root.getRight(), padding+1);
			return paddedRoot;
		}
	}

	private void insertHelper(AvlNode<TYPE> root, AvlNode<TYPE> toInsert) {
		if (root.getLeft() == null && toInsert.getVal().compareTo(root.getVal()) < 0) {
			root.setLeft(toInsert);
			return;
		}

		if (root.getRight() == null && toInsert.getVal().compareTo(root.getVal()) > 0) {
			root.setRight(toInsert);
			return;
		}

		if (toInsert.getVal().compareTo(root.getVal()) < 0) {
			insertHelper(root.getLeft(), toInsert);
		} else {
			insertHelper(root.getRight(), toInsert);
		}
	}
}
