package array;

/**
 * Created by liuben10 on 9/25/17.
 */
public class ExcelNameToNumber {
	public static String ALPH = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";


	static int excelStringToNum(String excel) {
		int sum = 0;
		int cnt = 0;
		for (int i = excel.length()-1; i >= 0; i--) {
			char curChar = excel.charAt(i);
			int numVal = ALPH.lastIndexOf(String.valueOf(curChar).toUpperCase());
			sum = sum + numVal * (int)Math.pow(26, cnt);
			cnt += 1;
		}
		return sum;
	}

	public static void main(String...args) {
		System.out.println(excelStringToNum("AAA"));
	}

}
