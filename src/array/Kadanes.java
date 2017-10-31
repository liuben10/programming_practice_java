package array;

/**
 */
public class Kadanes {

	public static int kadanesNaive(int[] input) {
		int maxSoFar = 0;
		int maxUpTo = 0;

		for (int i = 0; i < input.length; i++) {
			int cur = input[i];
			maxUpTo = maxUpTo + cur;

			if (maxUpTo < 0) {
				maxUpTo = 0;
			}

			if (maxUpTo > maxSoFar) {
				maxSoFar = maxUpTo;
			}
		}

		return maxSoFar;
	}

	public static int maxSumCont(int[] input) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = Math.max(input[i], sum + input[i]);
			max = Math.max(max, sum);
		}

		return max;
	}


	public static int maxSumK(int[] input, int k) {

		int[] maxSums = new int[input.length];
		maxSums[0] = input[0];

		int curMax = input[0];

		for (int i = 1; i < input.length; i++) {
			curMax = Math.max(input[i], curMax + input[i]);
			maxSums[i] = Math.max(curMax, maxSums[i]);
		}

		int window = 0;
		for(int i = 0; i < k; i++) {
			window += input[i];
		}

		int result = window;
		int maxSumK = window;
		for(int i = k; i < input.length; i++) {
			window = window + input[i] - input[i-k];
			result = Math.max(result, window);
			maxSumK = Math.max(result, maxSums[i-k] + input[i]);
		}

		return maxSumK;
	}

	public static void main(String...args) {

//		System.out.println(maxSumCont(new int[]{5, -1, 3, 6, -2, 4}));
//
//		System.out.println(maxSumK(new int[]{1, -4, 3, 8, -1, 2, -1, -4}, 4));

		System.out.println(kadanesNaive(new int[]{5, -1, 6, -1000, 2000}));
	}
}
