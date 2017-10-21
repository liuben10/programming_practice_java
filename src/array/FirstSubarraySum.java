package array;

/**
 */
public class FirstSubarraySum {

	public static int sum(int[] input, int target) {
		int sum = 0;

		int leftPtr = 0;
		int rightPtr = 0;

		while (leftPtr < input.length) {

			while (rightPtr < input.length && sum < target) {
				sum += input[rightPtr];
				rightPtr += 1;
			}

			if (sum == target) {
				return leftPtr;
			} else {
				sum -= input[leftPtr];
				leftPtr += 1;
			}
		}
		return -1;
	}

	public static void main(String...args) {
		System.out.println(sum(new int[]{3,8,13}, 11));
	}
}
