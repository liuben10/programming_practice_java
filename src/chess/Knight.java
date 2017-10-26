package chess;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Knight extends AbstractColoredChessPiece {

	public Knight(String color, List<Integer> currentCoordinate) {
		super(color, "N", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves(ChessBoard chessBoard) {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleMoves = new ArrayList<>();
		boolean[] useless = new boolean[1];

		if (row-2 >= 0 && col+1 < 8) addMoveAndBlocked(chessBoard, row-2, col+1, useless, possibleMoves);
		if (row-2 >= 0 && col-1 >= 0) addMoveAndBlocked(chessBoard, row-2, col-1, useless, possibleMoves);
		if (row-1 >= 0 && col+2 < 8) addMoveAndBlocked(chessBoard, row-1, col+2, useless, possibleMoves);
		if (row-1 >= 0 && col-2 >= 0) addMoveAndBlocked(chessBoard, row-1, col-2, useless, possibleMoves);
		if (row+1 < 8 && col-2 >= 0) addMoveAndBlocked(chessBoard, row+1, col-2, useless, possibleMoves);
		if (row+1 < 8 && col+2 < 8) addMoveAndBlocked(chessBoard, row+1, col+2, useless, possibleMoves);
		if (row+2 < 8 && col+1 < 8) addMoveAndBlocked(chessBoard, row+2, col+1, useless, possibleMoves);
		if (row+2 < 8 && col-1 >= 0) addMoveAndBlocked(chessBoard, row+2, col-1, useless, possibleMoves);

		return possibleMoves;
	}
}
