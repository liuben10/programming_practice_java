package sorting;

import java.util.Arrays;

/**
 */
public class SortingAlgs {

	static void swap(int[] input, int src, int dest) {
		int tmp = input[src];
		input[src] = input[dest];
		input[dest] = tmp;
	}

	public static void bubbleSort(int[] input) {
		for (int i = input.length; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (j-1 >= 0) {
					if (input[j] < input[j-1]) {
						swap(input, j, j-1);
					}
				}
			}
		}
	}


	public static int[] mergeSort(int[] input) {
		if (input.length == 1) {
			return input;
		} else {
			int mid = input.length / 2;
			int[] lower = Arrays.copyOfRange(input, 0, mid);
			int[] upper = Arrays.copyOfRange(input, mid, input.length);

			int[] lowerSorted = mergeSort(lower);
			int[] upperSorted = mergeSort(upper);

			int lowIdx = 0;
			int highIdx = 0;
			int sortedIdx = 0;
			int[] sorted = new int[input.length];

			while(lowIdx < lowerSorted.length && highIdx < upperSorted.length) {
				if (lowerSorted[lowIdx] < upperSorted[highIdx]) {
					sorted[sortedIdx] = lowerSorted[lowIdx];
					lowIdx += 1;
				} else {
					sorted[sortedIdx] = upperSorted[highIdx];
					highIdx += 1;
				}
				sortedIdx += 1;
			}

			while (highIdx < upperSorted.length) {
				sorted[sortedIdx] = upperSorted[highIdx];
				highIdx += 1;
				sortedIdx += 1;
			}


			while (lowIdx < lowerSorted.length) {
				sorted[sortedIdx] = lowerSorted[lowIdx];
				lowIdx += 1;
				sortedIdx += 1;
			}

			return sorted;
		}
	}

	public static void main(String...args) {
		int[] input = {5, 2, 3, 4, 10, 4, 9, 11, 16};
		int[] sorted = mergeSort(input);
		System.out.println(Arrays.toString(sorted));
	}
}
