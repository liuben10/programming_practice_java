package string;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class CanFormLottery {

	public static boolean isLottery(String input) {
		return Integer.parseInt(input) < 59;
	}

	public static boolean canFormLotteryHelper(String input, int numDigits, Set<String> unq) {
//		System.out.println("f(" + input + ", " + numDigits + ", " + unq + ")");
		if (input.length() == 0 && numDigits == 7) {
			return true;
		} else if (input.length() == 0 && numDigits != 0) {
			return false;
		} else {
			boolean takeOne = false;
			if (input.length() > 0) {
				String one = input.substring(0, 1);
				if (unq.contains(one)) {
					takeOne = false;
				} else {
					Set<String> added = new HashSet<>(unq);
					added.add(one);
					takeOne = (isLottery(one) && canFormLotteryHelper(input.substring(1), numDigits + 1, added));
				}

			}

			boolean takeTwo = false;
			if (input.length() > 1) {
				String two = input.substring(0, 2);
				if (unq.contains(two)) {
					takeTwo = false;
				} else {
					Set<String> added = new HashSet<>(unq);
					added.add(two);
					takeTwo = (isLottery(two) && canFormLotteryHelper(input.substring(2), numDigits + 1, added));
				}
			}

			return takeOne || takeTwo;
		}

	}

	public static boolean canFormLottery(String input) {
		return canFormLotteryHelper(input, 0, new HashSet<>());
	}

	public static void main(String...args) {
		System.out.println(canFormLottery("4938532894754"));
		System.out.println(canFormLottery("1634616512"));
		System.out.println(canFormLottery("1122334"));
	}
}
