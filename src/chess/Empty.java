package chess;

/**
 */
public class Empty implements ChessPiece {

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public String toString() {
		return "-  ";
	}
}
