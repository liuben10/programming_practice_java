package blackjack;

import java.util.*;
/**
 */
public class BlackJackMain {

	static class BlackJackGame {

		private final Payouts payouts;
		boolean ended;

		Integer pool;

		Scanner s;

		public BlackJackGame(Payouts payouts, Integer initialPool, Scanner s) {
			ended = false;
			this.pool = initialPool;
			this.s = s;
			this.payouts = payouts;
		}


		public void playGame() {
			while (!ended) {
				int winning = playRound();
				this.pool += winning;

				System.out.println("Won: " + winning + ", current pool=" + this.pool);
				System.out.println("Would you like to continue playing? (Y/n)");
				String contGame = s.next();
				if (!contGame.equalsIgnoreCase("Y")) {
					ended = true;
				}
			}
			System.out.println("Current balance: " + this.pool);
			System.out.println("Have a nice day");
		}

		public int playRound() {
			BlackJackRound blackJackRound = new BlackJackRound();

			while(!blackJackRound.isOver()) {
				System.out.println("Enter h for hit, f for fold");
				String command = s.next();
				if (command.equals("h")) {
					blackJackRound.hit();
					System.out.println(blackJackRound.getScoreSoFar());
				} else {
					blackJackRound.fold();
				}
			}

			return payouts.getPayout(blackJackRound.getScoreSoFar());
		}
	}

	static class BlackJackRound {

		List<Integer> deck;

		int scoreSoFar = 0;
		private boolean folded;

		public BlackJackRound() {
			deck = new ArrayList<>();
			for(int i = 0; i < 52; i++) {
				deck.add(i % 13 + 1);
			}

			Collections.shuffle(deck);

			folded = false;
		}

		public int getScoreSoFar() {
			return scoreSoFar;
		}

		public void setScoreSoFar(int scoreSoFar) {
			this.scoreSoFar = scoreSoFar;
		}

		public void hit() {
			int card = deck.remove(0);
			scoreSoFar += card;
		}

		public boolean isOver() {
			if (scoreSoFar == 21) {
				System.out.println("Blackjack!");
			}
			return scoreSoFar >= 21 || folded;
		}

		public void fold() {
			folded = true;
		}
	}

	static class Payouts {

		private final Map<Integer, Integer> payouts;
		private final Integer below;
		private final Integer above;
		private final Integer maxSetPayout;
		private final Integer minSetPayout;

		public Payouts(Map<Integer, Integer> payouts, Integer below, Integer above) {
			this.payouts = payouts;
			this.below = below;
			this.above = above;
			this.maxSetPayout = Collections.max(payouts.keySet());
			this.minSetPayout = Collections.min(payouts.keySet());
		}

		public int getPayout(int value) {
			if (value < minSetPayout) {
				return this.below;
			} else if (value > maxSetPayout) {
				return this.above;
			} else {
				return payouts.get(value);
			}
		}
	}

	public static void main(String...args) {
		Map<Integer, Integer> payoutsTable = new HashMap<>();
		payoutsTable.put(17, 50);
		payoutsTable.put(18, 100);
		payoutsTable.put(19, 150);
		payoutsTable.put(20, 200);
		payoutsTable.put(21, 400);
		payoutsTable.put(22, -50);
		payoutsTable.put(23, -100);
		payoutsTable.put(24, -150);
		payoutsTable.put(25, -200);

		Payouts payouts = new Payouts(payoutsTable, 0, 0);

		BlackJackGame game = new BlackJackGame(payouts, 100, new Scanner(System.in));

		game.playGame();
	}
}
