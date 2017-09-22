package main;

/**
 * Created by liuben10 on 3/13/17.
 */
public class isCrypt {

	public static void main(String...args) {
		isCrypt m = new isCrypt();
		String[] crypt = new String[]{"A", "A", "A"};
		char[][] sol = new char[][]{
				{'A', '0'}
		};
		System.out.println(m.isCryptSolution(crypt, sol));
	}

	boolean isCryptSolution(String[] crypt, char[][] solution) {
		int[] encrypt = new int[crypt.length];
		int i = 0;
		for(String plaintxt : crypt) {
			encrypt[i] = encrypt(plaintxt, solution);
			i += 1;
		}
		if (encrypt[0] + encrypt[1] == encrypt[2]
				&& !String.valueOf(encrypt[0]).startsWith("0")
				&& !String.valueOf(encrypt[1]).startsWith("0")) {
			return true;
		} else {
			return false;
		}
	}

	int encrypt(String input, char[][] solution) {
		int encrypted = 0;
		for(int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			for (int j = 0; j < solution.length; j++) {
				if (solution[j][0] == cur) {
					encrypted = encrypted * 10 + Integer.parseInt(String.valueOf(solution[j][1]));
				}
			}
		}
		return encrypted;
	}



}
