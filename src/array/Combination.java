package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Combination {
	
	
	public static void main(String...args) {
		Set<String> result = combinationRecursive("abcde");
		System.out.println(result);
	}


	public static Set<String> combinationRecursive(String input) {
		if (input.length() == 0) {
			return new HashSet<>(Arrays.asList(""));
		}
		Set<String> result = new HashSet<>();

		result.add(input);

		for (int i = 0; i < input.length(); i++) {
			Set<String> powerSet = combinationRecursive(input.substring(0, i) + input.substring(i + 1));
			result.addAll(powerSet);
		}

		return result;
	}
	
	
	public static void printCombinations(String a) {
		for (int i = 0; i < Math.pow(2, a.length()); i++) {
			StringBuilder combo = new StringBuilder();
			int n = i;
			int cnt = 0;
			while (n != 0) {
				if ((n & 1) > 0) {
					combo.append(a.charAt(cnt));
				}
				n = n >> 1;
				cnt += 1;
			}
			System.out.println(combo);
		}
	}

}
