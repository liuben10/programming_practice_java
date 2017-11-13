package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class ThreeSum {

	public static boolean hasTwoSum(int[] input, int target) {
		Map<Integer, Integer> diffs = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			diffs.put(target - input[i], i);
		}

		for (int i = 0; i < input.length; i++) {
			if (diffs.containsKey(input[i]) && diffs.get(input[i]) != i) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasThreeSum(int[] input, int target) {

		for (int i = 0; i < input.length; i++) {
			int[] lowerCopy = Arrays.copyOfRange(input, 0, i);
			int[] upperCopy = Arrays.copyOfRange(input, i+1, input.length);
			int[] combined = new int[lowerCopy.length + upperCopy.length];
			for (int j = 0; j < lowerCopy.length; j++) {
				combined[j] = lowerCopy[j];
			}

			for (int j = 0; j < upperCopy.length; j++) {
				combined[lowerCopy.length + j] = upperCopy[j];
			}

			if (hasTwoSum(combined, target - input[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String...args) {
		System.out.println(hasThreeSum(new int[]{3, 5, 2, 9}, 11));
	}
}

