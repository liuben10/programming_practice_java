package array;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

import java.util.*;

/**
 * Created by liuben10 on 7/20/17.
 */
public class SubsetSum {

	private static List<Integer> subsetSumDynamic(int[] input, int sum) {
		Set<List<Integer>>[] subProblems = new Set[sum+1];
		for (int i = 1; i <= sum; i++) {
			Set<List<Integer>> minimumSubProblem = null;
			for (int j = 0; j < input.length; j++) {
				List<Integer> current = Arrays.asList(input[j], j);
				if (current.get(0) == i) {
					minimumSubProblem = new HashSet<>(Collections.singleton(current));
				} else if (i - current.get(0) >= 0 && subProblems[i - current.get(0)] != null) {
					Set<List<Integer>> subSetToCheck = new HashSet<>(ImmutableSet.copyOf(subProblems[i - current.get(0)]));
					if (subSetToCheck.contains(current)) {
						continue;
					} else {
						subSetToCheck.add(current);
					}
					if (minimumSubProblem != null) {
						if (minimumSubProblem.size() > subSetToCheck.size()) {
							minimumSubProblem = subSetToCheck;
						}
					} else {
						minimumSubProblem = subSetToCheck;
					}
				}
			}
			subProblems[i] = minimumSubProblem;
		}
		if (subProblems[sum] != null) {
			final List<Integer> result = new ArrayList<>();
			for (List<Integer> integers : subProblems[sum]) {
				result.add(integers.get(0));
			}
			return result;
		} else {
			return null;
		}
	}

	private static Set<Integer> subsetSumRecursive(int[] input, int sum) {
		List<Set<Integer>> subsetSumsToCompare = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			int current = input[i];
			if (current == sum) {
				return new HashSet<>(Collections.singleton(current));
			}
			int[] removed = removeCopy(input, i);
			Set<Integer> subsetWithI = subsetSumRecursive(removed, sum - current);
			if (subsetWithI.size() != 0) {
				subsetWithI.add(current);
				subsetSumsToCompare.add(subsetWithI);
			}
		}
		if (subsetSumsToCompare.size() == 0) {
			return new HashSet<>();
		}
		if (subsetSumsToCompare.size() == 1) {
			return subsetSumsToCompare.get(0);
		}
		Set<Integer> minimumSubset = Collections.min(subsetSumsToCompare, (subset1, subset2) -> Integer.compare(subset1.size(), subset2.size()));
		return minimumSubset;
	}

	private static int[] removeCopy(int[] input, int i) {
		int[] copy = new int[input.length-1];
		for (int j = 0; j < copy.length; j++) {
			if (j < i) {
				copy[j] = input[j];
			} else {
				copy[j] = input[j+1];
			}
		}
		return copy;
	}

	public static void main(String ... args) {
		int[] testInput1 = {5, 2, 3};
		int sum1 = 8;
		System.out.println(subsetSumDynamic(testInput1, sum1));

		int[] testInput2 = {5, 2, 3, 9, 10, 7, 6, 4, 8};
		int sum2 = 18;
		System.out.println(subsetSumDynamic(testInput2, sum2));

		int[] testInput3 = {1, 5, 2, 3, 9, 10, 7, 6, 4};
		int sum3 = 11;
		System.out.println(subsetSumDynamic(testInput3, sum3));

		int[] testInput4 = {5, 2, 3};
		int sum4 = 4;
		System.out.println(subsetSumDynamic(testInput4, sum4));
	}
}
