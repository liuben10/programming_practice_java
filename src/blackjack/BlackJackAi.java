package blackjack;

public class BlackJackAi {
	
	private BlackJack bj;
	private BjStrategy blackJackStrategy;
	private int wallet;
	
	BlackJackAi( BjStrategy blackJackStrategy, int wallet) {
		this.blackJackStrategy = blackJackStrategy;
		this.setWallet(wallet);
	}
	
	public void playAction() {
		if (hit()) {
			getBj().hit();
		}
	}
	
	
	public boolean shouldPlay() {
		return wallet >= 500;
	}
	
	private boolean hit() {
		return blackJackStrategy.playAction();
	}

	public BjStrategy getBlackJackStrategy() {
		return blackJackStrategy;
	}

	public void setBlackJackStrategy(BjStrategy blackJackStrategy) {
		this.blackJackStrategy = blackJackStrategy;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public BlackJack getBj() {
		return bj;
	}

	public void setBj(BlackJack bj) {
		this.bj = bj;
	}

}
