package tree;

import java.util.Arrays;

/**
 */
public class Heapify {

	public static Integer[] heapify(Integer[] input) {
		return heapifyHelper(input, 0);
	}

	private static Integer[] heapifyHelper(Integer[] input, int i) {
		int left = 2 * i + 2;
		int right = 2 * i + 1;
		int val = input[i];

		if (left < input.length) {
			heapifyHelper(input, left);
		}

		if (right < input.length) {
			heapifyHelper(input, right);
		}

		int leftVal = left < input.length ? input[left] : Integer.MIN_VALUE;
		int rightVal = right < input.length ? input[right] : Integer.MIN_VALUE;

		int switchWith = Math.max(leftVal, rightVal);

		if (switchWith > val) {
			if (leftVal == switchWith) {
				swap(input, i, left);
				heapifyHelper(input, left);
			} else {
				swap(input, i, right);
				heapifyHelper(input, right);
			}
		}
		return input;
	}

	public static void swap(Integer[] input, int src, int dest) {
		int tmp = input[src];
		input[src] = input[dest];
		input[dest] = tmp;
	}

	public static void main(String...args) {
		System.out.println(Arrays.toString(heapify(new Integer[] {5, 2, 1, 4, 19, 12, 13, 21, 44, 51, 3})));
	}
}
