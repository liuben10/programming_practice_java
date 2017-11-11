package array;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 */
public class MostInMeetingRoom {

	@AllArgsConstructor
	static class Interval {
		int low;
		int hi;
	}

	static Interval of(int low, int hi) {
		return new Interval(low, hi);
	}

	public static int maxInRoom(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(i -> i.low));

		int[] hours = new int[24];

		for (Interval interval : intervals) {
			hours[interval.low] += 1;
			hours[interval.hi] -= 1;
		}

		int inRoomSoFar = 0;
		int max = 0;
		for (int i = 0; i < hours.length; i++) {
			inRoomSoFar += hours[i];
			if (inRoomSoFar > max) {
				max = inRoomSoFar;
			}
		}

		return max;
	}


	public static void main(String...args) {
		List<Interval> intervals = new ArrayList<>(
				Arrays.asList(
						of(1, 4),
						of(4, 7),
						of(5, 8),
						of(9, 10)
				)
		);

		System.out.println(maxInRoom(intervals));
	}
}
