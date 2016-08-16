package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
	
	/*
	 * Quicksort algorithm implementation.
	 */
	public static void main(String...args) {
		Integer[] testIn = new Integer[]{4, 3, 2, 5, 6,7, 3};
		quicksort(testIn, 0, testIn.length-1);
		System.out.println(Arrays.toString(testIn));
	}
	
	
	/*
	 * Swap two elements from src index to dest index in array input.
	 */
	public static void swap(Integer[] input, int src, int dest) {
		int tmp = input[dest];
		input[dest] = input[src];
		input[src] = tmp;
	}
	
	/*
	 * Quicksort implementation using extra memory method (creating new buckets). Can replace partition_with_memory to use in_memory solution.
	 */
	public static void quicksort(Integer[] input, int start, int end) {
		System.out.println("Start=" + start + ", End=" + end + ", input=" + Arrays.toString(input));
		if (end == start) {
			return;
		}
		int pivot_index = partition_with_memory(input, start, end);
		if (pivot_index - 1 >= start)
			quicksort(input, start, pivot_index-1);
		if (end >= pivot_index + 1)
			quicksort(input, pivot_index+1, end);
	}
	
	/*
	 * Partition within memory.
	 */
	public static int partition_with_memory(Integer[] input, int start, int end) {
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
	
	/*
	 * Partition without using extra memory.
	 */
	public static int partition(Integer[] input, int start, int end) {
		Random random = new Random();
		int pivot = random.nextInt(end - start + 1) + start;
		swap(input, pivot, end);
		int small = start - 1;
		for (int i = start ; i < end; i++) {
			if (input[i] < input[end]) {
				++small;
				if (input[small] > input[i])
					swap(input, small, i);
			}
		}
		++small;
		if (small != end) {
			swap(input, small, end);
		}
		return small;
	}

}
