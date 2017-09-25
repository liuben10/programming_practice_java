package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class Main {

	private static boolean sortedOrNot(List<List<Integer>> matrix) {
		if (matrix == null) {
			return true;
		}
		for (List<Integer> rows : matrix) {
			if (!isRowSorted(rows)) {
				return false;
			}
		}
		for (int i = 0; i < matrix.get(0).size(); i++) {
			if (!isColSorted(matrix, i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isColSorted(List<List<Integer>> matrix, int col) {
		if (matrix.isEmpty()) {
			return true;
		}
		int prev = matrix.get(0).get(col);
		for (int i = 0; i < matrix.size(); i++) {
			if (matrix.get(i).get(col) < prev) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRowSorted(List<Integer> rows) {
		if (rows.isEmpty()) {
			return true;
		}
		int prev = rows.get(0);
		for (Integer elem : rows) {
			if (elem < prev) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> matrix = new ArrayList<>();

		String input;
		while((input = br.readLine()) != null) {
			String[] split = input.split(" ");
			List<Integer> row = new ArrayList<>();
			for (String s : split) {
				row.add(Integer.parseInt(s));
			}
			matrix.add(row);
		}
		if (sortedOrNot(matrix)) {
			System.out.println("sorted");
		} else {
			System.out.println("not sorted");
		}
	}
}
