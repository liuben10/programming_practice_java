package array;

import java.util.Stack;

/**
 * Created by liuben10 on 8/2/17.
 */
public class BarGraphVolume {


	public static int barGraphVolume(int[] args) {
		if (args.length == 0) {
			return 0;
		}

		int[] lows = new int[args.length];
		int[] highs = new int[args.length];

		lows[0] = args[0];
		for(int i = 0; i < args.length; i++) {
			if (i - 1 >= 0) {
				lows[i] = Math.max(args[i], lows[i-1]);
			}
		}

		highs[args.length-1] = args[args.length-1];
		for(int i = args.length - 1; i >= 0; i -= 1) {
			if (i + 1 < args.length) {
				highs[i] = Math.max(args[i], highs[i+1]);
			}
		}

		int maxVol = 0;

		for(int i = 0; i < args.length; i++) {
			int minHeight = Math.min(lows[i], highs[i]);
			if (minHeight - args[i] > 0) {
				maxVol += minHeight - args[i];
			}
		}
		return maxVol;
	}

	private static int barGraphNaive(int[] args) {
		int max = 0;
		for(int i = 0; i < args.length; i++) {
			int lowMax = findMax(args, 0, i);
			int highMax = findMax(args, i, args.length);
			int height = Math.min(lowMax, highMax);
			max += (height - args[i] > 0) ? height - args[i] : 0;
		}
		return max;
	}

	private static int findMax(int[] args, int low, int hi) {
		int max = 0;
		for(int i = low; i < hi; i++) {
			if (args[i] > max) {
				max = args[i];
			}
		}
		return max;
	}

	public static int maxBarGraphVolume(int[] args) {
		int currentHeight = args[0];
		int maxVolumeSoFar = 0;
		Stack<Integer> currentTrough = new Stack<>();
		for (int i = 0; i < args.length; i++) {
			if (args[i] < currentHeight) {
				int difference = currentHeight - args[i];
				currentHeight -= difference;
				currentTrough.push(difference);
			} else if (args[i] > currentHeight) {
				int difference = args[i] - currentHeight;
				currentHeight += difference;
				int volumeAddedHeight = 0;
				int horiz = 0;
				while (volumeAddedHeight < difference && !currentTrough.isEmpty()) {
					Integer pop = currentTrough.pop();
					volumeAddedHeight += pop;
					if (volumeAddedHeight > difference) {
						maxVolumeSoFar += difference;
					} else {
						maxVolumeSoFar += pop * (horiz + 1);
						horiz += 1;
					}
				}
			}
		}
		return maxVolumeSoFar;
	}


	public static void main(String...args) {
		int[] increase = {2, 3, 4, 5};
		System.out.println(maxBarGraphVolume(increase) + ", " + barGraphVolume(increase));
		int[] decrease = {5, 4, 3, 2};
		System.out.println(maxBarGraphVolume(decrease) + ", " + barGraphVolume(decrease));
		int[] alternating = {5, 1, 5, 1};
		System.out.println(maxBarGraphVolume(alternating) + ", " + barGraphVolume(alternating));
		int[] twoDips = {5, 1, 10, 1, 3};
		System.out.println(maxBarGraphVolume(twoDips) + ", " + barGraphVolume(twoDips));
		int[] twoDipsWithFlat = {5, 5, 1, 10, 1, 3};
		System.out.println(maxBarGraphVolume(twoDipsWithFlat) + ", " + barGraphVolume(twoDipsWithFlat));
		int[] oneBigDip = {2, 8, 5, 2, 9, 3};
		System.out.println(maxBarGraphVolume(oneBigDip) + ", " + barGraphVolume(oneBigDip));
	}
}
