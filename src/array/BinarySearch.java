package array;

public class BinarySearch {
	
	public static void main(String...args) {
		System.out.println(binSearch(new int[]{2, 4, 8, 11, 17}, 8));
	}
	
	
	public static boolean binSearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length;
		while(low < high) {
			int midpoint = (low + high) / 2;
			if (arr[midpoint] == target) {
				return true;
			} else if (arr[midpoint] > target) {
				high = midpoint;
			} else {
				low = midpoint+1;
			}
		}
		return false;
	}

}
