package dynamic;

/**
 * Created by benjaminliu on 9/27/17.
 */
public class IntegerPartition {

	private static int countPartitions(int n) {
		int[] table = new int[n+1];

		table[0] = 1;

		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				table[j] += table[j-i];
			}
		}

		return table[n];
	}

	public static void main(String...args) {
		System.out.println(countPartitions(6));
	}
}
