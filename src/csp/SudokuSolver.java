package csp;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;

/**
 */
@SuppressWarnings("Duplicates")
public class SudokuSolver {

	Set<Coordinate> domain = new HashSet<>();

	int[][] sudoku = new int[9][9];

	public SudokuSolver(int[][] sudoku) {
		this.sudoku = sudoku;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					domain.add(new Coordinate(i, j));
				}
			}
		}
	}

	public void printSudoku() {
		for (int i = 0; i < sudoku.length; i++) {
			System.out.println(Arrays.toString(sudoku[i]));
		}
	}

	public void fillOutSudoku() {
		Map<Coordinate, Integer> solved = solve(new HashMap<>(), domain.iterator().next());
		if (solved == null) {
			throw new RuntimeException("No assignment was made");
		}

		for (Map.Entry<Coordinate, Integer> pair : solved.entrySet()) {
			Coordinate coordinate = pair.getKey();
			sudoku[coordinate.row][coordinate.col] = pair.getValue();
		}
	}

	public Map<Coordinate, Integer> solve(Map<Coordinate, Integer> assignments, Coordinate next) {
		Sets.SetView<Coordinate> unassigned = Sets.difference(domain, assignments.keySet());

		if (unassigned.isEmpty() && !assignments.keySet().isEmpty()) {
			return assignments;
		} else {
			HashMap<Coordinate, Integer> copy = new HashMap<>();
			copy.putAll(assignments);
			for (int i = 1; i < 10; i++) {
				copy.put(next, i);
				if (verify(copy)) {
					Coordinate nextToCheck = unassigned.iterator().next();

					Map<Coordinate, Integer> solvable = solve(copy, nextToCheck);
					if (solvable != null) {
						return solvable;
					} else {
						continue;
					}
				}
			}
			return null;
		}
	}

	private boolean verify(Map<Coordinate, Integer> assignments) {
		int[][] sudokuCopy = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuCopy[i][j] = sudoku[i][j];
			}
		}
		for (Coordinate coordinate : assignments.keySet()) {
			sudokuCopy[coordinate.row][coordinate.col] = assignments.get(coordinate);
		}

		for (int i = 0; i < sudokuCopy.length; i++) {
			System.out.println(Arrays.toString(sudokuCopy[i]));
		}
		System.out.println("-----");

		boolean colsVer = verifyCols(sudokuCopy);
		boolean rowsVer = verifyRows(sudokuCopy);
		boolean boxVer = verifySquares(sudokuCopy);

		return colsVer && rowsVer && boxVer;
	}

	public boolean verifyRows(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			int sum = 0;
			Set<Integer> dups = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					return true;
				}
				sum += sudoku[i][j];
				if (dups.contains(sudoku[i][j])) {
					return false;
				} else {
					dups.add(sudoku[i][j]);
				}
			}
			if (sum != 45) {
				return false;
			}
		}
		return true;
	}

	public boolean verifyCols(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			int sum = 0;
			Set<Integer> dups = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (sudoku[j][i] == 0) {
					return true;
				}
				sum += sudoku[j][i];
				if (dups.contains(sudoku[j][i])) {
					return false;
				} else {
					dups.add(sudoku[j][i]);
				}
			}
			if (sum != 45) {
				return false;
			}
		}
		return true;
	}

	public boolean verifySquares(int[][] sudoku) {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j+= 3) {
				int sum = 0;
				for (int k = i; k < i+3; k++) {
					Set<Integer> dups = new HashSet<>();
					for (int l = j; l < j+3; l++) {
						if (sudoku[k][l] == 0) {
							return true;
						}
						sum += sudoku[k][l];
						if (dups.contains(sudoku[k][l])) {
							return false;
						} else {
							dups.add(sudoku[k][l]);
						}
					}
				}
				if (sum != 45) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String...args) {
		SudokuSolver solver = new SudokuSolver(new int[9][9]);
		solver.fillOutSudoku();
		solver.printSudoku();
	}

	@Data
	@AllArgsConstructor
	@Builder
	private static class Coordinate {
		int row;
		int col;
	}
}
