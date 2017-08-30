package array;

import java.util.Arrays;

/**
 * Created by liuben10 on 8/15/17.
 */
public class LongestSubarrayWithLettersAndNumbers {

	private static char[] findLongestSubarrayNaive(char[] lettersAndNumbers) {
		char[] maxCharArray = null;
		for (int i = 0; i < lettersAndNumbers.length; i++) {
			for (int j = i; j < lettersAndNumbers.length; j++) {
				char[] subArray = Arrays.copyOfRange(lettersAndNumbers, i, j+1);
				if (maxCharArray == null || hasSameLength(subArray) && subArray.length > maxCharArray.length) {
					maxCharArray = subArray;
				}
			}
		}
		return maxCharArray;
	}



	private static boolean hasSameLength(char[] subArray) {
		int letterCount = 0;
		int digitCount = 0;
		for (char c : subArray) {
			if (Character.isDigit(c)) {
				digitCount += 1;
			} else {
				letterCount += 1;
			}
		}
		return letterCount == digitCount;
	}

	public static void main(String...args) {
		char[] testIn = new char[]{'6', 'a', 'b', 'c', 'd', '1', 'f', '2', '3', '4', '5'};
		System.out.println(Arrays.toString(findLongestSubarrayNaive(testIn)));
	}
}
