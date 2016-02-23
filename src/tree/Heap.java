package tree;

public class Heap {
	
	public static void main(String...args) {
		TreeNode treeNode = new TreeNode(3,
											new TreeNode(6,
													new TreeNode(12, null, null),
													new TreeNode(15, null, null)),
											new TreeNode(8, null, null));
		TreeNode result = heapify(treeNode);
		printTree(result, "");
	}
	
	public static void printTree(TreeNode tree, String padding) {
		if (tree == null) {
			return;
		} else {
			System.out.println(padding + tree.value);
			printTree(tree.left, padding + "\t");
			printTree(tree.right, padding + "\t");
		}
	}
	
	
	public static TreeNode heapify(TreeNode tree) {
		if (tree == null) {
			return null;
		} else {
			Integer rootValue = tree.value;
			TreeNode leftHeap = heapify(tree.left);
			TreeNode rightHeap = heapify(tree.right);
			if (leftHeap != null && leftHeap.value > rightHeap.value) {
				if (leftHeap.value > rootValue){
					tree.value = leftHeap.value;
					leftHeap.value = rootValue;
					tree.left = heapify(leftHeap);
				}
			} else {
				if (rightHeap != null && rightHeap.value > leftHeap.value) {
					if (rightHeap.value > rootValue) {
						tree.value = rightHeap.value;
						rightHeap.value = rootValue;
						tree.right = heapify(rightHeap);
					}
				}
			}
			return tree;	
		}
	}
	

}
