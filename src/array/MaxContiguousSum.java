package array;

/**
 */
public class MaxContiguousSum {


	public static int maxContiguousSum(int[] testIn) {
		int leftPtr = 0;
		int rightPtr = 0;

		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		while(leftPtr < testIn.length) {

			while (rightPtr < testIn.length && testIn[rightPtr] >= 0) {
				sum += testIn[rightPtr];
				rightPtr += 1;
			}

			if (rightPtr <= testIn.length) {
				rightPtr += 1;
				leftPtr = rightPtr;
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = 0;
			}
		}

		return maxSum;
	}

	public static void main(String...args) {
		System.out.println(maxContiguousSum(new int[]{5, 2, -3, 12, 16, -8, -9, -10, 33}));
	}
}
