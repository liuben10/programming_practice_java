package chess;

import java.util.List;

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
}
