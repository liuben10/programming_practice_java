package string;

public class RegularExpressionMatching {
	
	public static void main(String...args) {
		System.out.println(matches("abcd", "a*d"));
	}
	
	public static boolean matches(String word, String pattern) {
		if (word == null || pattern == null) {
			return false;
		} else {
			return matchesCore(word, pattern);
		}
	}
	
	public static boolean matchesCore(String word, String pattern) {
		if (word.equals(pattern)) {
			return true;
		}
		if (pattern.charAt(0) == '*') {
			int cnt = 0;
			if (pattern.length() == 1) {
				return true;
			}
			char nextChar = pattern.charAt(1);
			while (word.charAt(cnt) != nextChar) {
				cnt++;
			}
			return matchesCore(word.substring(cnt), pattern.substring(1));
		}
		if (pattern.charAt(0) == '.') {
			if (word.length() == 1) {
				return true;
			} else {
				return matchesCore(word.substring(1), pattern.substring(1));
			}
		}
		if (pattern.charAt(0) == word.charAt(0)) {
			return matchesCore(word.substring(1), pattern.substring(1));
		} else {
			return false;
		}
	}

}
