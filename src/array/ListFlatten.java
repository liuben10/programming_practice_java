package array;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ListFlatten {

	public static List<Integer> flatten(List<Object> unflattend) {
		List<Integer> flattened = new ArrayList<>();
		for (Object o : unflattend) {
			if (o instanceof List) {
				List<Integer> subflattened = flatten((List<Object>) o);
				flattened.addAll(subflattened);
			} else {
				flattened.add((Integer) o);
			}
		}
		return flattened;
	}


	public static void main(String...args) {

	}
}
