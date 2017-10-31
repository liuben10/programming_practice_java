package bits;

/**
 */
public class PrintDigits {


	static void printChars(String input) {

		int n = (int) (Math.pow(2, input.length()) - 1);
		int cnt = 0;
		while (n > 0) {
			if ((n & 1) > 0) {
				System.out.println(input.charAt(cnt));
			}
			n = n >> 1;
			cnt += 1;
		}
	}

	public static void main(String...args) {
		printChars("ASDF");
	}
}
