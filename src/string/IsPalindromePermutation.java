package string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuben10 on 8/6/17.
 */
public class IsPalindromePermutation {

	public static boolean isPalindromePermutation(final String input) {
		String filtered = StringUtils.lowerCase(StringUtils.remove(input, ' '));
		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c : filtered.toCharArray()) {
			if (charCounts.containsKey(c)) {
				charCounts.put(c, charCounts.get(c) + 1);
			} else {
				charCounts.put(c, 1);
			}
		}

		boolean seenOneAlready = false;
		for (Map.Entry<Character, Integer> charCount : charCounts.entrySet()) {
			if (charCount.getValue() == 1) {
				if (seenOneAlready && filtered.length() % 2 != 0) {
					return false;
				} else if (filtered.length() % 2 == 0) {
					return false;
				}
			} else if (charCount.getValue() > 2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String...args) {
		System.out.println(isPalindromePermutation("Tact Coa"));

	}
}
