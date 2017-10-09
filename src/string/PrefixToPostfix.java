package string;

import java.util.Stack;

/**
 * Created by liuben10 on 10/9/17.
 */
public class PrefixToPostfix {

	static String prefix = "-*+ABC*-DE+FG";

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		String o1 = null;
		String o2 = null;

		char[] prefixArry = prefix.toCharArray();

		for (int i = prefixArry.length - 1; i >= 0; i--) {
			if (isOperator(prefixArry[i])) {
				o1 = s.pop();
				o2 = s.pop();
				s.push(o1 + o2 + prefixArry[i]);
			} else {
				s.push("" + prefixArry[i]);
			}
		}

		StringBuilder b = new StringBuilder();
		while (!s.isEmpty()) {
			b.append(s.pop());
		}
		System.out.println(b);
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*';
	}
}
