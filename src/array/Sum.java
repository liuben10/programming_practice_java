package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by benjaminliu on 8/2/17.
 */
public class Sum {

	public static List<Integer> sum(final List<Integer> a, final List<Integer> b) {
		int j = b.size() - 1;
		int i = a.size() - 1;
		int carry = 0;
		List<Integer> sum = new ArrayList<>();
		while(j >= 0 && i >= 0) {
			int res = a.get(i) + b.get(j) + carry;
			carry = res / 10;
			sum.add(0, res % 10);
			j--;
			i--;
		}
		if (j >= 0) {
			while (j >= 0) {
				int res = b.get(j) + carry;
				carry = res / 10;
				sum.add(0, res % 10);
				j--;
			}
		}

		if (i >= 0) {
			while (i >= 0) {
				int res = a.get(i) + carry;
				carry = res / 10;
				sum.add(0, res % 10);
				i--;
			}
		}

		if (carry != 0) {
			sum.add(0, carry);
		}
		return sum;
	}

	public static void main(String...args) {
		System.out.println(sum(Arrays.asList(9, 9), Arrays.asList(9, 9)));
	}
}
