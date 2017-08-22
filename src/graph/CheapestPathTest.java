package graph;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CheapestPathTest {

	public static class Edge {
		String node;
		Integer cost;

		public Edge(String destNode, Integer cost) {
			this.node = destNode;
			this.cost = cost;
		}

		@Override
		public int hashCode() {
			return Arrays.asList(node, cost).hashCode();
		}

		@Override
		public boolean equals(Object o) {
			return o != null && o instanceof Edge && hashCode() == o.hashCode();
		}
	}

	public static class EdgeAndPath {
		Edge edge;
		List<String> path;

		public EdgeAndPath(final Edge edge, final List<String> path) {
			this.edge = edge;
			this.path = path;
		}
	}

	public static List<String> cheapestPathInTransfers(final Map<String, List<Edge>> graph, final String source, final String dest, final int k) {
		final PriorityQueue<EdgeAndPath> fringe =
				new PriorityQueue<>(graph.size(), new Comparator<EdgeAndPath>() {
					@Override
					public int compare(EdgeAndPath e1, EdgeAndPath e2) {
						return e1.edge.cost
								- e2.edge.cost;
					}
				});
		final Set<Edge> visited = new HashSet<>();
		fringe.add(new EdgeAndPath(new Edge(source, 0), new ArrayList<>(Arrays.asList(source))));
		final List<String> pathSoFar = new ArrayList<>();

		while (!fringe.isEmpty()) {
			final EdgeAndPath toVisit = fringe.remove();
			visited.add(toVisit.edge);
			final String visiting = toVisit.edge.node;
			pathSoFar.add(visiting);

			if (visiting.equals(dest)) {
				return toVisit.path;
			}

			if (graph.containsKey(visiting)) {
				for (Edge successor : graph.get(visiting)) {
					if (!visited.contains(successor) && toVisit.path.size() - 2 <= k) {
						final List<String> newPath = addToPath(toVisit, successor);
						fringe.add(new EdgeAndPath(successor, newPath));
					}
				}
			}

		}
		return null;
	}

	private static List<String> addToPath(final EdgeAndPath toVisit, final Edge successor) {
		final List<String> newPath = new ArrayList<>(ImmutableList.copyOf(toVisit.path));
		newPath.add(successor.node);
		return newPath;
	}

	@Test
	public void basicTest() {
		final Map<String, List<Edge>> graph = ImmutableMap.of("A",
				Arrays.asList(new Edge("C", 500), new Edge("B", 100)),
				"B",
				Arrays.asList(new Edge("C", 100)));

		final List<String> path = cheapestPathInTransfers(graph, "A", "C", 1);

		assertTrue(path.equals(Arrays.asList("A", "B", "C")));
	}

	@Test
	public void singleCycleTest() {
		final Map<String, List<Edge>> graph = ImmutableMap.of("A",
				Arrays.asList(new Edge("C", 500), new Edge("B", 100)),
				"B",
				Arrays.asList(new Edge("A", 50), new Edge("C", 100)));

		final List<String> path = cheapestPathInTransfers(graph, "A", "C", 1);

		assertTrue(path.equals(Arrays.asList("A", "B", "C")));
	}

	@Test
	public void multiplePathsTest() {
		final Map<String, List<Edge>> graph = ImmutableMap.of("A",
				Arrays.asList(new Edge("B", 100), new Edge("D", 100)),
				"B",
				Arrays.asList(new Edge("C", 100)),
				"D",
				Arrays.asList(new Edge("C", 50)));

		final List<String> path = cheapestPathInTransfers(graph, "A", "C", 1);

		assertTrue(path.equals(Arrays.asList("A", "D", "C")));
	}

	@Test
	public void noPathTest() {
		final Map<String, List<Edge>> graph = ImmutableMap.of("A",
				Arrays.asList(new Edge("B", 100), new Edge("D", 100)),
				"B",
				Arrays.asList(new Edge("C", 100)),
				"D", new ArrayList<Edge>());
		final List<String> path = cheapestPathInTransfers(graph, "A", "F", 1);

		assertNull(path);
	}
}