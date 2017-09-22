package array;

public class PrintMatrixSpiral {


	public static void printMatrix(int[][] matr) {
		int max_row = matr.length;
		int max_col = matr[0].length;

		int[] centerCoord = findCenter(matr);

		int row = centerCoord[0];
		int col = centerCoord[1];
		System.out.println(matr[row][col]);
		while(col < max_col) {
			col = col + 1;
			while (row < max_row) {
				row += 1;
				System.out.println(matr[row][col]);
				while (row >= 0) {
					row--;
				//TODO Finish me
				}
			}

		}


	}

	private static int[] findCenter(final int[][] matr) {
		int max_row = matr.length;
		int max_col = matr[0].length;

		return new int[]{max_row / 2, max_col / 2};

	}

	public static void main(String...args) {


		int[][] matrix = {
				{1, 2, 4},
				{7, 8, 9},
				{12, 13, 14}
		};

		printMatrix(matrix);
	}

}
