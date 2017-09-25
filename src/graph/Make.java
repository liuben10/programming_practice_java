package graph;

import com.google.common.collect.*;

import java.util.*;

/**
 * Created by liuben10 on 8/26/17.
 */
public class Make {

	private static List<String> make(final Set<String> projects, final Set<List<String>> dependencies) {
		Map<String, Collection<String>> dependGraph = makeDependGraph(projects, dependencies);

		Set<String> visited = new HashSet<>();
		List<String> result = new ArrayList<>();

		while(!dependGraph.isEmpty()) {
			makeHelper(dependGraph, visited, result);
		}


		return null;
	}

	private static void makeHelper(Map<String, Collection<String>> dependGraph, Set<String> visited, List<String> result) {
		for (String s : dependGraph.keySet()) {

		}
	}

	private static Map<String, Collection<String>> makeDependGraph(Set<String> projects, Set<List<String>> dependencies) {
		ArrayListMultimap<String, String> dependMapWithoutLeaves = ArrayListMultimap.create();
		for (List<String> dependency : dependencies) {
			dependMapWithoutLeaves.put(dependency.get(1), dependency.get(0));
		}
		HashMap<String, Collection<String>> dependMap = new HashMap<>(dependMapWithoutLeaves.asMap());
		for (String project : projects) {
			if (!dependMap.containsKey(project))
				dependMap.put(project, new ArrayList<>());
		}
		return dependMap;
	}

	public static void main(String...args) {
		System.out.println(make(ImmutableSet.of("a", "b", "c", "d", "e", "f"),
				ImmutableSet.of(Arrays.asList("a", "d"), Arrays.asList("f", "b"), Arrays.asList("b", "d"), Arrays.asList("f", "a"), Arrays.asList("d", "c"))));

	}
}
