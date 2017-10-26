package chess;

import java.util.ArrayList;
import java.util.List;

/**
 */
@SuppressWarnings("Duplicates")
public class Queen extends AbstractColoredChessPiece {
	public Queen(String color, List<Integer> currentCoordinate) {
		super(color, "Q", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves(ChessBoard chessBoard) {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleMoves = new ArrayList<>();
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

		boolean[] blockedR = {false};
		boolean[] blockedL = {false};
		boolean[] blockedU = {false};
		boolean[] blockedD = {false};
		for (int offset = 0; offset < 8; offset++) {
			if (row + offset < 8 && !blockedR[0]) addMoveAndBlocked(chessBoard, row+offset, col, blockedR, possibleMoves);
			if (row - offset >= 0 && !blockedL[0]) addMoveAndBlocked(chessBoard, row-offset, col, blockedL, possibleMoves);
			if (col + offset < 8 && !blockedD[0]) addMoveAndBlocked(chessBoard, row, col+offset, blockedD, possibleMoves);
			if (col - offset >= 0 && !blockedU[0]) addMoveAndBlocked(chessBoard, row, col-offset, blockedU, possibleMoves);
		}

		return possibleMoves;
	}
}
