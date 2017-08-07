package array;

import java.util.Stack;

/**
 * Created by liuben10 on 8/2/17.
 */
public class BarGraphVolume {

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
		System.out.println(maxBarGraphVolume(new int[]{2, 3, 4, 5}));
		System.out.println(maxBarGraphVolume(new int[]{5, 4, 3, 2}));
		System.out.println(maxBarGraphVolume(new int[]{5, 1, 5, 1}));
		System.out.println(maxBarGraphVolume(new int[]{5, 1, 10, 1, 3}));
		System.out.println(maxBarGraphVolume(new int[]{5, 5, 1, 10, 1, 3}));
		System.out.println(maxBarGraphVolume(new int[]{2, 8, 5, 2, 9, 3}));

	}
}
