package string;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestSubstringInString {
	
	public static void main(String...args) {
		System.out.println(smallestSubstring("abc", "adbcbbba"));
	}
	
	
	public static String smallestSubstring(String arr, String input) {
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for(int i = 0; i < arr.length(); i++) {
			counts.put(arr.charAt(i), 0);
		}
		String result = null;
		int tail = 0;
		int uniqueCount = 0;
		for (int head = 0; head < input.length(); head++) {
			char curChar = input.charAt(head);
			if (!counts.containsKey(curChar)) {
				continue;
			}
			int headValue = counts.get(curChar);
			if (headValue == 0) {
				uniqueCount += 1;
			}
			counts.put(curChar, counts.get(curChar) + 1);
			while (uniqueCount == arr.length()) {
				String curSubString = input.substring(tail, head+1);
				if (result == null || curSubString.length() < result.length()) {
					result = curSubString;
				}
				char tailValue = input.charAt(tail);
				if (counts.containsKey(tailValue)) {
					int tailCount = counts.get(tailValue) - 1;
					if (tailCount == 0) {
						uniqueCount -= 1;
					}
					counts.put(tailValue, tailCount);
				}
				tail += 1;
			}
		}
		return result;
	}

}
