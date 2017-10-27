package chess;

import lombok.Builder;

import java.util.List;

/**
 */
@Builder
public class Move {

	ChessPiece piece;

	List<Integer> src;

	List<Integer> dest;

	ChessPiece captured;
}
