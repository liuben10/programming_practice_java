package csp;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by liuben10 on 9/20/17.
 */
public class Cryptagrithm {

	Set<String> domains = new HashSet<>();

	List<Relation> relationList = new ArrayList<>();

	public Cryptagrithm(String[][] input) {
		for(int i = input[input.length - 1].length - 1; i >= 0; i--) {
			for(int j = input.length-1; j >= 0; j--) {
				if (i < input[j].length && !domains.contains(String.valueOf(input[j][i]))) {
					domains.add(String.valueOf(input[j][i]));
				}
			}
		}

		relationList.add(new NotAllZero(domains));

		relationList.add(new SumRelation(input));
	}

	class NotAllZero implements Relation {


		private final Set<String> domains;

		public NotAllZero(Set<String> domains) {
			this.domains = domains;
		}

		@Override
		public boolean acceptable(Map<String, Integer> assignments) {
			HashSet<Integer> valueSet = new HashSet<>(assignments.values());

			Sets.SetView<String> difference = Sets.difference(assignments.keySet(), domains);

			if (!difference.isEmpty()) {
				return true;
			}
			return !(valueSet.size() == 1 && valueSet.iterator().next() == 0);
		}
	}

	class UniqueRelation implements Relation {

		@Override
		public boolean acceptable(Map<String, Integer> assignments) {
			Set<Integer> uniq = new HashSet<>();

			for (String s : assignments.keySet()) {
				if (uniq.contains(assignments.get(s))) {
					return false;
				} else {
					uniq.add(assignments.get(s));
				}
			}
			return true;
		}
	}

	static class SumRelation implements Relation {

		private final String[][] expr;

		public SumRelation(String[][] arithmeticExpr) {
			this.expr = arithmeticExpr;
		}

		@Override
		public boolean acceptable(Map<String, Integer> assignments) {

			int totalSum = 0;
			for (int i = 0; i < expr.length-1; i++) {
				int layerInt = 0;
				for (int j = 0; j < expr[i].length; j++) {
					if (!assignments.containsKey(expr[i][j])) {
						return true;
					}
					layerInt += Math.pow(10, j) * assignments.get(expr[i][j]);
				}
				totalSum += layerInt;
			}

			String[] resultExpr = expr[expr.length - 1];
			int checkSum = totalSum;
			int exprIdx = 0;
			while(checkSum > 0) {
				int digit = checkSum % 10;
				if (!assignments.containsKey(resultExpr[exprIdx])) {
					return false;
				} else {
					if (digit == assignments.get(resultExpr[exprIdx])) {
						exprIdx += 1;
						checkSum /= 10;
					} else {
						return false;
					}
				}
			}
			return true;

		}
	}

	public Map<String, Integer> crypta() {
		Map<String, Integer> assignments = new HashMap<>();
		return cryptaHelper(assignments, domains.iterator().next());
	}

	private Map<String, Integer> cryptaHelper(Map<String, Integer> assignments, String evaluating) {
		Sets.SetView<String> difference = Sets.difference(domains, assignments.keySet());

		if (difference.isEmpty()) {
			return assignments;
		} else {
			for (int i = 0; i < 10; i++) {
				assignments.put(evaluating, i);
				if (!violatesConstraint(assignments, relationList)) {
					if (difference.isEmpty()) {
						return assignments;
					}
					String unassigned = difference.iterator().next();

					Map<String, Integer> finalAssignment = cryptaHelper(assignments, unassigned);
					if (finalAssignment != null) {
						return finalAssignment;
					} else {
						assignments.remove(evaluating, i);
					}
				}
			}
			return null;
		}
	}

	private boolean violatesConstraint(Map<String, Integer> assignments, List<Relation> relationList) {
		for (Relation relation : relationList) {
			if (!relation.acceptable(assignments)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String...args) {
		String[][] testIn = new String[][]{
				{"O", "W", "T"},
				{"O", "W", "T"},
				{"R", "U", "O", "F"}
		};

		final Cryptagrithm cryptagrithm = new Cryptagrithm(testIn);

		Map<String, Integer> result = cryptagrithm.crypta();
		System.out.println(result);


	}

	private interface Relation {

		boolean acceptable(Map<String, Integer> assignments);

	}
}
