package chess;

import java.util.ArrayList;
import java.util.List;

import static chess.ChessBoard.WHITE;

/**
 */
public class King extends ChessPiece  {
	public King(String color, List<Integer> currentCoordinate) {
		super(color, "K", currentCoordinate);
	}

	@Override
	public List<List<Integer>> possibleMoves(ChessBoard board) {
		int row = currentCoordinate.get(0);
		int col = currentCoordinate.get(1);

		List<List<Integer>> possibleMoves = new ArrayList<>();
		boolean[] blockedTL = {false};
		boolean[] blockedTR = {false};
		boolean[] blockedBR = {false};
		boolean[] blockedBL = {false};
		boolean[] blockedR = {false};
		boolean[] blockedL = {false};
		boolean[] blockedU = {false};
		boolean[] blockedD = {false};
		if (row + 1 < 8) addMoveAndBlocked(board, row+1, col, blockedD, possibleMoves);
		if (row + 1 < 8 && col + 1 < 8) addMoveAndBlocked(board, row+1, col+1, blockedBR, possibleMoves);
		if (row+1 < 8 && col - 1 >= 0) addMoveAndBlocked(board, row+1, col-1, blockedBL, possibleMoves);
		if (row - 1 >= 0) addMoveAndBlocked(board, row-1, col, blockedU, possibleMoves);
		if (row - 1 >= 0 && col + 1 < 8) addMoveAndBlocked(board, row-1, col+1, blockedTR, possibleMoves);
		if (row - 1 >= 0 && col -1 >= 0) addMoveAndBlocked(board, row-1, col-1, blockedTL, possibleMoves);
		if (col+1 < 8) addMoveAndBlocked(board, row, col+1, blockedR, possibleMoves);
		if (col-1 >= 0) addMoveAndBlocked(board, row, col-1, blockedL, possibleMoves);

		return possibleMoves;
	}

	public List<List<Integer>> movesNotInCheck(final ChessBoard board) {
		List<List<Integer>> possibleMovesNotInCheck = possibleMoves(board);
		List<List<Integer>> movesNotInCheck = new ArrayList<>();

		possibleMovesNotInCheck.forEach((move) -> {
			if (getColor().equals(WHITE)) {
				for (ChessPiece blackPiece : board.blackPieces) {
					if (!blackPiece.possibleMoves(board).contains(move)) {
						return;
					}
				}
				movesNotInCheck.add(move);
			} else {
				for (ChessPiece whitePiece : board.whitePieces) {
					if (whitePiece.possibleMoves(board).contains(move)) {
						return;
					}
				}
				movesNotInCheck.add(move);
			}
		});
		return movesNotInCheck;
	}


}
