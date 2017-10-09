package array;

public class PrintMatrixSpiral {


	public static void printMatrix(int[][] matr) {
		int max_row = matr.length;
		int max_col = matr[0].length;

		int[] centerCoord = findCenter(matr);

		int row = centerCoord[0];
		int col = centerCoord[1];
		System.out.println(matr[row][col]);

		int offset = 1;
		int startingRow = row;
		while (col + offset < max_col && row - offset >= 0) {

			for (int i = startingRow; i < row + offset; i++) { //print lower leg
				System.out.println(matr[i][col + offset]);
			}

			for (int i = col + offset; i > col - offset; i -= 1) {
				System.out.println(matr[row + offset][i]);
			}

			for (int i = row + offset; i > row - offset; i -= 1) {
				System.out.println(matr[i][col - offset]);
			}

			for (int i = col - offset; i <= col + offset; i += 1) {
				System.out.println(matr[row - offset][i]);
			}

			offset += 1;
			startingRow = startingRow - 1;
		}
	}

	private static int[] findCenter(final int[][] matr) {
		int max_row = matr.length;
		int max_col = matr[0].length;

		return new int[]{max_row / 2, max_col / 2};

	}

	public static void main(String...args) {

		int[][] matrix = {
				{1,  2,   3,  4,  5},
				{6,  7,   8,  9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};


		printMatrix(matrix);
	}

}
