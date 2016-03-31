package array;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
	
	
	public static void main(String...args) {
		List<Integer> src = new ArrayList<Integer>();
		List<Integer> dest = new ArrayList<Integer>();
		List<Integer> spare = new ArrayList<Integer>();
		src.add(3);
		src.add(2);
		src.add(1);
		towersOfHanoi(src, dest, spare);
		System.out.println(src + ", " + dest + ", " + spare);
	}
	
	public static void move(List<Integer> src, List<Integer> dest) {
		Integer head = src.remove(0);
		dest.add(head);
	}
	
	public static void towersOfHanoi(List<Integer> src, List<Integer> dest, List<Integer> spare) {
		if (src.size() == 1) {
			move(src, dest);
		} else {
			towersOfHanoi(src.subList(1, src.size()), spare, dest);
			move(src, dest);
			towersOfHanoi(spare, dest, src);
		}
	}

}
