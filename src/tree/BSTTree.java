package tree;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

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

	private static class NodeWrap {
		BSTNode node;
		int depth;

		public NodeWrap(BSTNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public List<List<Integer>> bottomUp() {
		Queue<NodeWrap> fringe = new LinkedList<>();
		List<List<Integer>> results = new ArrayList<>();
		fringe.add(new NodeWrap(this.root, 0));
		int curDepth = 0;
		while (!fringe.isEmpty()) {
			NodeWrap wrap = fringe.remove();
			int depth = wrap.depth;
			BSTNode node = wrap.node;
			if (depth >= results.size()) {
				results.add(new ArrayList<>(Arrays.asList(node.getValue())));
			} else {
				results.get(depth).add(node.getValue());
			}

			if (node.getLeft() != null) {
				fringe.add(new NodeWrap(node.getLeft(), depth + 1));
			}

			if (node.getRight() != null) {
				fringe.add(new NodeWrap(node.getRight(), depth + 1));
			}
		}

		return Lists.reverse(results);
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
