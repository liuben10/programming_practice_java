package main;

/**
 * Created by liuben10 on 9/13/17.
 */
public class CheckPalindromeNumber {

	private static boolean isPalindrome(int n) {
		int iter = n;
		int reverse = 0;
		while (iter > 0) {
			reverse = reverse * 10 + iter % 10;
			iter /= 10;
		}
		return reverse == n;
	}

	public static void main(String...args) {
		System.out.println(isPalindrome(121));
	}
}
