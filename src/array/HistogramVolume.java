package array;

import java.util.Stack;

/**
 */
public class HistogramVolume {

	static int histoVol(int[] input, int i, int j) {
		if (i == j) {
			return input[i];
		}
		return Math.min(input[i], input[j]) * (j - i);
	}

	static int naiveVolume(int[] input) {
		int max  = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				int curVol = histoVol(input, i, j);
				if (curVol > max) {
					max = curVol;
				}
			}
		}
		return max;
	}


	static int moreOptimal(int[] input) {
		int low = 0;
		int hi = input.length - 1;

		int max = 0;
		while(low < hi) {
			int currentVol = histoVol(input, low, hi);
			if (currentVol > max) {
				max = currentVol;
			}
			int min = Math.min(input[low], input[hi]);
			if (min == input[low]) {
				low += 1;
			} else {
				hi -= 1;
			}
		}

		return max;
	}

	static int getMaxArea(int[] hist) {
		Stack<Integer> bars = new Stack<>();

		int max_area = 0;

		int i = 0;
		while (i < hist.length) {
			if (bars.isEmpty() || hist[bars.peek()] < hist[i]) {
				bars.push(i);
			} else {
				int topIndx = bars.pop();

				int topArea = hist[topIndx] * (bars.isEmpty() ? i : i - bars.peek() - 1);

				if (topArea > max_area) {
					max_area = topArea;
				}
			}

			i += 1;
		}


		while (!bars.isEmpty()) {
			int topIndx = bars.pop();

			int topArea = hist[topIndx] * (bars.isEmpty() ? hist.length - 1 : hist.length - 1 - bars.peek() - 1);

			if (topArea > max_area) {
				max_area = topArea;
			}
		}

		return max_area;
	}


	public static void main(String...args) {
		System.out.println(naiveVolume(new int[]{5, 3, 4}));
		System.out.println(moreOptimal(new int[]{5, 3, 4}));
	}
}
