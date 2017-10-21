package dynamic;

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
	public static int countWaysNaive(int m, int n, int k) {
		if (m == 1 && n <= k) {
			return 1;
		} else if (m == 1) {
			return 0;
		}

		int sum = 0;
		for (int i = m; i >= 0; i--) {
			sum += countWaysNaive(m-1, n, k-m);
		}
		return sum;
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
		System.out.println(countWaysNaive(2, 3, 5) + ", " + countWays(2, 3, 5));
	}
}
