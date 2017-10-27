package chess;

import java.util.ArrayList;
import java.util.List;

/**
 */
@SuppressWarnings("Duplicates")
public class Rook extends ChessPiece {
	public Rook(String color, List<Integer> currentCoordinate) {
		super(color, "R", currentCoordinate);
	}


	@Override
	List<List<Integer>> possibleMoves(ChessBoard board) {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleMoves = new ArrayList<>();
		boolean[] blockedR = {false};
		boolean[] blockedL = {false};
		boolean[] blockedU = {false};
		boolean[] blockedD = {false};
		for (int offset = 0; offset < 8; offset++) {
			if (row + offset < 8 && !blockedR[0]) addMoveAndBlocked(board, row+offset, col, blockedR, possibleMoves);
			if (row - offset >= 0 && !blockedL[0]) addMoveAndBlocked(board, row-offset, col, blockedL, possibleMoves);
			if (col + offset < 8 && !blockedD[0]) addMoveAndBlocked(board, row, col+offset, blockedD, possibleMoves);
			if (col - offset >= 0 && !blockedU[0]) addMoveAndBlocked(board, row, col-offset, blockedU, possibleMoves);
		}

		return possibleMoves;
	}
}
