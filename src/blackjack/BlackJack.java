package blackjack;

import java.util.Map;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class BlackJack {
	
	private int goal;
	private Map<Integer, Integer> winnings;
	private int entry;
	private int scoreSoFar;
	Random dealer;
	private List<Integer> cards;
	private boolean stand;
	BlackJack(int goal, Map<Integer, Integer> winnings, int entry) {
		this.goal = goal;
		this.winnings = winnings;
		this.setScoreSoFar(0);
		this.stand = false;
		dealer = new Random();
		this.setEntry(-entry);
		cards = new LinkedList<Integer>();
		for(int i = 0; i < 52; i++) {
			cards.add(i % 13 + 1);
		}
	}
	
	public int computeWinnings() {
		if (getScoreSoFar() <= goal) {
			if (winnings.containsKey(getScoreSoFar())) {
				return entry + winnings.get(getScoreSoFar());
			}
		}
		return entry;
	}
	
	public boolean isOver() {
		if (getScoreSoFar() > goal) {
			System.out.println("Bust = {" + getScoreSoFar() + "}, Goal = {" + goal + "}");
		}
		if (getScoreSoFar() == goal) {
			System.out.println("BlackJack!");
		}
		if (isStand()) {
			System.out.println("Game Over, score={" + getScoreSoFar() + "}");
		}
		return getScoreSoFar() >= goal || isStand();
	}
	
	public int getCard() {
		return cards.remove(dealer.nextInt(cards.size()));
	}
	
	public void hit() {
		int card = getCard();
		System.out.println("Card=" + card);
		setScoreSoFar(getScoreSoFar() + card);
	}

	public int getScoreSoFar() {
		return scoreSoFar;
	}

	public void setScoreSoFar(int scoreSoFar) {
		this.scoreSoFar = scoreSoFar;
	}

	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}

	private boolean isStand() {
		return stand;
	}

	public void stand() {
		this.stand = true;
	}
	
	
	
	
}
