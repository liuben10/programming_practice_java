package dynamic;

import java.util.Arrays;

/**
 * Created by liuben10 on 9/28/17.
 */
public class IntegerPartition {

	public static void partition(int n, int max, String prefix) {
		System.out.println("partition subproblem: " + n + ", " + max + ", " + prefix);
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			partition(n-i, i, prefix + " " + i);
		}
	}


	public static void partitionDynamic(int n, int max) {
		int[][] V = new int[n+1][max];
//		int[][] keeps = new int[n+1][max];
//
		V[0][0] = 1;
		V[0][1] = 1;
		for(int i = 0; i < max; i++) {
			for(int j = 0; j <= n; j++) {
				if (i > j) {
					V[j][i] = (i-1 >= 0) ? V[j][i-1] : 0;

					for (int[] ints : V) {
						System.out.println(Arrays.toString(ints));
					}
					System.out.println("=====");
				} else {

					for (int[] ints : V) {
						System.out.println(Arrays.toString(ints));
					}
					System.out.println("=====");
				}

			}
		}
	}


	public static void main(String...args) {
//		partition(10, 4, "");
		partitionDynamic(4, 2);
	}
}
