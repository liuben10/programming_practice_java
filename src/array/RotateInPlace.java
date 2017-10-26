package array;

import java.util.Arrays;

/**
 */
public class RotateInPlace {

	public static void rotateInPlace(int[][] matrix, int N) {
		for (int i = 0; i < N / 2; i++) {
			rotateLayerInPlace(matrix, N, i);
		}
	}

	public static void rotateLayerInPlace(int[][] matrix, int N, int offset) {
		for(int i = (0 + offset); i < N-1-offset; i++) {
			int toSwap = matrix[0 + offset][i];
			int right = matrix[i][N-1-offset];
			matrix[i][N-1-offset] = toSwap;

			int bottom = matrix[N-1-offset][N-1-i];
			matrix[N-1-offset][N-1-i] = right;

			int left = matrix[N-1-i][0+offset];
			matrix[N-1-i][0+offset] = bottom;

			matrix[0+offset][i] = left;

			printMatrix(matrix);
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			System.out.println(Arrays.toString(matrix[j]));
		}

		System.out.println("----");
	}

	public static void main(String...args) {
		int[][] matrix = new int[][] {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
		};

		rotateInPlace(matrix, 4);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
