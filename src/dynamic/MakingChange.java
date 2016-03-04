package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakingChange {
	
	public static void main(String...args) {
		System.out.println(maxNumCoins(new int[]{1, 3, 4}, 6));
	}
	
	public static int maxNumCoins(int[] coins, int value) {
		int[] S = new int[value+1];
		int[] coinUsed = new int[value+1];
		for(int i = 1; i <= value; i++) {
			int min = Integer.MAX_VALUE;
			int coinToKeep = 0;
			for (int p = 0; p < coins.length; p++) {
				int curCoin = coins[p];
				if (curCoin <= i) {
					if (S[i-curCoin] + 1 < min) {
						min = S[i-curCoin]+1;
						coinToKeep = curCoin;
					}
				}
			}
			S[i] = min;
			coinUsed[i] = coinToKeep;
		}
		System.out.println(Arrays.toString(coinUsed));
		int cnt = value;
		List<Integer> finalCoinUsed = new ArrayList<Integer>();
		while(cnt > 0) {
			finalCoinUsed.add(coinUsed[cnt]);
			cnt -= coinUsed[cnt];
		}
		System.out.println(Arrays.toString(S));
		System.out.println(finalCoinUsed);
		return S[S.length-1];
	}

}
