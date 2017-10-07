package dynamic;

/**
 * Created by liuben10 on 9/5/17.
 */
public class MagicIndex {

	private static boolean magicIndex(int[] inputs) {
		return magicIndexHelper(inputs, 0, inputs.length - 1);

	}

	private static boolean magicIndexHelper(int[] inputs, int start, int end) {
		while(start < end) {
			System.out.println(start + ", " + end);
			int mid = (start + end) / 2;
			if (inputs[mid] == mid) {
				return true;
			} else {
				if (inputs[mid] > mid) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
		}
		return false;
	}

	public static void main(String...args) {
		System.out.println(magicIndex(new int[]{-5, 0, 3, 5, 11}));
	}
}
