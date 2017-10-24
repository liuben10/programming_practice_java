package array;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class SumOfDistinct {


	public static int sumOfDistinct(int[] input) {
		int sumDistinct = 0;
		for (int i = 0; i < input.length; i++) {

			Set<Integer> dups = new HashSet<>();
			for (int j = i; j < input.length; j++) {
				if (!dups.contains(input[j])) {
					dups.add(input[j]);
					sumDistinct += dups.size();
				}
			}
		}
		return sumDistinct;
	}



	public static void main(String...args) {
		System.out.println(sumOfDistinct(new int[]{1, 2, 1}));
	}
}
