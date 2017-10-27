package chess;

/**
 */
public class Square {

	public static String EMPTY = "-  ";

	public ChessPiece getChessPiece() {
		return chessPiece;
	}

	public void setChessPiece(ChessPiece chessPiece) {
		this.chessPiece = chessPiece;
	}

	public boolean isEmpty() {
		return this.chessPiece == null;
	}

	private ChessPiece chessPiece;

	@Override
	public String toString() {
		if (chessPiece != null) {
			return chessPiece.toString();
		}

		return "-  ";
	}
}
