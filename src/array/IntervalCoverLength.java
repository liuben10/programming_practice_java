package array;

import java.util.*;

/**
 */
public class IntervalCoverLength {

	/**
	 * Interval object with some stuff to make it more easily readible when debugging.
	 */
	static class Interval {
		int low;
		int hi;

		@Override
		public String toString() {
			return "{" + low +
					", " + hi + "}";
		}

		public Interval(int low, int hi) {
			this.low = low;
			this.hi = hi;
		}

		public int amountCovered() {
			return this.hi - this.low + 1;
		}

		public static Interval copy(Interval src) {
			return new Interval(src.low, src.hi);
		}
	}

	/**
	 * Wrapper class to capture the result of a single merging operation.
	 */
	static class Wrapper {
		int coverLength;
		PriorityQueue<Interval> covered;

		public Wrapper(int covered, PriorityQueue<Interval> unmerged) {
			this.coverLength = covered;
			this.covered = unmerged;
		}
	}

	/**
	 * Primary loop that goes through the intervals and actually merges a single interval at a time.
	 * @param intervals
	 * @return
	 */
	public static List<Integer> countCoverLength(Iterator<Interval> intervals) {
		PriorityQueue<Interval> covered = new PriorityQueue<>(Comparator.comparingInt(i -> i.low));
		List<Integer> runningTotal = new ArrayList<>();

		while(intervals.hasNext()) {
			Interval cur = intervals.next();

			Wrapper wrapper = mergeIntervals(covered, cur);

			int totalAmountCovered = runningTotal.size() > 0 ? runningTotal.get(runningTotal.size() - 1) : 0;

			runningTotal.add(totalAmountCovered + wrapper.coverLength);
			covered = wrapper.covered;
		}

		return runningTotal;
	}

	/**
	 * The primary logic which basically solves the problem of merging an interval to an existing collection of intervals
	 * @param covered
	 * @param inserting The original interval that I want to insert
	 * @return
	 */
	private static Wrapper mergeIntervals(PriorityQueue<Interval> covered, Interval inserting) {
		Interval toIns = Interval.copy(inserting);  //This is the interval that I am actually going to insert (could be modified based on what intervals it overlaps).

		PriorityQueue<Interval> merged = new PriorityQueue<>(covered.comparator());
		int newLengthUnmerged = inserting.amountCovered();
		/**
		 * The for loop goes through each interval and determines what interval is the resultant interval that should
		 * actually be added.
		 */
		for (Interval interval : covered) {
			/**
			 * If the interval is completely not covered, then just add it. Duh...
			 */
			if (toIns.low > interval.hi || toIns.hi < interval.low) {
				merged.add(interval);
			} else {
				/**
				 * If the interval that I am inserting overlaps with the top part of the interval,
				 * then my new lower bound should be either the lower bound of the current interval,
				 * or the interval that I am inserting
				 */
				if (toIns.low < interval.hi) {
					toIns.low = Math.min(interval.low, toIns.low);
					if (toIns.low == interval.low) { //The amount that is actually going to be covered is going to be deducted due to some amount having been covered already.
						newLengthUnmerged -= (Math.abs(interval.hi - inserting.low) + 1);
					}
				}
				/**
				 * If the interval that I am inserting overlaps with part of the bottom interval,
				 * I set my interval that I am inserting to now have an upper bound same as the
				 * top interval to insert.
				 */
				if (toIns.hi > interval.low) {
					toIns.hi = Math.max(interval.hi, toIns.hi);
					if (toIns.hi == interval.hi) {
						newLengthUnmerged -= (Math.abs(inserting.hi - interval.low) + 1);
					}
				}
			}
		}

		if (newLengthUnmerged < 0) { //Floor at 0
			newLengthUnmerged = 0;
		}

		merged.add(toIns);

		return new Wrapper(newLengthUnmerged, merged);
	}

	/**
	 * Simple routine that shortens the amount of typing needed.
	 * @param low
	 * @param hi
	 * @return
	 */
	public static Interval of(int low, int hi) {
		return new Interval(low,hi);
	}

	/**
	 * Main function goes through the example provided by the problem.
	 * @param args
	 */
	public static void main(String...args) {

		List<Interval> intervals = Arrays.asList(
				of(1, 2),
				of(4, 6),
				of(5, 7),
				of(3, 5),
				of(9, 11)
		);

		System.out.println(countCoverLength(intervals.iterator()));


		List<Interval> intervals2 = Arrays.asList(
				of(1, 5),
				of(3, 4)
		);

		System.out.println(countCoverLength(intervals2.iterator()));

		List<Interval> intervals3 = Arrays.asList(
				of(1, 9),
				of(2, 11)
		);

		System.out.println(countCoverLength(intervals3.iterator()));

		List<Interval> intervals4 = Arrays.asList(
				of(5, 9),
				of(2, 7)
		);

		System.out.println(countCoverLength(intervals4.iterator()));
	}
}
