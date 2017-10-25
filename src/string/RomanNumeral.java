package string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 */
public class RomanNumeral {

	private static Map<Character, Integer> romanNumeralToInteger = new LinkedHashMap<>();

	private static Map<Integer, Character> numeralToRoman = new LinkedHashMap<>();

	static {
		romanNumeralToInteger.put('M', 1000);
		romanNumeralToInteger.put('D', 500);
		romanNumeralToInteger.put('C', 100);
		romanNumeralToInteger.put('L', 50);
		romanNumeralToInteger.put('X', 10);
		romanNumeralToInteger.put('V', 5);
		romanNumeralToInteger.put('I', 1);

		numeralToRoman.put(1000, 'M');
		numeralToRoman.put(500, 'D');
		numeralToRoman.put(100, 'C');
		numeralToRoman.put(50, 'L');
		numeralToRoman.put(10, 'X');
		numeralToRoman.put(5, 'V');
		numeralToRoman.put(1, 'I');
	}

	public static int convert(String roman) {
		char[] romans = roman.toCharArray();
		int result = 0;
		char prev = '\0';
		for(int i = romans.length - 1; i >= 0; i--) {
			char cur = romans[i];
			int intVal = romanNumeralToInteger.get(cur);
			if (prev != '\0' && romanNumeralToInteger.get(prev) > intVal) {
				result -= intVal;
			} else {
				result += intVal;
			}
			prev = cur;
		}
		return result;
	}

	public static String convert(int num) {
		Iterator<Map.Entry<Character, Integer>> iterator = romanNumeralToInteger.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext()) {
			Map.Entry<Character, Integer> romanNumeral = iterator.next();

			while (romanNumeral.getValue() <= num) {
				num -= romanNumeral.getValue();
				sb.append(romanNumeral.getKey());
			}
		}
		return sb.toString();
	}

	public static void main(String...args) {
		System.out.println(convert("XLIX"));
		System.out.println(convert(9));
	}
}
