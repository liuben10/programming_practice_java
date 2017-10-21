package array;

/**
 */
public class FindRotated {

	public static int rotatedIdx(int[] input) {
		int low = 0;
		int hi = input.length;
		while(low < hi) {
			int mid = (low + hi) / 2;
			if (((mid+1 < input.length && input[mid] < input[mid+1]) &&
					(mid-1 >= 0 && input[mid] < input[mid-1])) ||
					(mid == input.length - 1 && input[mid-1] > input[mid]) ||
					(mid == 0 && input[mid+1] > input[mid])) {
				return mid;
			} else if (input[mid] < input[input.length - 1] && input[mid-1] < input[mid]) {
				hi = mid;
			} else {
				low = mid+1;
			}
		}
		throw new IllegalArgumentException("Could not find rotation idx");
	}

	public static void main(String...args) {
		System.out.println(rotatedIdx(new int[]{1, 2, 3, 4}));
		System.out.println(rotatedIdx(new int[]{4, 1, 2, 3}));
		System.out.println(rotatedIdx(new int[]{2, 3, 4, 1}));
	}
}
