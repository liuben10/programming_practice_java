package tree;

/**
 * Created by liuben10 on 8/26/17.
 */
public class BSTNode {

	Integer value;
	BSTNode left;
	BSTNode right;


	public BSTNode(Integer value) {
		this.value = value;
	}

	public BSTNode(Integer value, BSTNode left, BSTNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
