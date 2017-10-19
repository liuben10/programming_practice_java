package dynamic;

import java.util.Arrays;

public class Knapsack {
	
	public static void main(String...args) {
		knapsack(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4 ,5}, 4, 10);
	}
	
	
	public static void knapsack(int[] values, int[] weights, int N, int maxCapacity) {
		int[][] m = new int[N+1][maxCapacity+1];
		int[][] keep = new int[N+1][maxCapacity+1];
		for(int i = 0; i <= N; i++) {
			for(int w = 0; w <= maxCapacity; w++) {
				if (i == 0 || w == 0) {
					m[i][w] = 0;
				} else if (weights[i - 1] <= w) {
					int weighttaken = m[i - 1][w - weights[i - 1]] + values[i - 1];
					m[i][w] = Math.max(weighttaken, m[i - 1][w]);
					if (m[i][w] == weighttaken) {
						keep[i][w] = values[i-1];
					} else {
						keep[i][w] = keep[i-1][w];
					}
				} else {
					m[i][w] = m[i - 1][w];
				}
			}
//			System.out.println(Arrays.toString(m[i]));

			for(int j = 0; j < m.length; j++) {
				System.out.println(Arrays.toString(m[j]));
			}
			System.out.println("----");
			for (int j = 0; j < keep.length; j++) {
				System.out.println(Arrays.toString(keep[j]));
			}
			System.out.println("=====");
		}
//		System.out.println(Arrays.deepToString(m));
	}

}
