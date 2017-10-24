package array;

/**
 */
public class SimpleWarmupStuff {

	public static int sumArray(int[] input) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		return sum;
	}



	public static void main(String...args) {
		System.out.println(sumArray(new int[]{3, 4, 5}));
	}
}
