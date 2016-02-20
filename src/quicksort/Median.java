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
		Integer[] testIn = new Integer[]{3, 4, 2, 5, 6};
		System.out.println("median=" + median(testIn, 0, 4));
	}
	
	
	public static int median(Integer[] input, int start, int end) {
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
	
	
	public static void swap(Integer[] input, int src, int end) {
		int tmp = input[end];
		input[end] = input[src];
		input[src] = tmp;
	}
	public static int partition(Integer[] input, int start, int end) {
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
