package array;

/**
 */
public class PrintDiags {

	public static void printDiags(int[][] testIn, int i, int j) {

		int maxRow = testIn.length;
		int maxCol = testIn[0].length;
		int row = i;
		int col = j;
		int rowOffset = 1;
		int colOffset = 1;
		System.out.println(testIn[row][col]);

		while ((row - rowOffset >= 0 && col - colOffset >= 0)) {
			System.out.println(testIn[row-rowOffset][col-colOffset]);
			rowOffset += 1;
			colOffset += 1;
		}


		rowOffset = 1;
		colOffset = 1;
		while ((row - rowOffset >= 0 && col + colOffset < maxCol)) {
			System.out.println(testIn[row-rowOffset][col+colOffset]);
			rowOffset += 1;
			colOffset += 1;
		}

		rowOffset = 1;
		colOffset = 1;
		while ((row + rowOffset < maxRow && col + colOffset < maxCol)) {
			System.out.println(testIn[row+rowOffset][col+colOffset]);
			rowOffset += 1;
			colOffset += 1;
		}

		rowOffset = 1;
		colOffset = 1;
		while ((row  + rowOffset < maxRow && col - colOffset >= 0)) {
			System.out.println(testIn[row+rowOffset][col-colOffset]);
			rowOffset += 1;
			colOffset += 1;
		}
	}

	public static void main(String...args) {
		int[][] testIn = new int[][] {
				{4, 10, 3, 9},
				{5, 2, 19, 4},
				{6, 8, 12, 3},
				{4, 3, 5, 11}
		};
		printDiags(testIn, 1, 3);
	}
}
