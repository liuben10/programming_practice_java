package array;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

/**
 */
public class TVTime {

	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@ToString
	static class Interval {
		int low;
		int hi;

		public List<Interval> merge(Interval other) {
			if (this.low > other.hi || this.hi < other.low) {
				return Arrays.asList(this, other);
			} else {
				Interval merged = new Interval();
				int low = Math.min(this.low, other.low);
				int hi = Math.max(this.hi, other.hi);
				merged.low = low;
				merged.hi = hi;
				return Arrays.asList(merged);
			}
		}

		public int dist() {
			return this.hi - this.low;
		}
	}


	public static int maxTime(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return 0;
		}

		Collections.sort(intervals, Comparator.comparingInt(i -> i.low));

		List<Interval> fullyMerged = new ArrayList<>();
		fullyMerged.add(intervals.get(0));

		for (Interval interval : intervals) {
			Interval lastInterval = fullyMerged.get(fullyMerged.size() - 1);
			List<Interval> mergedIntervals = lastInterval.merge(interval);
			if (mergedIntervals.size() == 1) {
				fullyMerged.remove(fullyMerged.size() - 1);
				fullyMerged.addAll(mergedIntervals);
			} else {
				fullyMerged.add(mergedIntervals.get(1));
			}
		}

		int sum = 0;
		for (Interval interval : fullyMerged) {
			sum += interval.dist();
		}

		return sum;
	}


	public static void main(String...args) {
		List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(6, 8), new Interval(2, 4), new Interval(7, 9), new Interval(10, 15));
		System.out.println(maxTime(intervals));
	}
}
