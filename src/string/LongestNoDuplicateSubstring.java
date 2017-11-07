package string;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class LongestNoDuplicateSubstring {

	public static int longestNoDups(String input) {

		if (input.length() == 0) {
			return 0;
		}
		if (input.length() == 1) {
			return 1;
		}

		int low = 0;
		int hi = 0;
		int maxSize = 0;

		Set<Character> subchars = new HashSet<>();
		while(hi < input.length()) {
			 if (!subchars.contains(input.charAt(hi))) {
			 	subchars.add(input.charAt(hi));
			 	hi += 1;
			 } else {
			 	if (subchars.size() > maxSize) {
			 		maxSize = subchars.size();
				}
			 	while(subchars.contains(input.charAt(hi))) {
			 		subchars.remove(input.charAt(low));
			 		low += 1;
				}
			 }
		}

		if (subchars.size() > maxSize) {
			maxSize = subchars.size();
		}

		return maxSize;
	}


	public static void main(String...args) {
		System.out.println(longestNoDups("caabaad"));
	}
}
