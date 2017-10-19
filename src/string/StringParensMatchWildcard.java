package string;

import java.util.Stack;

/**
 */
public class StringParensMatchWildcard {

	public static boolean parensMatches(String input) {
		Stack<Character> charsToMatch = new Stack<>();

		char[] inputChars = input.toCharArray();
		for(int i = 0; i < inputChars.length; i++) {
			char current = inputChars[i];

			if (current == '(') {
				charsToMatch.push(current);
			} else if (current == ')') {
				if (charsToMatch.isEmpty()) {
					return false;
				}
				char matching = charsToMatch.peek();
				if (matching == '(' || matching == '*') {
					charsToMatch.pop();
				}
			} else if (current == '*') {
//				if (charsToMatch.isEmpty()) {
//					charsToMatch.push(current);
//				} else {
//					char curr = charsToMatch.peek();
//
//					if (curr == '(') {
//						charsToM
//					}
//				}
			} //TODO finish me
			return false;
		}
		return false;

	}


	public static void main(String...args) {

	}
}
