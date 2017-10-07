
package main;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class SolutionCopy
{
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<List<Integer>> closestLocations(int totalCrates,
										 List<List<Integer>> allLocations,
										 int truckCapacity)
	{

		List<Integer> startingCoordinate = Arrays.asList(0, 0);
		List<List<Integer>> results = new ArrayList<>();
		while (truckCapacity > 0) {
			double minDist = Double.MAX_VALUE;
			List<Integer> minCoord = null;
			for(List<Integer> successor : allLocations) {
				double curDist = calculateDistance(startingCoordinate, successor);
				if (curDist < minDist) {
					minCoord = successor;
					minDist = curDist;
				}
			}

			startingCoordinate = minCoord;
			allLocations.remove(minCoord);
			results.add(minCoord);
			truckCapacity -= 1;
		}
		return results;
	}

	static double calculateDistance(List<Integer> src, List<Integer> dest) {
		return Math.sqrt(Math.pow(dest.get(1) - src.get(1), 2) + Math.pow(dest.get(0) - src.get(0), 2));
	}

	public static void main(String...args) {
		SolutionCopy s = new SolutionCopy();
		List<List<Integer>> result = s.closestLocations(4, new ArrayList<>(Arrays.asList(
				Arrays.asList(2, 4),
				Arrays.asList(3, 6),
				Arrays.asList(5, 3),
				Arrays.asList(2, 7)
				)),
				3);

		System.out.println(result);
		System.out.println(calculateDistance(Arrays.asList(5,3), Arrays.asList(3, 6)));
	}


	// METHOD SIGNATURE ENDS
}