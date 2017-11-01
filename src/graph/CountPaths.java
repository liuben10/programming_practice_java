package graph;

import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 */
public class CountPaths {


	@NoArgsConstructor
	static class Coordinate {
		int row;
		int col;

		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}


	}

	public static int numPathsGraphSearch(int[][] matrix, int row, int col) {
		Stack<Coordinate> fringe = new Stack<>();

		fringe.push(new Coordinate(row, col));

		int numPaths = 0;


		while(!fringe.isEmpty()) {
			Coordinate cur = fringe.pop();
			if (cur.row == 0 && cur.col == 0) {
				numPaths += 1;
			} else {
				if (cur.row - 1 >= 0) {
					fringe.push(new Coordinate(cur.row-1, cur.col));
				}

				if (cur.col - 1 >= 0) {
					fringe.push(new Coordinate(cur.row, cur.col-1));
				}
			}
		}

		return numPaths;
	}

	public static void main(String...args) {
		int[][] matrix = new int[4][4];

		System.out.println(numPathsGraphSearch(matrix, 1, 1));
	}
}
