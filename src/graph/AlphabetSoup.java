package graph;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by benjaminliu on 8/11/16.
 */
public class AlphabetSoup {

	/** */
	public static void main(String[] args) throws Exception {
		String[][] alphabetSoup  = {
				{"R", "E", "T"},
				{"B", "E", "T"},
				{"X", "F", "G"},
		};

		System.out.println(exists("BETTER", alphabetSoup));
	}

	private static boolean exists(String word, String[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		for(int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				final String firstLetter = word.substring(0, 1);
				if (grid[y][x].equals(firstLetter)) {
					final boolean found = search(word, grid, x, y, row, col);
					if (found) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean search(final String word, final String[][] grid, final int x, final int y, final int row, final int col) {
		final Queue<List<Integer>> fringe = new LinkedList<>();
		final Set<List<Integer>> visited = new HashSet<>();
		final StringBuilder currentWord = new StringBuilder(word.substring(0, 1));
		fringe.add(Lists.newArrayList(x, y));

		while(!fringe.isEmpty()) {
			final List<Integer> currentCoordinate = fringe.remove();
			visited.add(currentCoordinate);

			List<List<Integer>> successors = successors(currentCoordinate.get(0), currentCoordinate.get(1), row, col);
			for (List<Integer> successor : successors) {
				if (!visited.contains(successor) && !fringe.contains(successor)) {
					final String currentLetter = getLetterAt(grid, successor);
					if ((currentWord + currentLetter).equals(word.substring(0, currentWord.length() + 1))) {

						fringe.add(successor);
						currentWord.append(currentLetter);

						if (currentWord.toString().equals(word)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static String getLetterAt(final String[][] grid, final List<Integer> coord) {
		return grid[coord.get(1)][coord.get(0)];
	}

	private static List<List<Integer>> successors(final int x, final int y, final int row, final int col) {
		final List<List<Integer>> successors = new ArrayList<>();
		if (x - 1 >= 0) {
			successors.add(Lists.newArrayList(x-1, y));
		}
		if (x + 1 < col) {
			successors.add(Lists.newArrayList(x+1, y));
		}
		if (y-1 >= 0) {
			successors.add(Lists.newArrayList(x, y-1));
		}
		if (y+1 < row) {
			successors.add(Lists.newArrayList(x, y+1));
		}
		return successors;
	}

}
