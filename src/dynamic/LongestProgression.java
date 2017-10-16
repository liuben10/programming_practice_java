package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class LongestProgression {

	public static List<Integer> longestNaive(int[] seq) {
		return longestNaiveHelper(seq, 0);
	}

	private static List<Integer> longestNaiveHelper(int[] seq, int start) {
		if (start == seq.length - 1) {
			return new ArrayList<>(Arrays.asList(seq[start]));
		}

		List<List<Integer>> sequences = new ArrayList<>();

		int cur = seq[start];
		sequences.add(new ArrayList<>(Arrays.asList(cur)));

		for (int i = start; i < seq.length; i++) {
			if (seq[i] > cur) {
				List<Integer> subresult = longestNaiveHelper(seq, i);
				subresult.add(0, cur);
				sequences.add(subresult);
			}
		}

		List<Integer> max = new ArrayList<>();
		for (List<Integer> sequence : sequences) {
			if (sequence.size() > max.size()) {
				max = sequence;
			}
		}
		return max;
	}

	private static List<Integer> longestNaiveDynamic(int[] seq) {

		int N = seq.length;
		List<List<Integer>> progressions = new ArrayList<>();

		for(int i = N-1; i >= 0; i--) {
			ArrayList<Integer> minSizeList = new ArrayList<>();
			minSizeList.add(seq[i]);
			for(int j = 0; j < progressions.size(); j++) {
				if (progressions.get(j).get(0) > seq[i] && progressions.get(j).size() + 1 > minSizeList.size()) {
					ArrayList toAdd = new ArrayList<>(progressions.get(j));
					toAdd.add(0, seq[i]);
					minSizeList = toAdd;
				}
			}
			progressions.add(0, minSizeList);
		}

		List<Integer> max = new ArrayList<>();
		for (List<Integer> sequence : progressions) {
			if (sequence.size() > max.size()) {
				max = sequence;
			}
		}
		return max;
	}

	public static void main(String...args) {
		System.out.println(longestNaiveDynamic(new int[]{4, 3, 2, 4, 5, 6, 1, 2, 3,4 ,5 ,6 ,1 ,2, 3, 10, 11, 32, 14, 2,5, 16, 5, 3}));
	}
}
