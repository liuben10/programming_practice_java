package chess;

import java.util.Arrays;
import java.util.List;

import static chess.ChessBoard.EMPTY;

/**
 */
public abstract class AbstractColoredChessPiece implements ChessPiece {

	protected final String color;

	private final String name;

	protected final List<Integer> currentCoordinate;

	public AbstractColoredChessPiece(String color, String name, List<Integer> currentCoordinate) {
		this.color = color;
		this.name = name;
		this.currentCoordinate = currentCoordinate;
	}

	public String getName() {
		return this.name;
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public String toString() {
		return this.name + "-" + this.color;
	}

	abstract List<List<Integer>> possibleMoves(ChessBoard chessBoard);

	public void addMoveAndBlocked(ChessBoard board, int row, int col, boolean[] blocked, List<List<Integer>> possibleMoves) {
		ChessPiece piece = board.getBoard()[row][col];
		if (piece != EMPTY) {
			blocked[0] = true;
			if (!piece.getColor().equals(getColor())) {
				possibleMoves.add(Arrays.asList(row, col));
			}
		} else {
			possibleMoves.add(Arrays.asList(row, col));
		}
	}
}
