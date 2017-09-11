package tree;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuben10 on 8/26/17.
 */
public class BSTTree {

	private BSTNode root;

	public BSTTree(final Integer val) {
		root = new BSTNode(val);
	}

	public BSTNode insert(final Integer val) {
		return insertHelper(root, val);
	}

	private BSTNode insertHelper(BSTNode node, Integer val) {
		if (val < node.getValue()) {
			if (node.getLeft() == null) {
				BSTNode left = new BSTNode(val);
				node.setLeft(left);
				return left;
			} else {
				return insertHelper(node.getLeft(), val);
			}
		} else if (val >= node.getValue()) {
			if (node.getRight() == null) {
				BSTNode right = new BSTNode(val);
				node.setRight(right);
				return right;
			} else {
				return insertHelper(node.getRight(), val);
			}
		}
		return null;
	}

	public BSTNode getNextInOrder(final BSTNode node) {
		BSTNode parent = null;
		BSTNode iter = this.root;
		List<BSTNode> parentsLeadingToNode = new ArrayList<>();
		while(!iter.equals(node)) {
			parentsLeadingToNode.add(parent);
			parent = iter;
			if (node.getValue() >= iter.getValue()) {
				iter = iter.getRight();
			} else {
				iter = iter.getLeft();
			}
		}
		if (node.getRight() != null) {
			BSTNode leftMost = node.getRight();
			while(leftMost.getLeft() != null) {
				leftMost = leftMost.getLeft();
			}
			return leftMost;
		} else if (node.getRight() == null) {
			if (parent.getLeft() == node) {
				return parent;
			} else {
				if (parentsLeadingToNode.size() > 2) {
					return parentsLeadingToNode.get(parentsLeadingToNode.size() - 2);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return printString(root, 0);
	}

	private String printString(BSTNode root, int padding) {
		if (root != null) {
			String valString = Integer.toString(root.getValue());
			return "\n" + StringUtils.leftPad(valString, padding + valString.length(), '-')
					 + printString(root.getLeft(), padding + 1)
					 + printString(root.getRight(), padding + 1);
		} else {
			return "";
		}
	}
}
