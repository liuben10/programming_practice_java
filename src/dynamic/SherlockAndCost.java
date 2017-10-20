package dynamic;

/**
 */
public class SherlockAndCost {

	static int findMax(int[] input) {
		int hi = 0;
		int low = 0;
		for(int i = 1; i < input.length; i++) {
			int lowDiff = Math.abs(input[i-1] - 1);
			int highDiff = Math.abs(input[i] - 1);
			int highToHigh = Math.abs(input[i] - input[i-1]);

			int low_next = Math.max(low, hi+lowDiff);
			int hi_next = Math.max(low + highDiff, hi + highToHigh);

			low = low_next;
			hi = hi_next;
		}

		return Math.max(hi, low);
	}

	public static void main(String...args) {
		System.out.println(findMax(new int[]{100, 2, 100, 2, 100}));
	}
}
