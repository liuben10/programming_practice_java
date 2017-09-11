package string;

import java.util.*;

/**
 * Created by liuben10 on 8/6/17.
 */
public class DeterminePermutation {

	public static boolean isPermutationLinear(String a, String b) {
		Map<Character, Integer> aChar = new HashMap<>();
		for (char c : a.toCharArray()) {
			if (aChar.containsKey(c)) {
				aChar.put(c, aChar.get(c) + 1);
			} else {
				aChar.put(c, 1);
			}
		}

		Map<Character, Integer> bChar = new HashMap<>();
		for (char c : b.toCharArray()) {
			if (bChar.containsKey(c)) {
				bChar.put(c, bChar.get(c) + 1);
			} else {
				bChar.put(c, 1);
			}
		}

		for (Character c : aChar.keySet()) {
			if (!bChar.containsKey(c) || bChar.get(c) != aChar
					.get(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPermutation(String a, String b) {
		char[] aCharArray = a.toCharArray();
		char[] bCharArray = b.toCharArray();
		Arrays.sort(aCharArray);
		Arrays.sort(bCharArray);
		return Arrays.equals(aCharArray, bCharArray);
	}

	public static void main(String...args) {
		System.out.println(isPermutationLinear("abcd", "cbad"));
	}
}
