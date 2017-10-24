package dynamic;

import java.util.Arrays;

/**
 * Created by liuben10 on 9/28/17.
 */
public class SubsetSumDynamic {

	private static int countSubsets(int[] S, int n) {
		int m = S.length;
		int[][] V = new int[n+1][m];
		int[][] eles = new int[n+1][m];

		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				int cur = S[j];
				if (cur > i) {
					V[i][j] = (j - 1 >= 0) ? V[i][j-1] : 0;
					if ((j - 1) >= 0) {
						eles[i][j] = eles[i][j-1];
					} else {
						eles[i][j] = 0;
					}
				} else {
					int isEqualTo = (i == cur) ? 1 : 0;
					int excludingLast = (j - 1 >= 0) ? V[i][j-1] : 0;
					int includingLast = (j - 1 >= 0 && i - cur >= 0) ? V[i-cur][j-1] : 0;
					V[i][j] = excludingLast + includingLast + isEqualTo;

					if (i - cur >= 0) {
						eles[i][j] = S[j];
					} else if (j - 1 >= 0) {
						eles[i][j] = S[j-1];
					} else {
						eles[i][j] = 0;
					}
				}
			}
		}

		for (int[] ints : V) {
			System.out.println(Arrays.toString(ints));
		}

		System.out.println("----");
		for (int[] ele : eles) {
			System.out.println(Arrays.toString(ele));
		}
		System.out.println("=====");
		return V[n][m-1];
	}

	public static void main(String...args) {
		System.out.println(countSubsets(new int[]{1, 2, 3, 4, 5}, 6));
	}
}
