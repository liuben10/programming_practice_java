package chess;

import java.util.ArrayList;
import java.util.List;

/**
 */
@SuppressWarnings("Duplicates")
public class Bishop  extends AbstractColoredChessPiece  {

	public Bishop(String color, List<Integer> currentCoordinate) {
		super(color, "B", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves(ChessBoard chessBoard) {
		List<List<Integer>> possibleMoves = new ArrayList<>();

		Integer row = currentCoordinate.get(0);
		Integer col = currentCoordinate.get(1);
		boolean[] blockedTL = {false};
		boolean[] blockedTR = {false};
		boolean[] blockedBR = {false};
		boolean[] blockedBL = {false};
		for (int offset = 1; row + offset < 8 && col + offset < 8; offset++) {
			if (row + offset < 8 && col + offset < 8 && !blockedTL[0]) addMoveAndBlocked(chessBoard, row+offset, col+offset, blockedTL,  possibleMoves);
			if (row - offset >= 0 && col + offset < 8 && !blockedTR[0]) addMoveAndBlocked(chessBoard, row-offset, col+offset, blockedTR, possibleMoves);
			if (row + offset < 8 && col - offset >= 0 && !blockedBR[0]) addMoveAndBlocked(chessBoard, row+offset, col-offset, blockedBR, possibleMoves);
			if (row - offset >= 0 && col - offset >= 0 && !blockedBL[0]) addMoveAndBlocked(chessBoard, row-offset, col-offset, blockedBL, possibleMoves);
		}

		return possibleMoves;
	}



}
