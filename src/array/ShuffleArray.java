package array;

import java.util.Arrays;
import java.util.Random;

/**
 */
public class ShuffleArray {

	private static int[] createAndShuffle() {
		Random r = new Random();
		int[] deck = new int[52];
		for (int i = 0; i < 52; i++) {
			deck[i] = i % 13 + 1;
		}
		int lastPtr = 52;
		while (lastPtr > 0) {
			int swapIdx = r.nextInt(lastPtr);
			swap(deck, lastPtr-1, swapIdx);
			lastPtr -= 1;
		}

		return deck;
	}

	public static void swap(int[] input, int src, int dest) {
		int tmp = input[src];
		input[src] = input[dest];
		input[dest] = tmp;
	}

	public static void main(String...args) {
		System.out.println(Arrays.toString(createAndShuffle()));
	}
}
