package array;

import java.util.Arrays;
import java.util.Collections;

/**
 */
public class Heapify {

	public static void main(String...args) {
		int[] testIn = {19, 2, 4, 18, 27};
		System.out.println(Arrays.toString(heapify(testIn, 0)));
	}

	private static void swap(int[] src, int a, int b) {
		int tmp = src[b];
		src[b] = src[a];
		src[a] = tmp;
	}

	public static int[] heapify(int[] tree, int root) {
		int rootVal = tree[root];
		int left = 0;
		int right = 0;
		final int leftIndex = root * 2 + 1;
		if (leftIndex < tree.length) {
			heapify(tree, leftIndex);
			left = tree[leftIndex];
		}

		final int rightIndex = root * 2 + 2;
		if (rightIndex < tree.length) {
			heapify(tree, rightIndex);
			right = tree[rightIndex];
		}

		final Integer max = Collections.max(Arrays.asList(rootVal, right, left));
		if (max == left) {
			swap(tree, root, leftIndex);
			heapify(tree, leftIndex);
		} else if (max == right) {
			swap(tree, root, rightIndex);
			heapify(tree, leftIndex);
		}
		return tree;
	}
}
