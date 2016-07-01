package tree;

public class ShortestPathInBst {
	
	public static void main(String...args) {
		TreeNode c = new TreeNode(18, null, null);
		TreeNode a = new TreeNode(5, null, null);
		TreeNode b = new TreeNode(16, null, c);
		TreeNode d = new TreeNode(13, null, b);
		TreeNode g = new TreeNode(8, a, d);
		TreeNode h = new TreeNode(19,  g, null);
		System.out.println(buildPath(h, a, ""));
		
	}
	
	public static String findPath(TreeNode root, TreeNode src, TreeNode dest) {
		return null;
	}
	
	public static String buildPath(TreeNode root, TreeNode dest, String pathSoFar) {
		if (root == null) {
			return "";
		}
		String newPath = pathSoFar + "->" + root.value.toString();
		if (root == dest) {
			return newPath;
		} else {
			String leftPath = buildPath(root.left, dest, newPath);
			String rightPath = buildPath(root.right, dest, newPath);
			if (leftPath == "") {
				return rightPath;
			} else {
				return leftPath;
			}
		}
	}
	
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode src, TreeNode dest) {
		if (root.value >= src.value && root.value <= dest.value) {
			return root;
		} else if (root.value >= src.value) {
			return findCommonAncestor(root.left, src, dest);
		} else {
			return findCommonAncestor(root.right, src, dest);
		}
	}
	
}
