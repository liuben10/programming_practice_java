package array;

import java.util.Arrays;

public class FlipMatrix {
	
	public static void main(String...args) {
		int[][] square = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		square = rotate270(square);
		System.out.println(Arrays.deepToString(square));
		
	}
	
	public static int[][] rotate90(int[][] matrix) {
		int N = matrix.length;
		int[][] newMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMatrix[j][N-1-i] = matrix[i][j];
			}
		}
		return newMatrix;
	}
	
	public static int[][] rotate270(int[][] matrix) {
		int N = matrix.length;
		int[][] newMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMatrix[N-1-j][i] = matrix[i][j];
			}
		}
		return newMatrix;
	}
	
	public static int[][] flipAcrossMainAxis(int[][] matrix) {
		int N = matrix.length;
		int[][] newMatrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMatrix[i][j] = matrix[j][i];
			}
		}
		return newMatrix;
	}

}
