package backtracking;

import com.google.common.collect.ImmutableMap;

import java.util.*;

/**
 * Created by liuben10 on 9/20/17.
 */
public class Cryptagrithm {

	Map<String, Set<Integer>> domains = new HashMap<>();

	List<Relation> relationList = new ArrayList<>();

	private Set<Integer> possibleValues() {
		Set<Integer> possibleValues = new HashSet<>();
		for (int i = 0; i <= 9; i++) {
			possibleValues.add(i);
		}
		return possibleValues;
	}


	public Cryptagrithm(String[][] input) {
		for(int i = input[input.length - 1].length - 1; i >= 0; i--) {
			for(int j = input.length-1; j >= 0; j--) {
				if (i < input[j].length && !domains.containsKey(String.valueOf(input[j][i]))) {
					domains.put(String.valueOf(input[j][i]), possibleValues());
				}
			}
		}

		for(int col = input[input.length - 1].length - 1; col >= 0; col--) { //col = col
			final List<String> participating = new ArrayList<>();
			String dependantElem = String.valueOf(input[input.length - 1][col]);
			participating.add(0, dependantElem);
			for (int row = input.length - 2; row >= 0; row--) { //row = row
				if (col <= input[row].length - 1) {
					participating.add(0, String.valueOf(input[row][col]));
				}
			}
			if (col == 0) {
			} else {
				participating.add(0, "X" + (col - 1));
			}
			domains.put("X" + col, possibleValues());
			participating.add("X" + col);

			relationList.add(new ColRelation(participating));
		}
		final HashMap<String, Integer> assignments = new HashMap<>();
		assignments.put("F", 1);
		assignments.put("T", 6);
		assignments.put("O", 2);
		assignments.put("W", 3);
		assignments.put("U", 6);
		assignments.put("X3", 0);
		assignments.put("X2", 1);
		assignments.put("X1", 0);
		assignments.put("X0", 0);
		assignments.put("R", 4);
		for (Relation relation : relationList) {
			System.out.println(relation.participating() + ", " + relation.evalutesTrue(assignments));
		}
	}

	class ColRelation implements Relation {

		private final LinkedHashSet<String> participating;
		private final List<String> relation;

		public ColRelation(List<String> participating) {
			this.relation = participating;
			this.participating = new LinkedHashSet<>(participating);
		}

		@Override
		public LinkedHashSet<String> participating() {
			return participating;
		}

		@Override
		public boolean evalutesTrue(Map<String, Integer> assignments) {
			int sum = 0;
			for (int i = 0; i < relation.size()-2; i++) {
				if (!assignments.containsKey(relation.get(i))) {
					System.err.println("Invalid assignment {" + assignments + "}, for relation={" + relation + "}, for elem=" + relation.get(i) + ", assigning 0");
				} else {
					sum += assignments.get(relation.get(i));
				}
			}
			return sum == assignments.get(relation.get(relation.size() - 2)) +
					10 * assignments.get(relation.get(relation.size() - 1));

		}
	}

	public Map<Character, Integer> crypta() {
		Map<Character, Integer> assignments = new HashMap<>();
		return cryptaHelper(assignments, null);
	}

	private Map<Character, Integer> cryptaHelper(Map<Character, Integer> assignments, String[][] input) {
		return null;
	}

	public static void main(String...args) {
		String[][] testIn = new String[][]{
				{"O", "W", "T"},
				{"O", "W", "T"},
				{"R", "U", "O", "F"}
		};

		final Cryptagrithm cryptagrithm = new Cryptagrithm(testIn);
	}

	private interface Relation {

		LinkedHashSet<String> participating();

		boolean evalutesTrue(Map<String, Integer> assignments);

	}
}
