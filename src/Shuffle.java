import java.util.ArrayList;
import java.util.Random;

/**
 * Created by liuben10 on 8/15/17.
 */
public class Shuffle {


	public static void main(String...arg) {
		Random random = new Random();
		ArrayList<Integer> deck = new ArrayList<>();

		ArrayList<Integer> shuffled = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			deck.add(i);
		}

		while(!deck.isEmpty()) {
			int index = random.nextInt(deck.size());
			shuffled.add(deck.remove(index));
		}

		System.out.println(shuffled);
	}
}
