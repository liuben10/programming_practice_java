package dynamic;

/**
 * Count the number of permutations if you're only allowed to swap elements in a set by 1 place.
 *
 * i.e. 12345 has 8 possible perms.
 *
 * 12345,
 * 21345,
 * 21435,
 * 21354
 * 12435
 * 13245
 * 12354
 * 13254
 */
public class SwapPermutations {

	public static int dynamic(int[] input) {
		int[] dp = new int[input.length+1];
		if (input.length > 3) {
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= input.length; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			return dp[input.length];
		} else {
			return input.length;
		}
	}

	public static void main(String...args) {
		System.out.println(dynamic(new int[]{1, 2, 3, 4, 5}));
	}
}
