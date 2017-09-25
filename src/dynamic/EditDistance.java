package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditDistance {
	
	public static void main(String...args) {
		System.out.println(editDistance("Saturday", "Sunday"));
	}
	
	public static int editDistance(String a, String b) {
		int[][] distances = new int[b.length()][a.length()];
		int editDistance = getEditDistance(a, b, distances);
		return editDistance;
	}

	private static int getEditDistance(String a, String b, int[][] distances) {
		for (int i = 0; i < b.length(); ++i) {
			distances[i][0] = i;
		}
		for (int j = 0 ; j < a.length(); ++j) {
			distances[0][j] = j;
		}
		for(int i = 1; i < b.length(); ++i) {
			for (int j = 1; j < a.length(); ++j) {
				if (a.charAt(j) == b.charAt(i)) {
					distances[i][j] = distances[i-1][j-1];
				} else {
					int deletion = distances[i][j-1] + 1;
					int insertion = distances[i-1][j] + 1;
					int substitution = distances[i-1][j-1] + 1;
					List<Integer> collection = new ArrayList<>();
					collection.add(deletion);
					collection.add(insertion);
					collection.add(substitution);
					distances[i][j] = Collections.min(collection);
				}
			}
		}
		return distances[b.length()-1][a.length()-1];
	}

}
