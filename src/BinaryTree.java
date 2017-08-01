import org.apache.commons.lang3.StringUtils;

/**
 * Created by benjaminliu on 1/23/17.
 */
public class BinaryTree<T extends Comparable> {
	T value;
	BinaryTree<T> left;
	BinaryTree<T> right;

	public BinaryTree(final T value, final BinaryTree<T> left, final BinaryTree<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTree(final T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(final T value) {
		this.value = value;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public void setLeft(final BinaryTree<T> left) {
		this.left = left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void setRight(final BinaryTree<T> right) {
		this.right = right;
	}

	public boolean isBinarySearchTree() {
		return (boolean) isBinarySearchTreeHelper()[2];
	}

	public static class BinaryTreeBuilder<T extends Comparable> {
		private BinaryTree<T> binaryTree;

		public BinaryTreeBuilder(final T value) {
			this.binaryTree = new BinaryTree<>(value);
		}

		public BinaryTreeBuilder addLeft(final BinaryTree<T> value) {
			this.binaryTree.setLeft(value);
			return this;
		}

		public BinaryTreeBuilder addRight(final BinaryTree<T> value) {
			this.binaryTree.setRight(value);
			return this;
		}

		public BinaryTree<T> build() {
			return binaryTree;
		}
	}

	public Object[] isBinarySearchTreeHelper() {
		Object[] leftRange = null;
		Object[] rightRange = null;
		if (this.left != null) {
			leftRange = this.left.isBinarySearchTreeHelper();
		}

		if (this.right != null) {
			rightRange = this.right.isBinarySearchTreeHelper();
		}

		if (this.left == null && this.right == null) {
			return new Object[]{getValue(), getValue(), true};
		} else if (this.left == null) {
			boolean shouldBeLessThanRight = getValue().compareTo(rightRange[0]) <= 0;
			boolean isBst = (Boolean) rightRange[2];
			return new Object[]{getValue(), rightRange[0], shouldBeLessThanRight && isBst};
		} else if (this.right == null) {
			boolean shouldBeGreaterThanLeft = getValue().compareTo(leftRange[1]) >= 0;
			boolean isBst = (Boolean) leftRange[2];
			return new Object[]{leftRange[1], getValue(), shouldBeGreaterThanLeft && isBst};
		} else {
			boolean isBst = (Boolean) rightRange[2] && (Boolean) leftRange[2];
			final boolean isInBetween = getValue().compareTo(rightRange[0]) <= 0
					&& getValue().compareTo(leftRange[1]) >= 0;
			return new Object[]{leftRange[1], rightRange[0], isInBetween && isBst};
		}
	}

	private String printTree(int depth) {
		StringBuilder sb = new StringBuilder();
		final String spaces = StringUtils.leftPad("", depth);

		sb.append(spaces).append(value.toString());
		if (left != null) {
			sb.append("\n").append(left.printTree(depth+1));
		} else {
			sb.append("\n").append(spaces).append(" ").append("null");
		}

		if (right != null) {
			sb.append("\n").append(right.printTree(depth+1));
		} else {
			sb.append("\n").append(spaces).append(" ").append("null");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return this.printTree(0);
	}
}
