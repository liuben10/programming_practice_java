package array;

import java.util.Arrays;
import java.util.Random;

/*
 * This problem is this. Given an array i.e. {3, 2, 5, 1, 6}. return an array sorted such that the elements alternate between big and small,
 * i.e. {3,2,5,1,6} could become [5, 2, 6, 1, 3]
 */
public class WigglySort {
	
	public static void main(String...args) {
		int[] toTest = {3, 2, 5, 1, 6};
		System.out.println(Arrays.toString(wigglySort(toTest)));
		
	}
	
	public static int[] wigglySort(int[] arr) {
		median(arr, 0, arr.length-1);
		int start = 0;
		int end = arr.length-1;
		int i = 0;
		int[] result = new int[arr.length];
		while (i < arr.length) {
			if (i % 2 == 0) {
				result[i] = arr[end];
				end -= 1;
			} else {
				result[i] = arr[start];
				start += 1;
			}
			i += 1;
		}
		return result;
	}
	
	public static void swap(int[] arr, int src, int dest) {
		int tmp = arr[src];
		arr[src] = arr[dest];
		arr[dest] = tmp;
	}
	
	public static int median(int[] arr, int src, int end) {
		if (src == end) {
			return arr[src];
		} else {
			int pivotIndex = partition(arr, src, end);
			int midpoint = (src + end) / 2;
			if (pivotIndex == midpoint) {
				return arr[pivotIndex];
			} else if (pivotIndex > midpoint) {
				return median(arr, src, pivotIndex-1);
			} else {
				return median(arr, pivotIndex+1, end);
			}
		}
	}
	
	public static int partition(int[] arr, int begin, int end) {
		Random r = new Random();
		int pivotIndex = r.nextInt(end - begin + 1) + begin;
		System.out.println("index=" + pivotIndex + ", pivot=" + arr[pivotIndex]);
		swap(arr, pivotIndex, end);
		int small = begin-1;
		for (int i = begin; i < end; i++) {
			if (arr[i] < arr[end]) {
				small += 1;
				if (arr[small] > arr[i]) {
					swap(arr, small, i);
				}
			}
		}
		small += 1;
		if (small != end) {
			swap(arr, small, end);
		}
		return small;
	}

}
