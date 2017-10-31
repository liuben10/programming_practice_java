package array;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
	
	
	public static void main(String...args) {
		List<Integer> src = new ArrayList<>();
		List<Integer> dest = new ArrayList<>();
		List<Integer> spare = new ArrayList<>();
		src.add(3);
		src.add(2);
		src.add(1);
//		towersOfHanoi(src, dest, spare);
		towersOfHanoiIterative(src, dest, spare);
		System.out.println(src + ", " + dest + ", " + spare);
	}

	public static void towersOfHanoiIterative(List<Integer> src, List<Integer> dest, List<Integer> spare) {
		int numMovs = (int) (Math.pow(2, src.size()) - 1);

		List<Integer> srcPt = src;
		List<Integer> destPt = dest;
		List<Integer> sparePt = spare;
		int cnt = 0;
		while(cnt < numMovs) {
			if (cnt % 3 == 0) {
				moveEnd(srcPt, destPt);
			} else if ( cnt % 3 == 1) {
				moveEnd(srcPt, sparePt);
			} else if (cnt % 3 == 2) {
				moveEnd(destPt, sparePt);
				moveEnd(srcPt, destPt);
				List<Integer> tmp = srcPt;
				srcPt = sparePt;
				sparePt = tmp;
			}
			cnt += 1;
		}
	}

	public static void moveEnd(List<Integer> src, List<Integer> dest) {
		Integer toMove = src.remove(src.size() - 1);
		dest.add(toMove);
	}
	
	public static void move(List<Integer> src, List<Integer> dest) {
		List<Integer> originalSrc = new ArrayList<>(src);
		Integer head = src.remove(0);
		System.out.println("Moving " + head + " from src=" + originalSrc + " to " + dest);
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
