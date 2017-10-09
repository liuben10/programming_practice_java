package array;

/**
 * Created by liuben10 on 10/8/17.
 */
public class ProperAlphabetSoup {

	public static boolean canFindInGrid(char[][] grid, String word) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				checkVerts(grid, i, j, word);
				checkHoriz(grid, i, j, word);
				checkDiags(grid, i, j, word);
			}
		}
	}

	private static boolean checkDiags(char[][] grid, int row, int col, String word) {
		int rows = grid.length;
		int cols = grid[0].length;


		int diagOffset = 0;

		StringBuilder sb = new StringBuilder();
		while (row - diagOffset >= 0 && row + diagOffset < rows && col - diagOffset >= 0 && col + diagOffset < cols) {
			if (sb.toString().contains(word)) {
				return true;
			}
			if (diagOffset == 0) {
				sb.append(grid[row][col]);
			} else {
				sb.insert(0, grid[row-diagOffset][col-diagOffset]).append(grid[row + diagOffset][col + diagOffset]);
			}
		}
		return false;
	}

	private static boolean checkHoriz(char[][] grid, int row, int col, String word) {
		int cols = grid[0].length;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cols; i++) {
			sb.append(grid[row][i]);
			if (sb.toString().contains(word)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkVerts(char[][] grid, int row, int col, String word) {
		int rows = grid.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			sb.append(grid[i][col]);
			if (sb.toString().contains(word)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String...args) {
		char[][] testGrid = {
				{'f', 'b', 'd', 'e'},
				{'h', 'k', 'h', 'j'},
				{'m', 'l', 'i', 't'},
				{'b', 'f', 't', 'd'}
		};
		System.out.println(canFindInGrid(testGrid, "kid"));
	}
}
