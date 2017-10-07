
package main;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import org.apache.commons.lang3.StringUtils;
import tree.BSTNode;

import java.util.List;
import java.util.ArrayList;

public class Solution
{

	static class BSTTree {
		BSTNode root;

		public BSTTree(int val) {
			this.root = new BSTNode(val);
		}

		public void add(int val) {
			BSTNode iter = this.root;
			while (iter != null) {
				if (val < iter.val) {
					if (iter.left == null) {
						iter.left = new BSTNode(val);
						break;
					} else {
						iter = iter.left;
					}
				} else {
					if (iter.right == null) {
						iter.right = new BSTNode(val);
						break;
					} else {
						iter = iter.right;
					}
				}
			}
		}

		public int distance(BSTNode node1, BSTNode node2) {
			if (this.root == null || node1 == null || node2 == null) {
				return -1;
			}
			List<BSTNode> pathToNode1 = new ArrayList<>();
			BSTNode iter = root;
			while (iter != null && iter.val != node1.val) {
				pathToNode1.add(iter);
				if (node1.val < iter.val) {
					iter = iter.left;
				} else {
					iter = iter.right;
				}
			}
			if (iter == null) {
				return -1;
			}

			List<BSTNode> pathToNode2 = new ArrayList<>();
			iter = root;
			while (iter != null && iter.val != node2.val) {
				pathToNode2.add(iter);
				if (node2.val < iter.val) {
					iter = iter.left;
				} else {
					iter = iter.right;
				}
			}
			if (iter == null) {
				return -1;
			}

			int idx = 0;
			while (idx < pathToNode2.size() && idx < pathToNode1.size() && pathToNode1.get(idx).val == pathToNode2.get(idx).val) {
				idx += 1;
			}

			int secAdd = 1;

			if (pathToNode2.size() == 0) {
				secAdd = 0;
			}

			int firstAdd = 1;
			if (pathToNode1.size() == 0) {
				firstAdd = 0;
			}

			System.out.println(pathToNode1);
			System.out.println(pathToNode2);
			int toAdd = 0;

			if (pathToNode1.size() > 0 && pathToNode2.size() > 0) {
				toAdd = 2;
			} else if (!pathToNode1.isEmpty() || !pathToNode2.isEmpty()) {
				toAdd = 0;
			} else {
				toAdd = 0;
			}

			return (pathToNode1.size() - idx) + (pathToNode2.size() - idx) + toAdd;
		}

	}

	static class BSTNode {
		int val;
		BSTNode left;
		BSTNode right;

		public BSTNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return Integer.toString(this.val);
		}
	}

	public BSTTree constructTree(int[] values) {
		if (values.length == 0) {
			return null;
		} else {
			BSTTree tree = new BSTTree(values[0]);
			for(int i = 1; i < values.length; i++) {
				tree.add(values[i]);
			}
			return tree;
		}
	}
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int bstDistance(int[] values, int n,
						   int node1, int node2)
	{
		if (values.length == 0) {
			return -1;
		}

		BSTTree bstTree = constructTree(values);

		return bstTree.distance(new BSTNode(node1), new BSTNode(node2));
	}
	// METHOD SIGNATURE ENDS

	public static void main(String...args) {
		Solution s = new Solution();
		System.out.println(s.bstDistance(new int[]{0, 2, 4}, 6, 0, 4));
	}
}