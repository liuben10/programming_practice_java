package dynamic;

import java.util.Arrays;

/**
 * Created by benjaminliu on 10/30/17.
 */
public class SubsetSumList {

	public static void printAllSubsetSums(int[] input, int N, int target, String subsetSoFar) {
		if (N == 0) {
			if (target == 0) {
				System.out.println(subsetSoFar);
			} else if (target == input[0]) {
				System.out.println(subsetSoFar + input[0]);
			}
		} else if (target == 0) {
			System.out.println(subsetSoFar);
		} else if (input[N] > target) {
			printAllSubsetSums(input, N-1, target, subsetSoFar);
		} else {
			String added = subsetSoFar + input[N] + ",";
			printAllSubsetSums(input, N-1, target - input[N], added);
			printAllSubsetSums(input, N-1, target, subsetSoFar);
		}
	}

	public static void printAllSubsetSumsDynamic(int[] input, int N, int target) {
		int[][] keep = new int[target+1][N+1];

		for (int i = 1; i <= target; i++) {
			for (int j = 1; j <= N ; j++) {

				if (i-input[j-1] >= 0 && j-1 >= 0) {
					keep[i][j] = input[j-1];
				} else {
					keep[i][j] = keep[i][j-1];
				}
			}
		}

		for (int i = 0; i < keep.length; i++) {
			System.out.println(Arrays.toString(keep[i]));
		}

		printSubsetSums(keep, target, N, "");
	}

	private static void printSubsetSums(final int[][] keep, int row, int col, String pathSoFar) {
		if (col == 0) {
			if (row == 0) {
				System.out.println(pathSoFar);
			} else {
				return;
			}
		} else if (row == 0) {
			System.out.println(pathSoFar);
			return;
		} else {
			printSubsetSums(keep, row - keep[row][col], col-1, pathSoFar + keep[row][col] + ",");
			printSubsetSums(keep, row, col-1, pathSoFar);
		}
	}


	public static void main(String...args) {
		final int[] testInput = {1, 3, 4, 5, 6, 15};
		printAllSubsetSumsDynamic(testInput, 6, 15);
	}
}
