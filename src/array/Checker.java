package array;

import java.util.Comparator;

/**
 * Created by liuben10 on 10/8/17.
 */
public class Checker implements Comparator<Checker.Player> {

	public static class Player {
		String name;
		int score;
	}

	@Override
	public int compare(Player p1, Player p2) {
		if (p1.score != p2.score) {
			return Integer.compare(p1.score, p2.score);
		} else {
			return p1.name.compareTo(p2.name);
		}
	}
}
