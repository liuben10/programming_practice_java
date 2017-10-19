package dynamic;

import java.util.Arrays;

/**
 */
public class ChocolateDistribute {

	public static int chocoDistribute(int[] colleagues) {
		if (colleagues.length == 1) {
			return 0;
		}
		Arrays.sort(colleagues);
		int min = colleagues[0];
		for(int i = 0; i < colleagues.length; i++) {
			int diff = colleagues[i] - min;
			colleagues[i] = diff;
		}
		int smallestNonZero = 1;
		int ops = 0;
		while(smallestNonZero < colleagues.length) {
			int diff = colleagues[smallestNonZero];
			if (diff == 0) {
				smallestNonZero += 1;
				continue;
			}
			if (diff >= 5) {
				colleagues[smallestNonZero] -= 5;
			} else if (diff >= 2) {
				colleagues[smallestNonZero] -= 2;
			} else {
				colleagues[smallestNonZero] -= 1;
			}
			ops += 1;
		}

		return ops;
	}

	public static void main(String...args) {
		System.out.println(chocoDistribute(new int[]{2, 2, 3, 7}));
	}
}
