package main;

/**
 * Created by liuben10 on 9/4/16.
 */
public class Fib {
	public static void main(String...args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fib(i));
		}
	}

	public static int fib(final int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
}
