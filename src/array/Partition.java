package array;

import java.util.Arrays;
import java.util.Random;

/**
 */
public class Partition {

	public static int partition(int[] input) {
		if (input.length == 1) {
			return 0;
		}
		Random r = new Random();
		int randomIndx = r.nextInt(input.length);
		int partitioning = input[randomIndx];

		swap(input, randomIndx, input.length - 1);

		int fast;
		int slow = 0;

		for(fast = 1; fast < input.length; fast++) {
			if (input[fast] < partitioning) {
				swap(input, fast, slow);
				slow += 1;
			} else if (input[slow] < partitioning) {
				slow += 1;
			}
		}

		swap(input, slow, input.length - 1);

		return slow;
	}

	public static void swap(int[] input, int src, int dest) {
		int tmp = input[src];
		input[src] = input[dest];
		input[dest] = tmp;
	}

	public static void main(String...args) {
		int[] input = {1, 3, 5, 4, 6, 9, 2, 11};
		System.out.println(partition(input));
		System.out.println(Arrays.toString(input));
	}
}
