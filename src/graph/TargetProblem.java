package graph;

import java.util.*;

/**
 * Created by liuben10 on 7/23/17.
 */
public class TargetProblem {

	public static boolean canHitTarget(int[] inputInts, int[] operations, int target, int numTouches) {
		for (int inputInt : inputInts) {
			if (canHitTargetWithFirstInt(inputInt, inputInts, operations, target, numTouches)) {
				return true;
			}
		}
		return false;
	}

	private static int calculate(int a, int operation, int b) {
		switch (operation) {
			case 1:
				return a + b;
			case 2:
				return a - b;
			case 3:
				return a * b;
			case 4:
				return a / b;
			default:
				throw new IllegalArgumentException("Unsupported operation, must be between [1,4]");
		}

	}

	private static boolean canHitTargetWithFirstInt(int startInt, int[] inputInts, int[] operations, int target, int numTouches) {
		Stack<Integer> toExplore = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		toExplore.push(startInt);
		int touchSoFar = 0;
		while(!toExplore.isEmpty()) {
			Integer val = toExplore.pop();
			visited.add(val);
			touchSoFar += 1;
			if (val == target) {
				return true;
			} else if (touchSoFar == numTouches) {
				touchSoFar -= 1;
			} else {
				for (int inputInt : inputInts) {
					for (int operation : operations) {
						int calculatedValue = calculate(val, operation, inputInt);
						if (!visited.contains(calculatedValue)) {
							toExplore.push(calculatedValue);
						}
					}
				}
			}
		}
		return false;
	}


	public static void main(String...args) {
		System.out.println(canHitTargetWithFirstInt(4, new int[]{4, 3}, new int[]{1, 2, 3, 4}, 21, 2));
	}
}
