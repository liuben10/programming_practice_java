package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class Rook extends AbstractColoredChessPiece {
	public Rook(String color, List<Integer> currentCoordinate) {
		super(color, "R", currentCoordinate);
	}


	@Override
	List<List<Integer>> possibleMoves() {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleMoves = new ArrayList<>();
		for (int offset = 0; offset < 8; offset++) {
			if (row + offset < 8) possibleMoves.add(new ArrayList<>(Arrays.asList(row + offset, col)));
			if (row - offset >= 0) possibleMoves.add(new ArrayList<>(Arrays.asList(row - offset, col)));
			if (col + offset < 8) possibleMoves.add(new ArrayList<>(Arrays.asList(row, col + offset)));
			if (col - offset >= 0) possibleMoves.add(new ArrayList<>(Arrays.asList(row, col - offset)));
		}

		return possibleMoves;
	}
}
