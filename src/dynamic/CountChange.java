package dynamic;

import java.util.Arrays;

/**
 * Created by benjaminliu on 9/27/17.
 */
public class CountChange {

	private static int countChangeNaive(int[] coins, int total, int i) {
		if (total == 0) {
			return 1;
		} else if (i == 0) {
			if (coins[i] < total) {
				return countChangeNaive(coins, total - coins[i], i);
			} else {
				if (coins[i] == total) {
					return 1;
				} else {
					return 0;
				}
			}
		} else if (coins[i] > total) {
			return countChangeNaive(coins, total, i-1);
		} else {
			return countChangeNaive(coins, total - coins[i], i) + countChangeNaive(coins, total, i-1);
		}
	}

	private static int countChange(int[] coins, int total) {
		int[][] V = new int[total+1][coins.length];

		for(int i = 0; i < coins.length; i++) {
			V[0][i] = 1;
		}

		for(int i = 1; i <= total; i++) {
			for(int j = 0; j < coins.length; j++) {
				int keep = (i - coins[j] >= 0) ? V[i-coins[j]][j] : 0;
				int dontKeep = (j >= 1) ? V[i][j-1] : 0;

				V[i][j] = keep + dontKeep;
			}
		}

		return V[total][coins.length - 1];
	}

	public static void main(String...args) {
		int[] testIn = {1, 2, 3};
		int testTotal = 4;
//		System.out.println(countChange(testIn, testTotal));
		System.out.println(countChangeNaive(testIn, testTotal, 2));
	}
}
