package array;

import java.util.Arrays;

public class MatrixMultiply {
	
	public static void main(String...args) {
		int[][] a = new int[][] {
			{2, 4, 5},
			{6, 7, 8}
		};
		int[][] b = new int[][] {
			{9, 12},
			{10, 13},
			{11, 14}
		};
		System.out.println(Arrays.deepToString(matrixMultiply(a, b)));
	}

	
	public static int[][] matrixMultiply(int[][] a, int[][] b) {
		int aRow = a.length;
		int aCol = a[0].length;
		int bRow = b.length;
		int bCol = b[0].length;
		if (aCol != bRow) {
			throw new IllegalArgumentException("Unable to multiply");
		}
		int[][] res = new int[aRow][bCol];
		for(int i = 0; i < aRow; i++) {
			for(int j = 0; j < bCol; j++) {
				for(int m = 0; m < aCol; m++) {
					res[i][j] += a[i][m] * b[m][j];
				}
			}
		}
		return res;
	}
}
