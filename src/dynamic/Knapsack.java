package dynamic;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	public static void main(String...args) {
		int[] values = {3, 7, 2};
		int[] weights = {2, 5, 1};
		int knapsack = knapsack(values, weights, 3, 10);
		System.out.println(knapsack);
		System.out.println(knapsackNaive(values, weights, 2, 10));
	}


	public static int knapsackNaive(int[] values, int[] weights, int N, int maxCapacity) {
		if (maxCapacity == 0) {
			return 0;
		} else if (N == 0) {
			if (weights[0] <= maxCapacity) {
				return values[0];
			} else {
				return 0;
			}
		} else {
			if (weights[N] > maxCapacity) {
				return knapsackNaive(values, weights, N-1, maxCapacity);
			}
			return Math.max(
					knapsackNaive(values, weights, N-1, maxCapacity-weights[N]) + values[N],
					knapsackNaive(values, weights, N-1, maxCapacity)
			);
		}
	}

	//This is 0/1 knapsack.
	
	public static int knapsack(int[] values, int[] weights, int N, int maxCapacity) {
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


		}

		ArrayList<Integer> pathSoFar = new ArrayList<>();
		findPath(values, weights, keep, N, maxCapacity, pathSoFar);

		System.out.println(pathSoFar);

		return m[N][maxCapacity];
//		System.out.println(Arrays.deepToString(m));
	}

	private static void findPath(int[] values, int[] weights, int[][] keep, int position, int capacity, List<Integer> pathSoFar) {
		if (position == 0 || capacity == 0) {
			return;
		} else {
			if (keep[position][capacity] == values[position-1]) {
				pathSoFar.add(values[position-1]);
				findPath(values, weights, keep, position-1, capacity-weights[position-1], pathSoFar);
			} else {
				findPath(values, weights, keep, position-1, capacity, pathSoFar);
			}
		}
	}

}
