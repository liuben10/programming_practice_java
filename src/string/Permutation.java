package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by benjaminliu on 8/26/16.
 */
public class Permutation {

	public static void main(String...args) {
		System.out.println(permutations("abc"));
	}

	public static List<String> permutations(String a) {
		if (a.length() == 1) {
			return new ArrayList<>(Arrays.asList(a.substring(0, 1)));
		} else {
			List<String> permutations = new ArrayList<>();
			for (int i = 0; i < a.length(); i++) {
				final String currentString = a.substring(i, i+1);
				final List<String> permutationsRemoved = permutations(a.substring(0, i) + a.substring(i + 1, a.length()));
				for (String s : permutationsRemoved) {
					permutations.add(currentString + s);
				}
			}
			return permutations;
		}
	}
}
