package array;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by liuben10 on 9/25/17.
 */
public class RangeProblem {

	private static List<List<Integer>> merge(List<List<Integer>> ranges, List<Integer> ins) {
		List<Integer> insert = new ArrayList<>(ins);

		List<List<Integer>> merged = new ArrayList<>();
		for(List<Integer> range : ranges) {
			if (ins.get(1) < range.get(0) || ins.get(0) > range.get(1)) {
				merged.add(range);
			} else {
				if (range.get(0) < ins.get(0)) {
					insert.set(0, range.get(0));
				}
				if (range.get(1) > ins.get(1)) {
					insert.set(1, range.get(1));
				}
			}
		}
		merged.add(insert);
		return merged;
	}

	public static void main(String...args) {
		List<List<Integer>> inRange1 = asList(asList(2, 3));
		List<Integer> pair1 = asList(1, 2);
		System.out.println(merge(inRange1, pair1));

		List<List<Integer>> inRange2 = asList(asList(-1, 1), asList(2, 3), asList(5, 6), asList(10, 11));
		List<Integer> pair2 = asList(1, 5);
		System.out.println(merge(inRange2, pair2));

		List<List<Integer>> inRange3 = asList(asList(1, 3));
		List<Integer> pair3 = asList(2, 4);
		System.out.println(merge(inRange3, pair3));
	}
}
