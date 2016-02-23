package quicksort;

import java.util.Random;

public class Partition {
	
	public static void main(String...args) {
		
	}
	
	public static void swap(Integer[] input, int src, int dest) {
		Integer tmp = input[dest];
		input[dest] = input[src];
		input[src] = tmp;
	}
	
	public static int partition(Integer[] input, int start, int end) {
		if (end < start) {
			throw new IllegalArgumentException("end cannot be less than start");
		}
		Random random = new Random();
		int randomPivot = random.nextInt(end-start+1) + start;
		swap(input, randomPivot, end);
		int small = start-1;
		for (int i = start; i < end; i++) {
			if (input[i] < input[end]) {
				++small;
				if (input[i] > input[small]) {
					swap(input, small, i);
				}
			}
		}
		++small;
		if (small != end) {
			swap(input, small, end);
		}
		return small;
	}
	
	

}
