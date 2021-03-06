package array;

public class FindInBinaryDiagonal {
	
	public static void main(String...args) {
		System.out.println(findInBinary(new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8 , 11, 15}}, 12));
	}
	
	public static boolean findInBinary(int[][] matrix, int value) {
		int rows = matrix.length;
		int cols = matrix[0].length;
	//	return findEasy(matrix, 12);
		return findCore(matrix, value, 0, 0, rows-1, cols-1);
	}
	
	private static boolean findEasy(int[][] matrix, int value) {
		int row = 0;
		int col = matrix[0].length-1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == value) {
				return true;
			}
			if (matrix[row][col] < value) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

	private static boolean findCore(int[][] matrix, int value, int row1, int col1,
			int row2, int col2) {
		if (value < matrix[row1][col1] || value > matrix[row2][col2]) {
			return false;
		}
		if (value == matrix[row1][col1] || value == matrix[row2][col2]) {
			return true;
		}
		int copyRow1 = row1;
		int copyRow2 = row2;
		int copyCol1 = col1;
		int copyCol2 = col2;
		int midRow = (row1 + row2) / 2;
		int midCol = (col1 + col2) / 2;
		while ((midRow != row1 || midCol != col1)
				&& (midRow != row2 || midCol != col2)) {
			if (value == matrix[midRow][midCol] || value == matrix[row1][col1]
					|| value == matrix[row2][col2]) {
				return true;
			} else {
				if (value < matrix[midRow][midCol]) {
					row2 = midRow;
					col2 = midCol;
				} else {
					row1 = midRow;
					col2 = midCol;
				}
				midRow = (row1 + row2) / 2;
				midCol = (col1 + col2) / 2;
			}
		}
		boolean found = false;
		if (midRow < matrix.length - 1) {
			found = findCore(matrix, value, midRow + 1, copyCol1, copyRow2, midCol);
		}
		if (!found && midCol < matrix[0].length - 1) {
			found = findCore(matrix, value, copyRow1, midCol + 1, midRow, copyCol2);
		}
		return found;
	}

}
