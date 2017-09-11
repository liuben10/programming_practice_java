package string;

import java.util.Arrays;

/**
 * Created by liuben10 on 8/6/17.
 */
public class ReplaceSpaceNew {

	public static String replaceAllSpaces(final String str, final String toRepl) {
		int replaceCount = 0;
		System.out.println(str.length());
		for (int i = 0; i < str.toCharArray().length; i++) {
			if (str.charAt(i) == ' ') {
				replaceCount += 1;
			}
		}

		char[] replaced = new char[str.length() + (replaceCount * (toRepl.length() - 1))];

		int j = str.length() - 1;
		int i = replaced.length - 1;
		int consumed = toRepl.length() - 1;
		while(i >= 0 && j >= 0) {
			if (str.charAt(j) != ' ') {
				replaced[i] = str.charAt(j);
				i--;
				j--;
			} else if (consumed >= 0) {
				replaced[i] = toRepl.charAt(consumed);
				consumed -= 1;
				i--;
			} else if (consumed < 0) {
				consumed = toRepl.length()-1;
				j--;
			}
		}
		return new String(replaced);
	}

	public static void main(String...args) {
		System.out.println(replaceAllSpaces("The sun was shining today.", "%20"));
	}
}
