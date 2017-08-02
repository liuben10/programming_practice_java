package string;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ReverseWords {

	public static String reverseWords(String input) {
		char[] inputChar = input.toCharArray();
		int len = inputChar.length;

		char[] res = new char[len];
		int lastWordCutoff = len;
		int resInd = 0;
		for(int i = len-1; i >= 0; i--) {
			if (inputChar[i] == ' ') {
				for(int j = i+1; j < lastWordCutoff; j++) {
					res[resInd] = inputChar[j];
					resInd += 1;
				}
				lastWordCutoff = i;
				res[resInd] = " ".charAt(0);
				resInd += 1;
			}
		}

		for(int i = 0; i < lastWordCutoff; i++) {
			res[resInd] = inputChar[i];
			resInd += 1;
		}

		return new String(res);
	}

	public static void main(String...args) {
		System.out.println(reverseWords("The sky is blue"));
	}
}
