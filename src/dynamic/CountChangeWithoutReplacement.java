package dynamic;

import java.util.Arrays;

/**
 */
public class CountChangeWithoutReplacement {

	public static int waysToMakeChangeNaive(int[] coins, int N, int target) {
		if (N == 0) {
			if (coins[0] == target) {
				return 1;
			} else {
				return 0;
			}
		} else if (target == 0) {
			return 1;
		} else if (coins[N] > target) {
			return waysToMakeChangeNaive(coins, N-1, target);
		} else {
			return waysToMakeChangeNaive(coins, N-1, target-coins[N]) +
					waysToMakeChangeNaive(coins, N-1, target);
		}
	}

	public static int waysToMakeChange(int[] coins, int N, int target) {
		int[][] table = new int[target+1][N+1];

		for (int i = 0; i < N; i++) {
			table[0][i] = 1;
		}

		for (int i = 1; i <= target ; i++) {
			for (int j = 1; j <= N; j++) {
				int cur = coins[j-1];
				if (cur > i) {
					table[i][j] = (j-1 >= 0 ? table[i][j-1] : 0);
				} else {
					int keep = (i - cur >= 0 && j - 1 >= 0) ? table[i-cur][j-1] : 0;
					int leave = (j - 1 >= 0) ? table[i][j-1] : 0;
					table[i][j] = keep + leave;
				}
			}
		}

		for (int i = 0; i < table.length; i++) {
			System.out.println(Arrays.toString(table[i]));
		}

		return table[target][N];
	}

	public static void main(String...args) {
		int[] coins = {5, 3, 9};
		System.out.println(waysToMakeChangeNaive(coins, 2, 12));
		System.out.println(waysToMakeChange(coins, 3, 12));
	}
}
