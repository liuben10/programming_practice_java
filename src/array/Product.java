package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class Product {

	public static List<List<String>> product(List<String> a, List<String> b) {
		List<List<String>> product = new ArrayList<>();

		for(int i = 0; i < a.size(); i++) {

			for(int j = 0; j < b.size(); j++) {
				product.add(new ArrayList<>(Arrays.asList(a.get(i), b.get(j))));
			}
		}

		return product;
	}

	public static void main(String...args) {
		System.out.println(product(new ArrayList<>(Arrays.asList("a", "b")), new ArrayList<>(Arrays.asList("d", "e", "f"))));
	}
}
