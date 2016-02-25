package array;

import java.util.Arrays;

public class RotateMatrix {
	
	public static void main(String...args) {
		int[][] testIn = new int[][] {
				{3, 4, 5, 15},
				{6, 7, 8, 16},
				{9, 10, 11, 18},
				{20, 21, 22, 23}
		};
		rotate(testIn);
		System.out.println(Arrays.deepToString(testIn));
	}
	
	public static void rotate(int[][] input) {
		int N = input.length;
		int mid = (int) Math.ceil(input.length / 2);
		for (int i = 0; i < mid; i++) {
			rotateRow(input, i, i, N - 2 * i);
		}
	}
	
	public static void rotateRow(int[][] input, int row, int col, int N) {
		for(int i = col; i < N-1; i++) {
			rotateSingle(input, row, i, N);
		}
	}
	
	public static void rotateSingle(int[][] grid, int row, int col, int N) {
		int tmp = grid[row][col];
		grid[row][col] = grid[N-1-col][row];
		grid[N-1-col][row] = grid[N-1-row][N-1-col];
		grid[N-1-row][N-1-col] = grid[col][N-1-row];
		grid[col][N-1-row] = tmp;
	}

}
