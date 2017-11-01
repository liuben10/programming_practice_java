package string;

/**
 */
public class LargestPalindrome {

	public static int largestPalindrome(String input) {
		int maxSize = 0;

		for (int i = 0; i < input.length(); i++) {

			int up = i;
			int low = i;
			int curSize = 0;

			while(up < input.length() && low >= 0 && input.charAt(up) == input.charAt(low)) {
				if (up == low) {
					curSize += 1;
				} else {
					curSize += 2;
				}
				up += 1;
				low -= 1;
			}

			if (curSize > maxSize) {
				maxSize = curSize;
			}

			up = i+1;
			low = i;
			curSize = 0;

			while(up < input.length() && low >= 0 && input.charAt(up) == input.charAt(low)) {
				curSize += 2;
				up += 1;
				low -= 1;
			}

			if (curSize > maxSize) {
				maxSize = curSize;
			}
		}

		return maxSize;
	}

	public static void main(String...args) {
		System.out.println(largestPalindrome("abcdbdckjlklj"));
	}
}
