package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class FindVolume {

	public static void main(String...args) {
		int[] testIn = {4, 2, 3};
		int expected = 1;
		int[] testIn2 = {4, 2, 1, 5};
		int expected2 = 5;
		int[] testIn3 = {4, 2, 1};
		int expected3 = 0;
		int[] testIn4 = {4, 5};
		int expected4 = 0;
		int[] testIn5 = {6, 5, 4, 3, 4, 5, 6};
		int expected5 = 9;
		int[] testIn6 = {6, 5, 4, 3, 4, 5, 3, 4};
		int expected6 = 5;
		System.out.println(findVolume(testIn) + "=" + expected);
		System.out.println(findVolume(testIn2) + "=" + expected2);
		System.out.println(findVolume(testIn3) + "=" + expected3);
		System.out.println(findVolume(testIn4) + "=" + expected4);
		System.out.println(findVolume(testIn5) + "=" + expected5);
		System.out.println(findVolume(testIn6) + "=" + expected6);

	}

	private static int findVolume(int[] testIn) {
		return findVolumeNaive(testIn);
	}
	
	private static int findMax(int[] testIn, int start, int end) {
		int max = testIn[start];
		if (start == end) {
			return Integer.MIN_VALUE;
		}
		for(int i = start; i < end; i++) {
			if (testIn[i] > max) {
				max = testIn[i];
			}
		}
		return max;
	}
	
	private static int findVolumeNaive(int[] testIn) {
		int volSoFar = 0;
		for (int i = 0; i < testIn.length; i++) {
			int lowerHalfMax = findMax(testIn, 0, i);
			int upperHalfMax = findMax(testIn, i, testIn.length);
			int minHeight = Math.min(lowerHalfMax, upperHalfMax);
			if (minHeight > testIn[i]) {
				volSoFar += minHeight - testIn[i];
			}
		}
		return volSoFar;
	}
	
	
}
