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
	 *  1101
	 *  1000
	 * @param listIn
	 */

	private static void powerSet(List<String> listIn) {
		int cardinality = (int) Math.pow(2, listIn.size());

		for(int i = 0; i < cardinality; i++) {
			Set<String> curSubset = new HashSet<>();
			int idx = listIn.size()-1;
			int mask = cardinality >> 1;
			while (mask > 0) {
				if ((i & mask) > 0) {
					curSubset.add(listIn.get(idx));
				}
				idx -= 1;
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
