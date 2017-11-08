package csp;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 */
public class EightQueensProblem {

	Set<Coordinate> assignments = new HashSet<>();

	public static Set<Coordinate> assign(String[][] board, Set<Coordinate> assignments) {
		if (assignments.size() >= 8) {
			return assignments;
		} else {
			Set<Coordinate> copyOfAssignments = new HashSet<>(assignments);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (place(board, i, j)) {
						Coordinate toAssign = new Coordinate(i, j);
						copyOfAssignments.add(toAssign);
						board[i][j] = "Q";
						Set<Coordinate> assigned = assign(board, copyOfAssignments);
						if (assigned == null) {
							copyOfAssignments.remove(toAssign);
							board[i][j] = "";
						} else {
							return copyOfAssignments;
						}
					}
				}
			}
			return null;
		}
	}

	public static boolean place(String[][] board, int i, int j) {
		if (board[i][j].equals("Q")) {
			return false;
		} else {
			board[i][j] = "Q";
			boolean result = isValidPlacement(board);
			board[i][j] = "";
			return result;
		}
	}

	public static boolean isValidPlacement(String[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j].equals("Q")) {
					boolean cols = checkCols(board, i, j);
					boolean rows = checkRows(board, i, j);
					boolean diags = checkDiags(board, i, j);
					if (!cols || !rows || !diags) {
						return false;
					}

				}
			}
		}
		return true;
	}

	private static boolean checkCols(String[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col].equals("Q") && i != row) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkRows(String[][] board, int row, int col) {
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i].equals("Q") && i != col) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkDiags(String[][] board, int row, int col) {
		int i = row;
		int j = col;

		while (i < board.length && j < board[0].length) {
			if (board[i][j].equals("Q") && i != row && j != col) {
				return false;
			}
			i += 1;
			j += 1;
		}

		i = row;
		j = col;

		while (i >= 0 && j < board[0].length) {
			if (board[i][j].equals("Q") && i != row && j != col) {
				return false;
			}
			i -= 1;
			j += 1;
		}

		i = row;
		j = col;
		while (i >= 0 && j >= 0) {
			if (board[i][j].equals("Q") && i != row && j != col) {
				return false;
			}
			i -= 1;
			j -= 1;
		}
		i = row;
		j = col;
		while (i < board.length && j >= 0) {
			if (board[i][j].equals("Q") && i != row && j != col) {
				return false;
			}
			i += 1;
			j -= 1;
		}

		return true;
	}

	public static String[][] queenPlacement() {

		String[][] board = new String[][] {
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", ""},
		};

		HashSet<Coordinate> assignments = new HashSet<>();
		Set<Coordinate> finalAssignments = assign(board, assignments);
		for (Coordinate coord : finalAssignments) {
			board[coord.row][coord.col] = "Q";
		}
		return board;
	}

	public static void main(String...args) {

		String[][] board = queenPlacement();

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}

	@AllArgsConstructor
	private static class Coordinate {
		int row;
		int col;
	}
}
