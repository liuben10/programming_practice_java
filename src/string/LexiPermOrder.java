package string;

import java.util.Arrays;

/**
 */
public class LexiPermOrder {

	public static int lexiOrder(String input) {
		return lexiOrderHelp(input) + 1;
	}

	public static int lexiOrderHelp(String input) {
		if (input.length() == 0) {
			return 0;
		}
		char[] chars = input.toCharArray();
		char first = chars[0];
		Arrays.sort(chars);

		int before = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == first) {
				before = i;
				break;
			}
		}

		int amountBefore = factorial(input.length() - 1) * before;
		return amountBefore + lexiOrderHelp(input.substring(1));
	}

	public static int factorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String...args) {
		int lexiOrder = lexiOrder("bac");
		System.out.println(lexiOrder);
	}
}
