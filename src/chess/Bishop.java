package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.ChessBoard.EMPTY;

/**
 */
public class Bishop  extends AbstractColoredChessPiece  {

	public Bishop(String color, List<Integer> currentCoordinate) {
		super(color, "B", currentCoordinate);
	}

	@Override
	List<List<Integer>> possibleMoves(ChessBoard chessBoard) {
		List<List<Integer>> possibleMoves = new ArrayList<>();

		Integer row = currentCoordinate.get(0);
		Integer col = currentCoordinate.get(1);
		boolean blockedTL = false;
		boolean blockedTR = false;
		boolean blockedBR = false;
		boolean blockedBL = false;
		for (int offset = 1; row + offset < 8 && col + offset < 8; offset++) {

			if (row + offset < 8 && col + offset < 8 && !blockedTL) {
				blockedTL = determineIfPieceBlocked(chessBoard.getBoard()[row + offset][col + offset], possibleMoves, row + offset, col + offset, blockedTL);
			}
			if (row - offset >= 0 && col + offset < 8 && !blockedTR) possibleMoves.add(Arrays.asList(row - offset, col + offset));
			if (row + offset < 8 && col - offset >= 0 && !blockedBR) possibleMoves.add(Arrays.asList(row + offset, col - offset));
			if (row - offset >= 0 && col - offset >= 0 && !blockedBL) possibleMoves.add(Arrays.asList(row - offset, col - offset));
		}

		return possibleMoves;
	}

	private boolean determineIfPieceBlocked(ChessPiece chessPiece1, List<List<Integer>> possibleMoves, int row, int col, boolean blockedTL) {
		ChessPiece chessPiece = chessPiece1;
		if (chessPiece != EMPTY) {
			blockedTL = true;
			if (!chessPiece.getColor().equals(getColor())) {
				possibleMoves.add(Arrays.asList(row, col));
			}
		} else {
			possibleMoves.add(Arrays.asList(row, col));
		}
		return blockedTL;
	}
}
