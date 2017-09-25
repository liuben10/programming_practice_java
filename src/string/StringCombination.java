package string;

public class StringCombination {

	public static void main(String...args) {
		System.out.println(findHowManyStrings("", "", "10122110"));
	}
	
	
	public static int findHowManyStrings(String soFar, String numberString, String rest) {
		final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (rest.equals("0")) {
			return 0;
		}
		if (rest.length() == 0) {
			System.out.println(soFar + "=" + numberString);
			return 1;
		} else if (rest.length() == 1) {
			System.out.println(soFar + ALPHABET.charAt(Integer.parseInt(rest)-1) + "=" + numberString + rest);
			return 1;
		} else {
			int firstCharacter = Integer.parseInt(rest.substring(0, 1)) - 1;
			int sum = 0;
			if (firstCharacter >= 0) {
				sum += findHowManyStrings(soFar + ALPHABET.charAt(firstCharacter) + ",", numberString + rest.substring(0, 1) + ",", rest.substring(1));
			}

			String firstTwo = rest.substring(0, 2);
			if (Integer.parseInt(firstTwo) <= 26) {
				sum += findHowManyStrings(soFar + ALPHABET.charAt(Integer.parseInt(firstTwo)-1) + ",", numberString + rest.substring(0,2) + ",", rest.substring(2));
			}
			return sum;
		}
	}
}
