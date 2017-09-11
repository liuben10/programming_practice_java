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
			if (nums[i] > 0) {
				sumList.add(nums[i]);
				i += 1;
			} else {
				int j = i;
				int oddSum = 0;
				int evenSum = 0;
				List<Integer> odds = new ArrayList<>();
				List<Integer> evens = new ArrayList<>();
				while (j < nums.length && nums[j] < 0) {
					if ((j - i) % 2 == 0) {
						evenSum += nums[j];
						evens.add(nums[j]);
					} else {
						oddSum += nums[j];
						odds.add(nums[j]);
					}
					j++;
				}
				int max = Integer.max(evenSum, oddSum);
				if (max == evenSum) {
					sumList.addAll(evens);
				} else {
					sumList.addAll(odds);
				}
				i = j;
			}
		}
		return sumList;
	}

	public static void main(String...args) {
		System.out.println(maxSum(new int[]{10, 20, 30, -10, -50, 40, -50, -1, -3}));
		System.out.println(maxSum(new int[]{-1, -2, -3, -4, -5}));
	}
}
