package main;

/**
 * Created by liuben10 on 9/4/16.
 */
public class Fib {
	public static void main(String...args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fastfib(i));
		}
	}

	public static int fib(final int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}


	public static int fastfib(final int n) {
		if (n <= 1) {
			return 1;
		}
		int prev;
		int cur = 1;
		int sum = 2;
		for(int i = 0; i < n; i++) {
			if (i > 1) {
				int tmp = cur;
				cur = sum;
				prev = tmp;
				sum = cur + prev;
			}
		}
		return sum;
	}
}
