package dynamic;

import java.util.Arrays;

public class Knapsack {
	
	public static void main(String...args) {
		knapsack(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4 ,5}, 4, 10);
	}
	
	
	public static void knapsack(int[] values, int[] weights, int N, int maxCapacity) {
		int[][] m = new int[N+1][maxCapacity+1];
		int[][] keep = new int[N+1][maxCapacity];
		for(int i = 0; i <= N; i++) {
			for(int w = 0; w <= maxCapacity; w++) {
				if (i == 0 || w == 0) {
					m[i][w] = 0;
				} else if (weights[i - 1] <= w) {
					m[i][w] = Math.max(m[i - 1][w - weights[i - 1]] + values[i - 1], m[i - 1][w]);
				} else {
					m[i][w] = m[i - 1][w];
				}
			}
			System.out.println(Arrays.toString(m[i]));
		}
//		System.out.println(Arrays.deepToString(m));
	}

}
