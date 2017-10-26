package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class King extends AbstractColoredChessPiece  {
	public King(String color, List<Integer> currentCoordinate) {
		super(color, "K", currentCoordinate);
	}

	@Override
	public List<List<Integer>> possibleMoves() {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleCoordinates = new ArrayList<>();
		if (row + 1 < 8) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row+1, col)));
		if (row + 1 < 8 && col + 1 < 8) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row+1, col+1)));
		if (row+1 < 8 && col - 1 >= 0) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row+1, col-1)));
		if (row - 1 >= 0) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row-1, col)));
		if (row - 1 >= 0 && col + 1 < 8) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row-1, col+1)));
		if (row - 1 >= 0 && col -1 >= 0) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row-1, col-1)));
		if (col+1 < 8) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row, col+1)));
		if (col-1 >= 0) possibleCoordinates.add(new ArrayList<>(Arrays.asList(row, col-1)));

		return possibleCoordinates;
	}
}
