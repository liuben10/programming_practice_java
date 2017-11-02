package dynamic;

import java.util.Stack;

/**
 */
public class AbsentSubstrings {

	static class Wrapper {
		int absent;
		String path;

		public Wrapper(int acount, String path) {
			this.absent = acount;
			this.path = path;
		}
	}


	private static int howManyOkRecurs(int target) {


		return 0;
	}

	private static int howManyOkGraph(int target) {
		int total = 0;

		final String states = "AOL";

		Stack<Wrapper> visiting = new Stack<>();

		visiting.add(new Wrapper(0, ""));
		while(!visiting.isEmpty()) {
			Wrapper cur = visiting.pop();

			if (cur.path.length() == target) {
				total += 1;
			} else {
				for (int i = 0; i < states.length(); i++) {
					char pres = states.charAt(i);
					if ((pres == 'A' && cur.absent < 1) ||
							(pres == 'L' && notThreeConsecutive(cur.path)) ||
							(pres != 'A' && pres != 'L')) {
						if (pres == 'A') {
							visiting.add(new Wrapper(1, cur.path + pres));
						} else {
							visiting.add(new Wrapper(0, cur.path + pres));
						}
					}
				}
			}
		}

		return total;
	}

	private static boolean notThreeConsecutive(String path) {
		return path.length() <= 2 || path.length() > 2 && (!path.substring(path.length()-3).equals("LL"));
	}


	/**
	 *
	 * AA
	 * AO
	 * AL
	 * OA
	 * OO
	 * OL
	 * LA
	 * LO
	 * LL
	 *
	 * @param args
	 */
	public static void main(String...args) {
		System.out.println(howManyOkGraph(3));
	}
}
