package string;

/**
 * Created by liuben10 on 8/6/17.
 */
public class OneLevelEditDistance {

	public static boolean hasAtLeastOneEdit(String a, String b) {
		int maxLength = Integer.max(a.length(), b.length());
		String longest = b.length() == maxLength ? b : a;
		String shortest = b.length() == maxLength ? a : b;
		if (longest.length() > shortest.length() + 1) {
			return false;
		}

		boolean hasAnEdit = false;
		for (int i = 0, j = 0; i < longest.length() && j < shortest.length(); i++, j++) {
			if (longest.charAt(i) != shortest.charAt(j)) {
				hasAnEdit = true;
				if (a.length() == b.length()) {
					return !hasAtLeastOneEdit(a.substring(i+1), b.substring(j+1));
				} else if (a.length() > b.length()) {
					return !hasAtLeastOneEdit(a.substring(i+1), b.substring(j));
				} else {
					return !hasAtLeastOneEdit(a.substring(i), b.substring(j+1));
				}
			}
		}
		return hasAnEdit;
	}

	public static void main(String...args) {
		System.out.println(hasAtLeastOneEdit("palekj", "plekj"));
	}
}
