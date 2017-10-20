package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class JumbledNumbers {

	public static List<String> jumbled(int n) {
		if (n == 1) {
			List<String> jumbled = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				jumbled.add(Integer.toString(i));
			}
			return jumbled;
		} else {
			List<String> jumbled = new ArrayList<>();
			List<String> previousJumbled = jumbled(n - 1);
			for (String s : previousJumbled) {
				Integer integer = Character.getNumericValue(s.charAt(s.length() - 1));
				if (integer - 1 >= 0) {
					jumbled.add(s + Integer.toString(integer - 1));
				}
				if (integer + 1 < 10) {
					jumbled.add(s + Integer.toString(integer + 1));
				}
				jumbled.add(s + Integer.toString(integer));
			}

			return jumbled;
		}
	}

	public static void main(String...args) {
		System.out.println(jumbled(4));
	}
}
