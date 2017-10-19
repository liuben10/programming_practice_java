package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liuben10 on 10/2/17.
 */
public class PowerSet {

	/**
	 * "A", "B", "C", "D"
	 * Example: i = 1101 and idx = 3
	 * idx = listIn.size() - 1 -> 1111
	 *  1101
	 *  1000
	 * @param listIn
	 */

	private static void powerSet(List<String> listIn) {
		int cardinality = (int) Math.pow(2, listIn.size()); //This generates the 2^n numbers.

		for(int i = 0; i < cardinality; i++) {
			Set<String> curSubset = new HashSet<>();
			int idx = listIn.size()-1; //This is the current index of the element that we are inspectig
			int mask = cardinality >> 1; //This is masking value that we use as we iterate through. the mask is basically 10000 and we shift the 1 to the right.
			while (mask > 0) {
				if ((i & mask) > 0) { //For each value, we and it with the mask to see if the bit in that position of i is non zero.
					curSubset.add(listIn.get(idx)); //If that bit is non zero, then we add the character at that position.
				}
				idx -= 1; //We subtract our index.
				mask = mask >> 1;
			}
			if (!curSubset.isEmpty())
				System.out.println(curSubset);
		}
	}

	public static void main(String...args) {
		powerSet(Arrays.asList("A" ,"B", "C", "D"));
	}
}
