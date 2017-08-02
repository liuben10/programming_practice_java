package array;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StockQuestion {

	public static int findMaxOneTransaction(int[] stockPrices) {
		int maxSoFar = 0;
		int low = stockPrices[0];
		int high = stockPrices[0];
		for(int i = 0; i < stockPrices.length; i++) {
			if (stockPrices[i] < low) {
				low = stockPrices[i];
			}
			if (stockPrices[i] > high) {
				high = stockPrices[i];
				int curMax = high - low;
				if (curMax > maxSoFar) {
					maxSoFar = curMax;
				}
			}
		}
		return maxSoFar;
	}

	public static int findMaxTwoTransaction(int[] stockPrices) {
		// int lo1 = stockPrices[0];
		// int lo2 = stockPrices[stockPrices.length - 1];
		// int hi1 = stockPrices[0];
		// int hi2 = stockPrices[stockPrices.length - 1];
		int lo1 = 0;
		int lo2 = stockPrices.length - 1;
		int hi1 = 0;
		int hi2 = stockPrices.length - 1;

		int i = 0;
		int j = stockPrices.length - 1;
		int curMax = 0;
		int curMax1 = 0;
		int maxSoFarLeft = 0;
		int maxSoFarRight = 0;

		while(hi1 < lo2 && i <= j) {
			if (stockPrices[i] < stockPrices[lo1]) {
				lo1 = i;
			}
			if (stockPrices[i] > stockPrices[hi1]) {
				hi1 = i;
				curMax = stockPrices[hi1] - stockPrices[lo1];
				if (curMax > maxSoFarLeft) {
					maxSoFarLeft = curMax;
				}
			}
			if (stockPrices[j] < stockPrices[lo2]) {
				lo2 = j;
				curMax1 = stockPrices[hi2] - stockPrices[lo2];
				if (curMax1 > maxSoFarRight) {
					maxSoFarRight = curMax1;
				}
			}
			if (stockPrices[j] > stockPrices[hi2]) {
				hi2 = j;
			}
			i++;
			j--;
		}
		System.out.println("" + lo1 + ", " + hi1 + ", " + lo2 + ", " + hi2);
		return maxSoFarLeft + maxSoFarRight;
	}


	public static int amountOfMoney(int[] stockPrices, int N) {
		return 0;
	}


	public static void main(String[] args) {
		System.out.println(findMaxTwoTransaction(new int[]{10, 11, 7, 15, 8, 17, 16}));
		System.out.println(findMaxTwoTransaction(new int[]{10, 18, 22, 25}));
		System.out.println(findMaxTwoTransaction(new int[]{420, 30, 20, 5, 2}));
		System.out.println(findMaxTwoTransaction(new int[]{3, 4, 18, 15}));
	}
}
