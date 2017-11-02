package graph;

import java.util.*;

/**
 */
public class IslandProblem {

	static class Coord {
		int row;
		int col;

		public Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Coord coord = (Coord) o;

			if (row != coord.row) return false;
			return col == coord.col;
		}

		@Override
		public int hashCode() {
			int result = row;
			result = 31 * result + col;
			return result;
		}
	}

	Set<Coord> visited = new HashSet<>();

	public int countIslandsGraph(int[][] ocean) {
		int row = ocean.length;
		int col = ocean[0].length;
		int islandCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Coord coord = new Coord(i, j);
				if (ocean[i][j] == 1 && !visited.contains(coord)) {
					visitIsland(ocean, i, j);
					islandCount += 1;
				}
			}
		}
		return islandCount;
	}

	private void visitIsland(int[][] ocean, int row, int col) {
		Stack<Coord> fringe = new Stack<>();
		fringe.push(new Coord(row, col));

		while(!fringe.isEmpty()) {

			Coord cur = fringe.pop();

			visited.add(cur);

			for (Coord coord : successors(ocean, cur)) {
				if (!visited.contains(coord)) {
					fringe.add(coord);
				}
			}
		}
	}

	public List<Coord> successors(int[][] ocean, Coord coord) {

		int maxRow = ocean.length;
		int maxCol = ocean[0].length;

		List<Coord> coords = new ArrayList<>();

		if (coord.row + 1 < maxRow && ocean[coord.row+1][coord.col] == 1) coords.add(new Coord(coord.row + 1, coord.col));
		if (coord.col + 1 < maxCol && ocean[coord.row][coord.col+1] == 1) coords.add(new Coord(coord.row, coord.col+1));
		if (coord.row - 1 >= 0 && ocean[coord.row-1][coord.col] == 1) coords.add(new Coord(coord.row - 1, coord.col));
		if (coord.col - 1 >= 0 && ocean[coord.row][coord.col-1] == 1) coords.add(new Coord(coord.row, coord.col-1));

		return coords;
	}

	public static void main(String...args) {

		int[][] testIn = new int[][] {
				{1, 0, 0, 0, 0},
				{0, 0, 0, 1, 1},
				{0, 0, 0, 1, 0},
				{0, 1, 1, 0, 0}
		};

		IslandProblem problem = new IslandProblem();
		int solution = problem.countIslandsGraph(testIn);
		System.out.println(solution);

	}
}
