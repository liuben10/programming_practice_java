package array;

/**
 */
public class MaximumSumContiguous {

	public static int maxSumCont(int[] input) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = Math.max(input[i], sum + input[i]);
			max = Math.max(max, sum);
		}

		return max;
	}

	public static void main(String...args) {
		System.out.println(maxSumCont(new int[]{5, -1, 3, 6, -2, 4}));
	}
}
