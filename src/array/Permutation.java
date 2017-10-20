package array;

import java.util.*;

/**
 */
public class Permutation {


	public static List<String> permutations(String input) {
		if (input.length() == 1) {
			return new ArrayList<>(Arrays.asList(String.valueOf(input.charAt(0))));
		} else {
			List<String> result = new ArrayList<>();
			for (int i = 0; i < input.length(); i++) {
				char current = input.charAt(i);
				List<String> permutations = permutations(input.substring(0, i) + input.substring(i + 1));
				for (String permutation : permutations) {
					StringBuilder stringBuilder = new StringBuilder().append(current);
					String appended = stringBuilder.append(permutation).toString();
					result.add(appended);
				}
			}
			return result;
		}
	}

	public static void main(String...args) {
		System.out.println(permutations("abcdefg"));
	}
}
