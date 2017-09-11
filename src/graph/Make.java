package graph;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by benjaminliu on 8/29/17.
 */
public class Make {

	private static List<String> make(final Set<String> nodes, final Set<List<String>> dependencies) {
		final Map<String, Collection<String>> graph = makeDependencyGraph(nodes, dependencies);

		final Set<String> stillNeedToBuild = new HashSet<>(nodes);
		List<String> buildOrder = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		while(!stillNeedToBuild.isEmpty()) {
			final String src = stillNeedToBuild.iterator().next();
			Stack<String> fringe = new Stack<>();
			fringe.add(src);
			Set<String> currentlyVisiting = new HashSet<>();
			while(!fringe.isEmpty()) {
				final String building = fringe.pop();
				currentlyVisiting.add(building);
				final Collection<String> successors = graph.get(building);
				if (successors.isEmpty() || visited.containsAll(successors)) {
					buildOrder.add(building);
					stillNeedToBuild.remove(building);
					visited.add(building);
				} else {
					for (String successor : successors) {
						if (currentlyVisiting.contains(successor)) {
							throw new RuntimeException("Cycles are not allowed");
						}
						fringe.add(successor);
					}
				}
			}
		}
		return buildOrder;

	}

	private static Map<String, Collection<String>> makeDependencyGraph(final Set<String> nodes, final Set<List<String>> dependencies) {
		final ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
		for (List<String> dependency : dependencies) {
			multimap.put(dependency.get(1), dependency.get(0));
		}
		final HashMap<String, Collection<String>> dependGraph = new HashMap<>(multimap.asMap());
		for (String node : nodes) {
			if (!dependGraph.containsKey(node)) {
				dependGraph.put(node, new ArrayList<>());
			}
		}
		return dependGraph;
	}

	public static void main(String...args) {
		final Set<String> nodes = ImmutableSet.of("a", "b", "c", "d", "e", "f");
		final Set<List<String>> dependencies = ImmutableSet.of(
				Arrays.asList("f", "b"),
				Arrays.asList("b", "c"),
				Arrays.asList("c", "a"),
				Arrays.asList("d", "e")
		);
		System.out.println(make(nodes, dependencies));
	}
}
