package array;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class TwoSum {

	public static boolean twoSum(int[] testIn, int target) {
		Map<Integer, Integer> differences = new HashMap<>();
		for (int i : testIn) {
			differences.put(target-i, i);
		}

		for (int i = 0; i < testIn.length; i++) {
			if (differences.containsKey(testIn[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String...args) {
		System.out.println(twoSum(new int[] {5, 2, 3, 11, 4, 12}, 33));
	}
}
