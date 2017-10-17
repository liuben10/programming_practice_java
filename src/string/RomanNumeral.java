package string;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 */
public class RomanNumeral {

	private static BiMap<Character, Integer> bimap = HashBiMap.create();

	static {
		bimap.put('M', 1000);
		bimap.put('D', 500);
		bimap.put('C', 100);
		bimap.put('L', 50);
		bimap.put('X', 10);
		bimap.put('V', 5);
		bimap.put('I', 1);
	}

	public static int convert(String roman) {
		char[] romans = roman.toCharArray();
		int result = 0;
		char prev = '\0';
		for(int i = romans.length - 1; i >= 0; i--) {
			char cur = romans[i];
			int intVal = bimap.get(cur);
			if (prev != '\0' && bimap.get(prev) > intVal) {
				result -= intVal;
			} else {
				result += intVal;
			}
			prev = cur;
		}
		return result;
	}

	public static void main(String...args) {
		System.out.println(convert("XLIX"));
	}
}
