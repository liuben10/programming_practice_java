package csp;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by benjaminliu on 9/21/17.
 */
public class MapColoring {

	private final Map<String, List<String>> provinceMap;

	private Set<String> colors = new HashSet<>();

	private Map<String, Set<String>> domains = new HashMap<>();

	private List<Constraint> constraints = new ArrayList<>();

	public MapColoring(Map<String, List<String>> provinces, Set<String> colors) {
		this.colors = colors;
		this.provinceMap = provinces;
		for (String province : provinces.keySet()) {
			domains.put(province, new HashSet<>(colors));
			constraints.add(new Constraint(province, provinces.get(province)));
		}
	}

	public Map<String, String> getAssignment() {
		Map<String, String> assignments = new HashMap<>();
		return getAssignmentHelper(assignments, domains.keySet().iterator().next());
	}

	private Map<String, String> getAssignmentHelper(final Map<String, String> assignments, final String province) {
		final Set<String> difference = new HashSet<>(domains.keySet());
		difference.removeAll(assignments.keySet());
		if (!assignments.isEmpty() && difference.isEmpty()) {
			return assignments;
		} else {
			for(String color : colors) {
				assignments.put(province, color);
				if (passesConstraints(assignments)) {
					difference.remove(province);
					if (!difference.isEmpty()) {
						final String next = difference.iterator().next();
						Map<String, String> childAssignments = getAssignmentHelper(assignments, next);
						if (childAssignments == null) {
							continue;
						} else {
							return childAssignments;
						}
					} else {
						return assignments;
					}
				} else {
					continue;
				}
			}
			return null;
		}
	}

	private boolean passesConstraints(final Map<String, String> assignments) {
		for (Constraint constraint : constraints) {
			if (!constraint.evaluate(assignments)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String...args) {
		Map<String, List<String>> provinces = ImmutableMap.of("A", Arrays.asList("B", "C"), "B", Arrays.asList("A", "D"), "C", newArrayList(), "D", newArrayList("A"));
		Set<String> colors = ImmutableSet.of("BLACK", "WHITE", "GREEN");
		final MapColoring mapColoring = new MapColoring(provinces, colors);
		System.out.println(mapColoring.getAssignment());
	}

	private class Constraint {

		String province;
		List<String> neighboringProvinces;


		Constraint(String province, List<String> neighboringProvinces) {
			this.province = province;
			this.neighboringProvinces = neighboringProvinces;
		}

		boolean evaluate(Map<String, String> assignment) {
			if (assignment.containsKey(province)) {
				final String colorAssignment = assignment.get(province);
				for (String neighboringProvince : neighboringProvinces) {
					if (assignment.containsKey(neighboringProvince)) {
						if (colorAssignment.equals(assignment.get(neighboringProvince))) {
							return false;
						}
					}
				}
			}
			return true;
		}
	}
}
