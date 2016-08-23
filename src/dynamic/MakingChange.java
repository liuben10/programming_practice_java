package dynamic;

import java.util.LinkedList;
import java.util.List;

public class MakingChange {
	
	public static void main(String...args) {
		System.out.println(makingChange(new int[]{1, 3, 4}, 6));
	}
	

	public static List<Integer> makingChange(final int[] coins, final int total) {
		final int[] V = new int[total+1];
		final int[] C = new int[total+1];
		V[0] = 0;
		C[0] = 0;
		for(int i = 1; i < total+1; i++) {
			int minValue = Integer.MAX_VALUE;
			int minCoin = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin >= 0) {
					if ((V[i - coin] + 1) < minValue) {
						minValue = V[i-coin] + 1;
						minCoin = coin;
					}
				}
			}
			V[i] = minValue;
			C[i] = minCoin;
		}
		List<Integer> results = new LinkedList <>();
		int i = C.length-1;
		while(i > 0) {
			results.add(C[i]);
			i = i - C[i];
		}

		return results;
	}

}
