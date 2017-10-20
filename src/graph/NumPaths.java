package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 */
public class NumPaths {

	static class Wrapper {
		Integer val;
		List<Integer> path;

		public Wrapper(Integer val, List<Integer> path) {
			this.val = val;
			this.path = path;
		}
	}

	public static List<List<Integer>> printAllPathsRecursion(int n) {
		if (n == 0) {
			ArrayList<List<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>(Arrays.asList(0)));
			return result;
		} else {
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; Math.pow(2, i) <= n; i++) {
				int pow = (int) Math.pow(2, i);
				List<List<Integer>> pathsSoFar = printAllPathsRecursion(n - pow);
				for (List<Integer> integers : pathsSoFar) {
					integers.add(integers.get(integers.size() - 1) + pow);
					result.add(integers);
				}
			}
			return result;
		}
	}

	public static List<List<Integer>> printAllPathsGraph(int n) {
		int starting = 0;
		Stack<Wrapper> fringe = new Stack<>();
		fringe.push(new Wrapper(starting, new ArrayList<>(Arrays.asList(0))));
		List<List<Integer>> paths = new ArrayList<>();
		while(!fringe.isEmpty()) {
			Wrapper popped = fringe.pop();
			if (popped.val == n) {
				paths.add(popped.path);
			}

			for (int i = 0; Math.pow(2, i) <= n - popped.val; i++) {
				List<Integer> added = new ArrayList<>(popped.path);
				int newVal = (int) (popped.val + Math.pow(2, i));
				added.add(newVal);
				fringe.add(new Wrapper(newVal, added));
			}
		}
		return paths;
	}

	public static void main(String...args) {
		System.out.println(printAllPathsRecursion(4));
	}
}
