package dynamic;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 */
public class MaximumInteger {


	static Set<Character> vowels = ImmutableSet.of('A', 'E', 'I', 'O', 'U');


	public static int foo(String input) {
		char[] chars = input.toCharArray();

		char prev = '\0';
		int maxNum = 0;
		for (int i = 0; i < chars.length; i++) {
			if (vowels.contains(chars[i]) && chars[i] == prev) {
				maxNum += 1;
			}
			prev = chars[i];
		}
		return maxNum;
	}

	public static void main(String...args) {
		System.out.println("BCDEEIOU" + ", " + foo("BCDEEIOU"));
		System.out.println("BCDEEEIOU" + ", " + foo("BCDEEEIOU"));
		System.out.println("ABCDEFG" + ", " + foo("ABCDEFG"));
		System.out.println("ABEUUOUOO" + ", " + foo("ABEUUOUOO"));
	}
}
