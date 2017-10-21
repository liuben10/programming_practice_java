package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class MaxInRoom {

	static class Person {
		int start;
		int end;

		public Person(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int maxInRooms(List<List<Integer>> intervals) {

		List<List<Integer>> meetingRoom = new ArrayList<>();
		int curMax = Integer.MIN_VALUE;
		for (int i = 0; i < 24; i++) {
			for (List<Integer> interval : intervals) {
				if (interval.get(0) == i) {
					meetingRoom.add(interval);
				} else if (interval.get(1) == i) {
					meetingRoom.remove(interval);
				}
			}
			if (meetingRoom.size() > curMax) {
				curMax = meetingRoom.size();
			}
		}

		return curMax;
	}

	public static void main(String...args) {
		System.out.println(maxInRooms(Arrays.asList(
			Arrays.asList(1, 4),
			Arrays.asList(3, 5),
			Arrays.asList(2, 7),
			Arrays.asList(5, 10)
		)));
	}
}
