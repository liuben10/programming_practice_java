package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class ChessBoard {

	public static String BLACK = "B";

	public static String WHITE = "W";

	List<ChessPiece> whitePieces = new ArrayList<>();

	List<ChessPiece> blackPieces = new ArrayList<>();

	public static ChessPiece EMPTY = new Empty();

	public ChessPiece[][] board;

	public ChessBoard() {
		board = new ChessPiece[8][8];

		board[0][0] = new Rook(BLACK, Arrays.asList(0, 0));
		board[0][1] = new Knight(BLACK, Arrays.asList(0, 1));
		board[0][2] = new Bishop(BLACK, Arrays.asList(0, 2));
		board[0][3] = new Queen(BLACK, Arrays.asList(0, 3));
		board[0][4] = new King(BLACK, Arrays.asList(0, 4));
		board[0][5] = new Bishop(BLACK, Arrays.asList(0, 5));
		board[0][6] = new Knight(BLACK, Arrays.asList(0, 6));
		board[0][7] = new Rook(BLACK, Arrays.asList(0, 7));
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(BLACK, Arrays.asList(1, i));
		}

		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(WHITE, Arrays.asList(6, i));
		}

		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = EMPTY;
			}
		}

		board[7][0] = new Rook(WHITE, Arrays.asList(7, 0));
		board[7][1] = new Knight(WHITE, Arrays.asList(7, 1));
		board[7][2] = new Bishop(WHITE, Arrays.asList(7, 2));
		board[7][3] = new Queen(WHITE, Arrays.asList(7, 3));
		board[7][4] = new King(WHITE, Arrays.asList(7, 4));
		board[7][5] = new Bishop(WHITE, Arrays.asList(7, 5));
		board[7][6] = new Knight(WHITE, Arrays.asList(7, 6));
		board[7][7] = new Rook(WHITE, Arrays.asList(7, 7));

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				blackPieces.add(board[i][j]);
			}
		}

		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				whitePieces.add(board[i][j]);
			}
		}
	}

	public ChessPiece[][] getBoard() {
		return board;
	}

	public String boardToString() {
		StringBuilder boardDisplay = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			StringBuilder boardLine = new StringBuilder();
			for (int j = 0; j < 8; j++) {
				boardLine.append(board[i][j].toString()).append(" ");
			}
			boardDisplay.append(boardLine).append("\n");
		}
		return boardDisplay.toString();
	}

	public GameState hasEnded() {
		if (hasNoLegalMoves(BLACK) || hasNoLegalMoves(WHITE)) {
			return GameState.DRAW;
		} else {
			return GameState.DECISIVE; //TODO change.
		}
	}

	private boolean hasNoLegalMoves(String color) {
		return false;
	}

	public static void main(String...args) {
		ChessBoard chessBoard = new ChessBoard();
		System.out.println(chessBoard.boardToString());
	}
}
