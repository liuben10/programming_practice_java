package string;

/**
 */
public class AllAlphaNumerics {

	public static void printAlpha(String s) {
		System.out.println(s);
		if (s.length() == 1) {
			return;
		} else {
			char[] schars = s.toCharArray();
			for (int i = 0; i < schars.length; i++) {
				if (Character.isAlphabetic(schars[i])) {
					int num = 1;
					char lowerNeighbor = i - 1 >= 0 ? schars[i-1] : '\0';
					char upperNeighbor = i + 1 < schars.length ? schars[i+1] : '\0';
					StringBuilder lowerHalf = new StringBuilder();
					if (Character.isDigit(lowerNeighbor)) {
						num += Character.getNumericValue(lowerNeighbor);
						lowerHalf.append(s.substring(0, i-1));
					} else {
						lowerHalf.append(s.substring(0, i));
					}

					StringBuilder upperHalf = new StringBuilder();
					if (Character.isDigit(upperNeighbor)) {
						num += Character.getNumericValue(upperNeighbor);
						if (i+2 < s.length()) upperHalf.append(s.substring(i+2));
					} else {
						upperHalf.append(s.substring(i+1));
					}

					printAlpha(lowerHalf.append(num).append(upperHalf).toString());
				}
			}
		}
	}

	public static void main(String...args) {
		printAlpha("ANKS");
	}
}
