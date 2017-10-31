package array;

import java.util.*;

/**
 */
public class Combo {

	/**
	 * the list.subList method mutates the list...
	 * @param input
	 * @param src
	 * @param dest
	 * @return
	 */
	public static List<Integer> sublist(List<Integer> input, int src, int dest) {
		ArrayList<Integer> sublist = new ArrayList<>(input);
		return sublist.subList(src, dest);
	}

	public static Set<List<Integer>> combos(List<Integer> input) {
		if (input.size() == 0) {
			return new HashSet<>(new ArrayList<>());
		} else {
			Set<List<Integer>> combos = new HashSet<>();
			combos.add(input);

			for (int i = 0; i < input.size(); i++) {
				List<Integer> aSub = sublist(input,0, i);
				List<Integer> rest = sublist(input,i+1, input.size());

				aSub.addAll(rest);

				combos.addAll(combos(aSub));
			}
			return combos;
		}

	}

	public static void main(String...args) {
		System.out.println(combos(new ArrayList<>(Arrays.asList(4,5))));
	}
}
