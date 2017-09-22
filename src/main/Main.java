package main;

import java.util.Arrays;

/**
 * Created by liuben10 on 3/13/17.
 */
public class Main {

	public static void main(String...args) {
		System.out.println(Arrays.toString(oddNumbers(1, 5)));
	}


	static int[] oddNumbers(int l, int r) {
		int[] result = new int[(r - l) / 2];
		int idx = 0;
		for(int i = l; i < r; i++) {
			if (i % 2 != 0) {
				result[idx] = i;
			}
		}
		return result;
	}
}
