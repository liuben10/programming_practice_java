package string;

import java.util.Arrays;

public class ReplaceSpace {
	
	public static void main(String...args) {
		System.out.println(replaceSpace("hello foo bar world"));
	}
	
	public static String replaceSpace(String inputString) {
		char[] input = inputString.toCharArray();
		int spaces = 0;
		for (int i =0 ; i < input.length; i++) {
			if (input[i] == ' ') {
				spaces += 2;
			}
		}
		char[] newCharArray = new char[input.length + spaces];
		System.arraycopy(input, 0, newCharArray, 0, input.length);
		int slowPtr = newCharArray.length - 1;
		int fastPtr = input.length - 1;
		while (fastPtr >= 0) {
			System.out.println(Arrays.toString(newCharArray));
			if (newCharArray[fastPtr] == ' ') {
				fastPtr -= 1;
				newCharArray[slowPtr--] = '0';
				newCharArray[slowPtr--] = '2';
				newCharArray[slowPtr--] = '%';
			} else {
				newCharArray[slowPtr--] = newCharArray[fastPtr--];
			}
		}
		return new String(newCharArray);
	}

}
