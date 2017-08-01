package main;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuben10 on 3/13/17.
 */
public class Main {

	public static void main(String...args) {
		for (int x = -100; x < 100; x++) {
			for (int y = -100; y < 100; y++) {
//				for (int z = 0; z < 100000; z++) {
					float solution = evaluate(x, y);
					if (solution == 20f) {
						System.out.println("x=" + x + ", y=" + y);
						System.out.println("solution");
						break;
					}
//				}
			}
		}
	}

	private static boolean containsTwoZero(List<Float> floats) {
		int count = 0;
		for (Float aFloat : floats) {
			if (aFloat == 0) {
				count += 1;
			}
		}
		return count >= 2;
	}

	private static float evaluate(float x, float y) {
		List<Float> floats = Arrays.asList(x, y);
		if (containsTwoZero(floats)) {
			return 0f;
		}
		return 2 * x * x + 3 * y;
	}
}
