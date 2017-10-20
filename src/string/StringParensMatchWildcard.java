package string;

import java.util.Stack;

/**
 */
public class StringParensMatchWildcard {

	public static boolean parensMatchesHelp(String input) {
		char[] inputChars = input.toCharArray();

		Stack<Character> open = new Stack<>();
		Stack<Character> wilds = new Stack<>();
		for(int i = 0; i < inputChars.length; i++) {
			char cur = inputChars[i];
			if (cur == '(') {
				open.push(cur);
			} else if (cur == ')') {
				if (!open.isEmpty()) {
					open.pop();
				} else if (!wilds.isEmpty()) {
					wilds.pop();
				} else {
					return false;
				}
			} else {
				wilds.push(cur);
			}
		}
		return true;
	}

	public static boolean parensMatch(String input) {
		boolean forward = parensMatchesHelp(input);
		StringBuilder reversed = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--) {
			char c = input.charAt(i);
			if (c == '(') {
				reversed.append(')');
			} else if (c == ')') {
				reversed.append('(');
			} else {
				reversed.append(c);
			}
		}
		boolean backwards = parensMatchesHelp(reversed.toString());
		return forward && backwards;
	}

	public static void main(String...args) {
		System.out.println(parensMatch("(((()())()))())"));
	}
}
