package array;

import java.util.PriorityQueue;

/**
 * Created by liuben10 on 3/13/17.
 */
public class RunningMedian {


	private static double findRunningMedian(int ... args) {
		PriorityQueue<Double> upperHalf = new PriorityQueue<>();
		PriorityQueue<Double> lowerHalf = new PriorityQueue<>((o1, o2) -> -1 * Double.compare(o1, o2));
		double currentMedian = 0;
		for (int i = 0; i < args.length; i++) {
			double nextIn = (double) args[i];
			if (lowerHalf.isEmpty()) {
				lowerHalf.add(nextIn);
				currentMedian = nextIn;
				continue;
			}
			if (upperHalf.isEmpty()) {
				upperHalf.add(nextIn);
				currentMedian = (lowerHalf.peek() + nextIn) / 2;
				continue;
			}

			double upperMin = upperHalf.peek();

			if (nextIn > upperMin) {
				upperHalf.add(nextIn);
				if (upperHalf.size() > lowerHalf.size()) {
					final Double removed = upperHalf.remove();
					lowerHalf.add(removed);
				}
			} else {
				if (lowerHalf.size() > upperHalf.size()) {
					final Double remove = lowerHalf.remove();
					upperHalf.add(remove);
				}
				lowerHalf.add(nextIn);
			}

			if (i % 2 == 1) {
				currentMedian = (lowerHalf.peek() + upperHalf.peek()) / 2;
			} else {
				currentMedian = lowerHalf.peek();
			}

		}
		return currentMedian;
	}

	public static void main(String...args) {
		int[] testIn = {3, 2, 4, 8, 10, 5};

		System.out.println(findRunningMedian(testIn));
	}

}
