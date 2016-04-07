package blackjack;

import java.util.HashMap;
import java.util.Map;

public class BlackJackRunner {
	
	public static void main(String...args) {
		Map<Integer, Integer> winnings = new HashMap<Integer, Integer>();
		winnings.put(17,  200);
		winnings.put(18, 300);
		winnings.put(19, 500);
		winnings.put(20, 800);
		winnings.put(21, 1100);
		int entry = 500;
		BjStrategy simpleStrategy = new BjStrategy() {
			@Override
			public boolean playAction() {
				return true;
			}
		};
		BlackJackAi bjAi = new BlackJackAi(simpleStrategy, 500);
		while(bjAi.shouldPlay()) {
			BlackJack bj = new BlackJack(21, winnings, entry);
			bjAi.setBj(bj);
			while (!bj.isOver()) {
				bjAi.playAction();
			}
			bjAi.setWallet(bjAi.getWallet() + bj.computeWinnings());
			System.out.println("bjAi wallet={" + bjAi.getWallet() + "}");
		}
		
	}

}
