package chess;

/**
 */
public enum GameState {
	DECISIVE,
	DRAW,
	ONGOING {
		@Override
		public boolean ongoing() {
			return true;
		}
	};

	public boolean ongoing() {
		return false;
	}
}
