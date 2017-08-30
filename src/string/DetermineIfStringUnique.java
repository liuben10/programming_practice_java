package string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;

/**
 * Created by liuben10 on 8/6/17.
 */
public class DetermineIfStringUnique {

	public static boolean determineUniqueWithoutDatastruct(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (j != i && input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean determineUniqueNaive(String input) {
		Set<Character> toCheckAgainst = new HashSet<>();
		for (char c : input.toCharArray()) {
			if (!toCheckAgainst.contains(c)) {
				toCheckAgainst.add(c);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String...args) {
		System.out.println(determineUniqueWithoutDatastruct("abcdef"));
	}
}
