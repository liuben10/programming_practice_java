package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class DiceProblem {

	/**
	 *
	 * @param m dices,
	 * @param n faces
	 * @param k target
	 * @return
	 */
	public static int countWaysNaive(int m, int n, int k, List<Integer> waysSoFar) {
		if (m == 1) {
			if (k == 0) {
				return 0;
			}
			if (n >= k) {
				waysSoFar.add(k);
				System.out.println(waysSoFar);
				return 1;
			}
			return 0;
		} else if (n == 0) {
			return 0;
		} else if (k == 0) {
			return 1;
		} else {
			int sum = 0;
			for (int face = 1; face < n && k-face >= 0; face++) {
				ArrayList<Integer> rolledSoFar = new ArrayList<>(waysSoFar);
				rolledSoFar.add(face);
				sum += countWaysNaive(m-1, n, k-face, rolledSoFar);
			}
			return sum;
		}
	}

	/**
	 *
	 * @param m dices,
	 * @param n faces
	 * @param k target
	 * @return
	 */
	public static int countWays(int m, int n, int k) {
		int[][] V = new int[m + 1][k + 1];

		for (int i = 1; i <= n && i <= k; i++) {
			V[1][i] = 1;
		}

		for (int i = 2; i <= m; i++)
			for (int j = 1; j <= k; j++)
				for (int l = 1; l <= k && l < j; l++)
					V[i][j] += V[i - 1][j - l];


		return V[m][k];
	}

	public static void main(String...args) {

		System.out.println(countWaysNaive(3, 6, 5, new ArrayList<>()));
	}
}
