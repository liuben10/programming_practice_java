package string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Combination {

	public static Set<String> combinations(String input) {
		int n = (int)Math.pow(2, input.length())-1;
		Set<String> results = new HashSet<>();
		while(n >= 0) {
			String binString = Integer.toBinaryString(n);
			StringBuilder combo = new StringBuilder();
			binString = StringUtils.leftPad(binString, input.length(), "0");
			System.out.println(binString);

			for(int i = 0; i < binString.length(); i++) {
				char c = binString.charAt(i);
				if (c == '1') {
					combo.append(input.charAt(i));

				}
			}
			results.add(combo.toString());
			n--;
		}

		return results;
	}
	public static void main(String...args) {
		System.out.println(combinations("abcd"));
	}
}