package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuben10 on 8/24/17.
 */
public class MaxSumSkip {

	private static List<Integer> maxSum(final int[] nums) {
		int i = 0;
		List<Integer> sumList = new ArrayList<>();
		while (i < nums.length) {
			System.out.println(i);
			if (nums[i] > 0) {
				sumList.add(nums[i]);
				i += 1;
			} else if (i + 1 < nums.length) {
				int max = Math.max(nums[i], nums[i + 1]);
				sumList.add(max);
				if (max == nums[i + 1]) {
					i += 2;
				} else {
					i += 1;
				}
			} else {
				i += 1;
			}

		}
		return sumList;
	}

	public static void main(String...args) {
		System.out.println(maxSum(new int[]{10, 20, 30, -10, -50, 40, -50, -1, -3}));
		System.out.println(maxSum(new int[]{-1, -2, -3, -4, -5}));

	}
}
