package array;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class LongestNoDuplicateSubstringK {

	/**
	 *
	 * Longest substring containing at most k dups.
	 * @param in
	 * @param k
	 * @return
	 */
	public static int longestNoDupKWindow(String in, int k) {

		int low = 0;
		int hi = 0;
		int maxSoFar = 0;
		int max = 0;
		Map<Character, Integer> dups = new HashMap<>();
		while (hi < in.length()) {
			if (!dups.containsKey(in.charAt(hi))) {
				if (dups.size() < k) {
					dups.put(in.charAt(hi), 1);

					maxSoFar = hi - low + 1;
					hi += 1;
				} else {
					if (maxSoFar > max){
						max = maxSoFar;
					}
					if (dups.containsKey(in.charAt(low))) {
						int lowCount = dups.get(in.charAt(low)) - 1;
						if (lowCount > 0) {
							dups.put(in.charAt(low), lowCount);
						} else {
							dups.remove(in.charAt(low));
						}
					}
					low += 1;
				}
			} else {
				dups.put(in.charAt(hi), dups.get(in.charAt(hi)) + 1);
				maxSoFar = hi - low + 1;

				hi += 1;
			}
		}

		return max;
	}


	public static void main(String...args) {
		System.out.println(longestNoDupKWindow("ccaaaaabbbbaaaaddkaaab", 2));
	}
}
