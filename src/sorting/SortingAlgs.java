package sorting;

import java.util.Arrays;
import java.util.Random;

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

	public static int[] quickSort(int[] input) {
		quickSortHelp(input, 0, input.length - 1);

		return input;
	}

	private static void quickSortHelp(int[] input, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int partIdx = partition(input, start, end);

			quickSortHelp(input, start, partIdx);

			quickSortHelp(input, partIdx+1, end);
		}
	}

	/**
	 *
	 * {1, 2, 4, 5, 3}
	 *
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int[] input, int start, int end) {
		Random r = new Random();
		int randomNum = r.nextInt(end - start);
		int pivot = randomNum + start;
		int pivotEl = input[pivot];

		swap(input, pivot, end);

		int lower = start;
		for (int i = start; i < end; i++) {
			if (input[lower] < pivotEl) {
				lower += 1;
			} else {
				if (input[i] < pivotEl) {
					swap(input, lower, i);
					lower += 1;
				}
			}
		}

		swap(input, lower, end);

		return lower;
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
//		int[] sorted = mergeSort(input);
//		System.out.println(Arrays.toString(sorted));

		int[] sorted = quickSort(input);
		System.out.println(Arrays.toString(sorted));
	}
}
