package string;

/**
 */
public class Main {


	public static int kadanes(int[] seq) {

		int curMax = 0;
		int max = 0;
		for (int i = 0; i < seq.length; i++) {
			curMax = Math.max(seq[i], curMax + seq[i]);
			max = Math.max(max, curMax);
		}
		return max;
	}

	public static void main(String...args) {
		System.out.println(kadanes(new int[]{5, 2, -1, 3}));
	}

}
