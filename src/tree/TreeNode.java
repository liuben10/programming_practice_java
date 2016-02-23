package tree;

public class TreeNode {
	public TreeNode(Integer value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public Integer value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	@Override
	public String toString() {
		return value.toString();
	}
}
