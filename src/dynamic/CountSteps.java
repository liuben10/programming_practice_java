package dynamic;

/**
 * Created by liuben10 on 9/5/17.
 */
public class CountSteps {

	public static final int[] possibleSteps = {1, 2, 3};

	private int numPaths = 0;

	private void countStepsHelper(int steps) {
		if (steps == 0) {
			numPaths += 1;
		} else {
			for (int possibleStep : possibleSteps) {
				if (steps - possibleStep >= 0) {
					countStepsHelper(steps - possibleStep);
				}
			}
		}
	}

	public int countSteps(int steps) {
		countStepsHelper(steps);
		return numPaths;
	}

	public static void main(String...args) {
		CountSteps countSteps = new CountSteps();
		System.out.println(countSteps.countSteps(3));
	}
}
