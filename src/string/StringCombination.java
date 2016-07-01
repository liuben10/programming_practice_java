package string;

public class StringCombination {
	
	
	
	public static void main(String...args) {
		System.out.println(findHowManyStrings("", "", "11111"));
	}
	
	
	public static int findHowManyStrings(String soFar, String numberString, String rest) {
		final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (rest.length() == 0) {
			System.out.println(soFar + "=" + numberString);
			return 1;
		} else if (rest.length() == 1) {
			System.out.println(soFar + ALPHABET.charAt(Integer.parseInt(rest)-1) + "=" + numberString + rest);
			return 1;
		} else {
			int sum = findHowManyStrings(soFar + ALPHABET.charAt(Integer.parseInt(rest.substring(0, 1))-1) + ",", numberString + rest.substring(0, 1) + ",", rest.substring(1));
			String firstTwo = rest.substring(0, 2);
			if (Integer.parseInt(firstTwo) <= 26) {
				sum += findHowManyStrings(soFar + ALPHABET.charAt(Integer.parseInt(firstTwo)-1) + ",", numberString + rest.substring(0,2) + ",", rest.substring(2));
			}
			return sum;
		}
	}
}
