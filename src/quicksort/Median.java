package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Solves the problem of finding the median in O(n) time and constant space.
 */
public class Median {
	
	public static void main(String...args) {
		int[] testIn = new int[]{3, 4, 2, 5, 6};
		System.out.println("median=" + median_slow(testIn));
	}
	
	
	public static int median(int[] input, int start, int end) {
		System.out.println("bounds={" + start + "," + end + "}; input=" + Arrays.toString(input));
		if (start == end) {
			return input[start];
		} else {
			int partition_index = partition(input, start, end);
			System.out.println("partition_index=" + partition_index);
			int midpoint = input.length / 2;
			if (midpoint == partition_index) {
				return input[midpoint];
			}
			if (partition_index > midpoint) {
				return median(input, start, partition_index - 1);
			} else {
				return median(input, partition_index + 1, end);
			}
		}
	}

	public static int median_slow(final int[] input) {
		bubbleSort(input);
		return input[input.length / 2];
	}

	private static void bubbleSort(final int[] input) {
		for (int i = input.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (j > 0 && input[j] < input[j-1]) {
					swap(input, j, j-1);
				}
			}
		}
	}


	public static void swap(int[] input, int src, int end) {
		int tmp = input[end];
		input[end] = input[src];
		input[src] = tmp;
	}

	public static int partition_with_memory(int[] input, int start, int end) {
		List<Integer> lowerBucket = new ArrayList<>();
		List<Integer> upperBucket = new ArrayList<>();
		Random random = new Random();
		int pivot = random.nextInt(end - start + 1) + start;
		for(int i = 0 ; i < input.length; i++) {
			if (i == pivot) {
				continue;
			}
			if (input[i] < input[pivot]) {
				lowerBucket.add(input[i]);
			} else {
				upperBucket.add(input[i]);
			}
		}
		int small = lowerBucket.size();
		lowerBucket.add(input[pivot]);
		lowerBucket.addAll(upperBucket);
		for(int i = 0; i < lowerBucket.size(); i++) {
			input[i] = lowerBucket.get(i);
		}
		return small;

	}


	public static int partition(int[] input, int start, int end) {
		Random random = new Random();
		try {
			int pivot = random.nextInt(end - start + 1) + start;
			System.out.println("selected pivot=" + pivot);
			swap(input, pivot, end);
			
			int small = start - 1;
			for (int i = start; i < end; i++) {
				if (input[i] < input[end]) {
					++small;
					if (input[small] > input[i]) {
						swap(input, small, i);
					}
				}
			}
			
			++small;
			if (small != end) {
				swap(input, small, end);
			}
			return small;
		} catch (IllegalArgumentException e) {
			System.out.println("start=" + start + "end=" + end + "bound=" + (end - start + 1));
			throw e;
		}
	}
	

}
