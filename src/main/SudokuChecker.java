package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuben10 on 3/13/17.
 */
public class SudokuChecker {

	public static void main(String...args) {
		char[][] input = new char[][]{
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','5','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'}
		};

		SudokuChecker m = new SudokuChecker();

		System.out.println(m.sudoku2(input));

	}

	boolean sudoku2(char[][] grid) {
		boolean rowValid = checkRows(grid);
		boolean colValid = checkCols(grid);
		boolean boxValid = checkBox(grid);
		System.out.println(rowValid + ", " + colValid + ", " + boxValid);
		return rowValid && colValid && boxValid;
	}

	boolean checkBox(char[][] grid) {
		for(int i = 0; i < grid.length; i += 3) {
			for(int j = 0; j < grid[0].length; j += 3) {
				Set<Character> toCheck = new HashSet<Character>();
				for(int idx = i; idx < i + 3; idx++) {
					for(int jdx = j; jdx < j + 3; jdx++) {
						char cur = grid[idx][jdx];
						if (toCheck.contains(cur)) {
							return false;
						} else if (Character.isDigit(cur)) {
							toCheck.add(cur);
						}
					}
				}
				if (!check(toCheck)) {
					return false;
				}
			}
		}
		return true;
	}

	boolean check(Set<Character> chars) {
		for(char c : chars) {
			int val = Integer.parseInt(String.valueOf(c));
			if (val > 9 || val == 0) {
				return false;
			}
		}
		return true;
	}

	boolean checkRows(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			Set<Character> chars = new HashSet<Character>();
			for(int j = 0; j < grid[i].length; j++) {
				if (chars.contains(grid[i][j])) {
					return false;
				} else if (Character.isDigit(grid[i][j])) {
					chars.add(grid[i][j]);
				}
			}
			if (!check(chars)) {
				return false;
			}
		}
		return true;
	}

	boolean checkCols(char[][] grid) {
		for(int i = 0; i < grid[0].length; i++) {
			Set<Character> chars = new HashSet<Character>();
			for(int j = 0; j < grid.length; j++) {
				if (chars.contains(grid[j][i])) {
					return false;
				} else if (Character.isDigit(grid[j][i])) {
					chars.add(grid[j][i]);
				}
			}
			if (!check(chars)) {
				return false;
			}
		}
		return true;
	}


}
