package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 */
public class FindAllAnagramIndices {

	public static List<Integer> anagramIndexes(String input, String toFind) {
		int findLength = toFind.length();
		List<Character> sortedChars = sorted(toFind);
		List<Integer> indexes = new ArrayList<>();

		for(int i = 0; i < input.length()-findLength; i++) {
			String subStringToCheck = input.substring(i, i+findLength);
			List<Character> sortedToCheck = sorted(subStringToCheck);
			if (sortedChars.equals(sortedToCheck)) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	public static List<Character> sorted(String input) {
		List<Character> characters = new ArrayList<>();
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		Collections.sort(characters);
		return characters;
	}

	public static int intVal(String substring) {
		int sum = 0;
		for(char c : substring.toCharArray()) {
			sum += (int) c;
		}
		return sum;
	}

	public static void main(String...args) {
		System.out.println(anagramIndexes("ABCDEFGTJKASLDFJKLADSALKFJKLADSFJKLASDFJASLFKJSAFDADAFJSADFKLSDAJF", "KLA"));
		System.out.println(anagramIndexes("ABABABABABABABABABA", "AB"));
	}
}
