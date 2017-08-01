package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by benjaminliu on 9/19/16.
 */
public class AllPalindrome {

	public static void main(String...args) {
		System.out.println(solution("gekeggggget"));
	}

	public static Set<String> solution(String input) {
		Set<String> result = new HashSet<>();

		int i, j = 0;

		for (i = 0; i < input.length(); i++) {

			j = 0;
			while(i+j < input.length() && input.charAt(i) == input.charAt(i+j) ){

				result.add(input.substring(i, i+j+1));
				j++;
			}
			if(i < input.length()-1 && input.charAt(i) == input.charAt(i+1))
				result.add(input.substring(i, i+2));

			j = 0;
			while(i-j >= 0 && i+j < input.length() && input.charAt(i-j) == input.charAt(i+j) ){

				result.add(input.substring(i-j, i+j+1));
				j++;
			}

		}


		return result;
	}
}
