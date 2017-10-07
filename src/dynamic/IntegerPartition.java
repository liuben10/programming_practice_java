package dynamic;

import java.util.*;

/**
 * Created by liuben10 on 9/28/17.
 */
public class IntegerPartition {


	public static void partition(int n, int max, String prefix) {
		System.out.println("partition subproblem: " + n + ", " + max + ", " + prefix);
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			partition(n-i, i, prefix + " " + i);
		}
	}

	/**
	 * [0,0,0,0]
	 * [, ,  ,1]
	 * [, ,1,2]
	 * [, , ,]
	 * [, , ,]
	 * [, ,1 ,3]
	 * @param n
	 * @param max
	 */
	public static void partitionDynamic(int n, int max) {
		int[][] V = new int[n+1][max+1];
		int[][] keeps = new int[n+1][max+1];
		V[0][0] = 1;
		for(int j = 0; j <= n; j++) {
			for(int i = 0; i <= max; i++) {
				if (i > j) {
					V[j][i] = (i-1 >= 0) ? V[j][i-1] : 0;
					keeps[j][i] = (i-1 >= 0) ? keeps[j][i-1] : 0;
				} else {
					int prevWays = (i-1 >= 0) ? V[j][i-1] : 0;
					int curWays = (j - i >= 0) ? V[j-i][i] : 0;
					if (j - i >= 0) {
						keeps[j][i] = i;
					}
					V[j][i] = prevWays + curWays;
				}
			}
			for (int[] ints : V) {
				System.out.println(Arrays.toString(ints));
			}
			System.out.println("----");
			for (int[] keep : keeps) {
				System.out.println(Arrays.toString(keep));
			}
			System.out.println("=====");
		}

//		int i = max;
//		int j = n;

		Set<List<Integer>> solutions = new HashSet<>();
		printPaths(keeps, n, max, new ArrayList<>(), solutions);
		System.out.println(solutions);
	}

	private static void printPaths(int[][] keeps, int row, int col, List<Integer> paths, Set<List<Integer>> solutions) {
//		System.out.println("printPaths: " + row + ", " + col + ", " + paths);
		if (row == 0 || col == 0) {
			int sum = 0;
			for (Integer path : paths) {
				sum += path;
			}
			if (sum == keeps.length-1) {
				solutions.add(paths);
//				System.out.println(paths);
			}
			return;
		} else {
			ArrayList<Integer> addedPath = new ArrayList<>(paths);
			addedPath.add(keeps[row][col]);
			printPaths(keeps, row - keeps[row][col], col, addedPath, solutions);
			printPaths(keeps, row, col - 1, paths, solutions);
		}
	}


	public static void main(String...args) {
		/**
		 * 2, 2
		 * 2, 1, 1
		 * 1, 1, 1, 1
		 */
//		partition(4, 2, "");
		/**
		 * 3, 2
		 * 3, 1, 1
		 * 2, 2, 1
		 * 2, 1, 1, 1
		 * 1, 1, 1, 1, 1
		 */
		partitionDynamic(5, 3);
	}
}
