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

	List<ChessPiece> capturedWhite = new ArrayList<>();

	List<ChessPiece> capturedBlack = new ArrayList<>();

	List<ChessPiece> blackPieces = new ArrayList<>();

	ChessPiece whiteKing;

	ChessPiece blackKing;

	List<Move> moves;

	public Square[][] board;

	public ChessBoard() {
		board = new Square[8][8];
		moves = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Square();
			}
		}

		board[0][0].setChessPiece(new Rook(BLACK, Arrays.asList(0, 0)));
		board[0][1].setChessPiece(new Knight(BLACK, Arrays.asList(0, 1)));
		board[0][2].setChessPiece(new Bishop(BLACK, Arrays.asList(0, 2)));
		board[0][3].setChessPiece(new Queen(BLACK, Arrays.asList(0, 3)));
		board[0][4].setChessPiece(new King(BLACK, Arrays.asList(0, 4)));
		blackKing = board[0][4].getChessPiece();
		board[0][5].setChessPiece(new Bishop(BLACK, Arrays.asList(0, 5)));
		board[0][6].setChessPiece(new Knight(BLACK, Arrays.asList(0, 6)));
		board[0][7].setChessPiece(new Rook(BLACK, Arrays.asList(0, 7)));
		for (int i = 0; i < 8; i++) {
			board[1][i].setChessPiece(new Pawn(BLACK, Arrays.asList(1, i)));
		}

		for (int i = 0; i < 8; i++) {
			board[6][i].setChessPiece(new Pawn(WHITE, Arrays.asList(6, i)));
		}

		board[7][0].setChessPiece(new Rook(WHITE, Arrays.asList(7, 0)));
		board[7][1].setChessPiece(new Knight(WHITE, Arrays.asList(7, 1)));
		board[7][2].setChessPiece(new Bishop(WHITE, Arrays.asList(7, 2)));
		board[7][3].setChessPiece(new Queen(WHITE, Arrays.asList(7, 3)));
		board[7][4].setChessPiece(new King(WHITE, Arrays.asList(7, 4)));
		whiteKing = board[7][4].getChessPiece();
		board[7][5].setChessPiece(new Bishop(WHITE, Arrays.asList(7, 5)));
		board[7][6].setChessPiece(new Knight(WHITE, Arrays.asList(7, 6)));
		board[7][7].setChessPiece(new Rook(WHITE, Arrays.asList(7, 7)));

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				blackPieces.add(board[i][j].getChessPiece());
			}
		}

		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				whitePieces.add( board[i][j].getChessPiece());
			}
		}
	}

	public Square[][] getBoard() {
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
			if (checkMate(BLACK) || checkMate(WHITE)) {
				return GameState.DECISIVE;
			} else {
				return GameState.ONGOING;
			}
		}
	}

	public void move(String color, List<Integer> src, List<Integer> dest) {
		if (color.equals(WHITE)) {
			for (ChessPiece whitePiece : whitePieces) {
				if (whitePiece.currentCoordinate.equals(src)) {
					move(whitePiece, dest);
					break;
				}
			}
		} else {
			for (ChessPiece blackPiece : blackPieces) {
				if (blackPiece.currentCoordinate.equals(src)) {
					move(blackPiece, dest);
					break;
				}
			}
		}
	}

	public void move(ChessPiece chessPiece, List<Integer> coordinate) {
		if (!chessPiece.possibleMoves(this).contains(coordinate)) {
			throw new IllegalArgumentException("Illegal Move");
		}
		Integer row = coordinate.get(0);
		Integer col = coordinate.get(1);
		Move.MoveBuilder moveToMake = Move.builder().piece(chessPiece).src(chessPiece.currentCoordinate).dest(coordinate);
		this.board[chessPiece.currentCoordinate.get(0)][chessPiece.currentCoordinate.get(1)].removeChessPiece();
		if (!this.board[row][col].isEmpty()) {
			ChessPiece captured = this.board[row][col].getChessPiece();
			String color = captured.getColor();
			if (color.equals(WHITE)) {
				capturedWhite.add(captured);
			} else {
				capturedBlack.add(captured);
			}
			moves.add(moveToMake.captured(captured).build());
		} else {
			this.board[row][col].setChessPiece(chessPiece);
			moves.add(moveToMake.build());
		}
		chessPiece.currentCoordinate.set(0, row);
		chessPiece.currentCoordinate.set(1, col);
	}

	private boolean checkMate(String color) {
		if (color.equals(WHITE)) {
			if (inCheck(WHITE, whiteKing.currentCoordinate) && allMovesAreInCheck(WHITE)) {
				return true;
			}
			return false;
		} else {
			if (inCheck(BLACK, blackKing.currentCoordinate) && allMovesAreInCheck(BLACK)) {
				return true;
			}
			return false;
		}
	}

	private boolean allMovesAreInCheck(String color) {
		if (color.equals(WHITE)) {
			for (List<Integer> moves : whiteKing.possibleMoves(this)) {
				if (!inCheck(WHITE, moves)) {
					return false;
				}
			}
			return true;
		} else {
			for (List<Integer> moves : blackKing.possibleMoves(this)) {
				if (!inCheck(BLACK, moves)) {
					return false;
				}
			}
			return true;
		}
	}


	public boolean inCheck(String color, List<Integer> coordinate) {
		if (color.equals(WHITE)) {
			for (ChessPiece blackPiece : blackPieces) {
				if (blackPiece.possibleMoves(this).contains(coordinate)) {
					return true;
				}
			}
			return false;
		} else {
			for (ChessPiece whitePiece : whitePieces) {
				if (whitePiece.possibleMoves(this).contains(coordinate)) {
					return true;
				}
			}
			return false;
		}
	}

	private boolean hasNoLegalMoves(String color) {

		if (color.equals(WHITE)) {
			for (ChessPiece whitePiece : whitePieces) {
				if (!whitePiece.possibleMoves(this).isEmpty()) {
					return false;
				}
			}
			return true;
		} else {
			for (ChessPiece blackPiece : blackPieces) {
				if (!blackPiece.possibleMoves(this).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String...args) {
		ChessBoard chessBoard = new ChessBoard();
		System.out.println(chessBoard.boardToString());
		printLegalMoves(chessBoard);

		System.out.println(chessBoard.checkMate(WHITE));
		System.out.println(chessBoard.checkMate(BLACK));

		chessBoard.move(WHITE, Arrays.asList(6, 3), Arrays.asList(4, 3));
		System.out.println(chessBoard.boardToString());

		chessBoard.move(BLACK, Arrays.asList(1, 3), Arrays.asList(3, 3));
		System.out.println(chessBoard.boardToString());

		chessBoard.move(WHITE, Arrays.asList(7, 1), Arrays.asList(5, 2));
		System.out.println(chessBoard.boardToString());

		printLegalMoves(chessBoard);

	}

	private static void printLegalMoves(ChessBoard chessBoard) {
		for (ChessPiece whitePiece : chessBoard.whitePieces) {
			System.out.println(whitePiece.toString() + ", " + whitePiece.possibleMoves(chessBoard));
		}

		System.out.println("====");

		for (ChessPiece whitePiece : chessBoard.blackPieces) {
			System.out.println(whitePiece.toString() + ", " + whitePiece.possibleMoves(chessBoard));
		}
	}
}
