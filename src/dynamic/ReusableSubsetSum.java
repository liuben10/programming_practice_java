package dynamic;

import java.util.Arrays;

/**
 */
public class ReusableSubsetSum {


	public static int reusableNaive(int[] in, int N, int target) {
		if (N == 0) {
			return 0;
		} else if (target == 0) {
			return 1;
		} else if (in[N-1] > target) {
			return reusableNaive(in, N-1, target);
		} else {
			return reusableNaive(in, N-1, target) + reusableNaive(in, N, target-in[N-1]);
		}
	}


	public static int reusableDynamic(int[] in, int N, int target) {
		int[][] table = new int[target+1][N+1];

		for (int i = 0; i <= N; i++) {
			table[0][i] = 1;
		}

		for (int i = 1; i <= target; i++) {
			for (int j = 1; j <= N; j++) {
				int cur = in[j-1];
				int keeps = (i - cur >= 0) ? table[i-cur][j] : 0;
				int leaves = (j-1 >= 0) ? table[i][j-1] : 0;
				table[i][j] = keeps + leaves;
			}
		}

		for (int i = 0; i < table.length; i++) {
			System.out.println(Arrays.toString(table[i]));
		}

		return table[target][N];
	}

	public static void main(String...args) {
		System.out.println(reusableNaive(new int[]{3, 6}, 2, 9));
		System.out.println(reusableDynamic(new int[]{3, 6}, 2, 9));
	}
}
