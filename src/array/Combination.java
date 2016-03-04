package array;

public class Combination {
	
	
	public static void main(String...args) {
		printCombinations("abcde");
	}
	
	
	public static void printCombinations(String a) {
		for (int i = 0; i < Math.pow(2, a.length()); i++) {
			StringBuilder combo = new StringBuilder();
			int n = i;
			int cnt = 0;
			while (n != 0) {
				if ((n & 1) > 0) {
					combo.append(a.charAt(cnt));
				}
				n = n >> 1;
				cnt += 1;
			}
			System.out.println(combo);
		}
	}

}
