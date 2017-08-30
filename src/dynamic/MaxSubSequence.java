package dynamic;

public class MaxSubSequence {
	
	public static void main(String...args) {
		Integer[] testIn = new Integer[]{4, 3, -1, 2};
		System.out.println(maxSum(testIn));
	}

	public static int maxSum(Integer[] input) {
		Integer[] subproblems = new Integer[input.length+1];
		for(int i = 0 ; i < subproblems.length; i++) {
			subproblems[i] = 0;
		}
		for(int i = 0; i < input.length; i++) {
			int prevsubproblem = subproblems[i];
			subproblems[i+1] = Math.max(prevsubproblem + input[i], input[i]);
		}
		return subproblems[subproblems.length-1];
	}
}
