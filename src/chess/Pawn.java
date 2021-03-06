package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.ChessBoard.BLACK;

/**
 */
public class Pawn  extends ChessPiece  {
	public Pawn(String color, List<Integer> currentCoordinate) {
		super(color, "P", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves(ChessBoard board) {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		if (color.equals(BLACK)) {
			List<List<Integer>> possibleMoves = new ArrayList<>();
			if (row == 1) {
				if (board.getBoard()[row+1][col].isEmpty()) possibleMoves.add(Arrays.asList(row + 2, col));
			}
			if (row+1 < 8 && board.getBoard()[row+1][col].isEmpty()) possibleMoves.add(Arrays.asList(row + 1, col));
			if (row+1 < 8 && col-1 >= 0 && !board.getBoard()[row+1][col-1].isEmpty() && !board.getBoard()[row+1][col-1].getChessPiece().getColor().equals(getColor())) possibleMoves.add(Arrays.asList(row+1, col-1));
			if (row+1 < 8 && col+1 < 8 && !board.getBoard()[row+1][col+1].isEmpty() && !board.getBoard()[row+1][col+1].getChessPiece().getColor().equals(getColor())) possibleMoves.add(Arrays.asList(row+1, col+1));
			return possibleMoves;
		} else {
			List<List<Integer>> possibleMoves = new ArrayList<>();
			if (row == 6) {
				if (board.getBoard()[row-1][col].isEmpty()) possibleMoves.add(Arrays.asList(row - 2, col));
			}
			if (row-1 >= 0 && board.getBoard()[row-1][col].isEmpty()) possibleMoves.add(Arrays.asList(row - 1, col));
			if (row-1 >= 0 && col-1 >= 0 && !board.getBoard()[row-1][col-1].isEmpty() && !board.getBoard()[row-1][col-1].getChessPiece().getColor().equals(getColor())) possibleMoves.add(Arrays.asList(row-1, col-1));
			if (row-1 >= 0 && col+1 < 8 && !board.getBoard()[row-1][col+1].isEmpty() && !board.getBoard()[row-1][col+1].getChessPiece().getColor().equals(getColor())) possibleMoves.add(Arrays.asList(row-1, col+1));
			return possibleMoves;
		}
	}
}
