package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.ChessBoard.BLACK;

/**
 */
public class Pawn  extends AbstractColoredChessPiece  {
	public Pawn(String color, List<Integer> currentCoordinate) {
		super(color, "P", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves() {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		if (color.equals(BLACK)) {
			List<List<Integer>> possibleMoves = new ArrayList<>();
			if (row == 1) {
				possibleMoves.add(Arrays.asList(row + 2, col));
			}
			if (row+1 < 8) possibleMoves.add(Arrays.asList(row + 1, col));
			if (row+1 < 8 && col-1 >= 0) possibleMoves.add(Arrays.asList(row+1, col-1));
			if (row+1 < 8 && col+1 < 8) possibleMoves.add(Arrays.asList(row+1, col+1));
			return possibleMoves;
		} else {
			List<List<Integer>> possibleMoves = new ArrayList<>();
			if (row == 6) {
				possibleMoves.add(Arrays.asList(row - 2, col));
			}
			if (row-1 >= 0) possibleMoves.add(Arrays.asList(row - 1, col));
			if (row-1 >= 0 && col-1 >= 0) possibleMoves.add(Arrays.asList(row-1, col-1));
			if (row-1 >= 0 && col+1 < 8) possibleMoves.add(Arrays.asList(row-1, col+1));
			return possibleMoves;
		}
	}
}
