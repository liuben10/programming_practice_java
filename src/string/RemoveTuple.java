package string;

/**
 */
public class RemoveTuple {

	static class Tuple {

		boolean res;
		int idx;

		@Override
		public String toString() {
			return "Tuple{" +
					"res=" + res +
					", idx=" + idx +
					'}';
		}

		public Tuple(boolean res, int idx) {
			this.res = res;
			this.idx = idx;
		}
	}

	static Tuple isSuperReduced(String s) {
		if (s.length() == 0) {
			return new Tuple(true, 0);
		}
		char[] chars = s.toCharArray();
		char prev = chars[0];
		for(int i = 1; i < chars.length; i++) {
			if (chars[i] == prev) {
				return new Tuple(false, i-1);
			} else {
				prev = chars[i];
			}
		}
		return new Tuple(true, 0);
	}

	static String super_reduced_string(String s){
		Tuple tup = isSuperReduced(s);
		if (tup.res) {
			return s;
		} else {
			int removeIdx = tup.idx;
			String add = "";
			if (removeIdx+2 != s.length()) {
				add = s.substring(removeIdx+2);
			}
			return super_reduced_string(s.substring(0, removeIdx) + add);
		}
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s = in.next();
		String result = super_reduced_string("aa");
		System.out.println(result);
	}
}

