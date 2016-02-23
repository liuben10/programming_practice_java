/*
 * A robot starts at cell (0, 0) of a grid with m rows and n columns. It can move to the left, right, up, and down, and moves one cell for a step. It cannot enter cells where the digit sum of the row index and column index are greater than a given k.
For example, when k is 18, the robot can reach cell (35, 37) because 3+5+3+7=18. However, it cannot reach cell (35, 38) because 3+5+3+8=19 and that is greater than k. How many cells can the robot reach?
 * 
 */

package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RobotMove {
	
	public static void main(String...args) {
		Integer[][] grid = new Integer[4][4];
		System.out.println(getMovableCells(grid, 3));
	}
	
	private static int sumOfDigits(Integer value) {
		String toSum = String.valueOf(value);
		int sum = 0;
		for (int i = 0 ; i < toSum.length(); i++) {
			sum += Integer.valueOf(toSum.substring(i, i+1));
		}
		return sum;
	}
	
	
	private static Integer sumOfDigits(Integer row, Integer col) {
		return sumOfDigits(row) + sumOfDigits(col);
	}
	
	public static Integer getMovableCells(Integer[][] grid, int k) {
		Set<Pair> visited = new HashSet<Pair>();
		Stack<Pair> fringe = new Stack<Pair>();
		Integer rows = grid.length;
		Integer cols = grid[0].length;
		fringe.add(new Pair(0, 0));
		while (!fringe.isEmpty()) {
			Pair coordinate = fringe.pop();
			Integer row = coordinate.a;
			Integer col = coordinate.b;
			visited.add(new Pair(row, col));
			List<Pair> successors = new ArrayList<Pair>();
			if (row+1 < rows) {
				successors.add(new Pair(row+1, col));
			}
			if (col+1 < cols) {
				successors.add(new Pair(row, col+1));
			}
			if (col-1 >= 0) {
				successors.add(new Pair(row, col-1));
			}
			if (row-1 >= 0) {
				successors.add(new Pair(row-1, col));
			}
			for (Pair pair : successors) {
				if (!visited.contains(pair) && !fringe.contains(pair) && sumOfDigits(pair.a, pair.b) <= k) {
					fringe.push(pair);
					
				}
			}
		}
		System.out.println(visited);
		return visited.size();
	}
}



class Pair {
	public Pair(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "Pair [a=" + a + ", b=" + b + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

	Integer a;
	Integer b;
	
}