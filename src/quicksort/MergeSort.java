package quicksort;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String...args) {
		System.out.println(Arrays.toString(mergeSort(new int[]{5,3,4,8,12,33,11,14,9,8})));
	}
	
	
	public static int[] mergeSort(int[] input) {
		if (input.length == 1) {
			return input;
		} else {
			int midPoint = input.length / 2;
			int[] lowerHalf = new int[(int) Math.ceil(input.length / 2)];
			int[] upperHalf = new int[input.length / 2];
			System.arraycopy(input, 0, lowerHalf, 0, (int) Math.ceil(input.length / 2));
			System.arraycopy(input, (int) Math.ceil(input.length / 2), upperHalf, 0, input.length / 2);
			return merge(mergeSort(lowerHalf), mergeSort(upperHalf));
		}
	}
	
	
	public static int[] merge(int[] a, int[] b) {
		int[] newArr = new int[a.length + b.length];
		int aPnt = 0;
		int bPnt = 0;
		int newArrPnt = 0;
		while (aPnt < a.length || bPnt < b.length) {
			if (aPnt < a.length && bPnt < b.length) {
				if (a[aPnt] < b[bPnt]) {
					newArr[newArrPnt] = a[aPnt];
					aPnt++;
				} else {
					newArr[newArrPnt] = b[bPnt];
					bPnt++;
				}
			} else if (aPnt >= a.length) {
				newArr[newArrPnt] = b[bPnt];
				bPnt++;
			} else {
				newArr[newArrPnt] = a[aPnt];
				aPnt++;
			}
			newArrPnt++;
		}
		return newArr;
	}

}
