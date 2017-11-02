package dynamic;

/**
 */
public class FastFib {


	public static int fib(int n) {
		int f1 = 1;
		int f2;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (i <= 1) {
				sum = 1;
			} else {
				int tmp = f1;
				f1 = sum;
				f2 = tmp;
				sum = f1 + f2;
			}
		}
		
		return sum;
	}

	public static void main(String...args) {

		for (int i = 0; i < 10; i++) {
			System.out.println(fib(i));
		}
	}
}
