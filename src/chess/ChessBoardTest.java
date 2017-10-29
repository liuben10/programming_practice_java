package chess;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static chess.ChessBoard.BLACK;
import static chess.ChessBoard.WHITE;
import static chess.GameState.DECISIVE;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 */

public class ChessBoardTest {

	private ChessBoard chessBoard;

	@Before
	public void setup() {
		this.chessBoard = new ChessBoard();
		this.chessBoard.initializeEmptyBoard();
	}

	@Test
	public void canCheckMate() {

		King blackKing = new King(BLACK, Arrays.asList(0, 0));
		this.chessBoard.board[0][0].setChessPiece(blackKing);

		King whiteKing = new King(WHITE, Arrays.asList(2, 0));
		this.chessBoard.board[2][0].setChessPiece(whiteKing);

		Rook whiteRook = new Rook(WHITE, Arrays.asList(0, 7));
		this.chessBoard.board[0][7].setChessPiece(whiteRook);

		this.chessBoard.blackPieces = Arrays.asList(blackKing);

		this.chessBoard.whitePieces = Arrays.asList(whiteKing, whiteRook);

		this.chessBoard.blackKing = blackKing;

		this.chessBoard.whiteKing = whiteKing;

		assertThat(this.chessBoard.hasEnded(), equalTo(DECISIVE));
	}
}
