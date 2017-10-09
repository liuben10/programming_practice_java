package graph;

import java.util.*;

/**
 * Created by liuben10 on 10/8/17.
 */
public class BFS {

	Map<Integer, List<Integer>> graph = new HashMap<>();

	public void constructGraph(List<List<Integer>> edges) {
		for (List<Integer> edge : edges) {
			Integer src = edge.get(0);
			Integer dest = edge.get(1);
			if (graph.containsKey(src)) {
				graph.get(src).add(dest);
			} else {
				graph.put(src, new ArrayList<>(Arrays.asList(dest)));
				graph.put(dest, new ArrayList<>());
			}
		}
	}


	public Map<Integer, Integer> distancesFromSource(Integer src) {
		Map<Integer, Integer> result = new HashMap<>();
		for (Integer integer : graph.keySet()) {
			result.put(integer, -1);
		}

		result.put(src, 0);

		Queue<List<Integer>> fringe = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		fringe.add(Arrays.asList(src, 0));
		while (!fringe.isEmpty()) {
			List<Integer> nodeAndDist = fringe.remove();
			Integer curNode = nodeAndDist.get(0);
			Integer dist = nodeAndDist.get(1);
			if (result.get(curNode) < 0 || result.get(curNode) > dist)
				result.put(curNode, dist);
			visited.add(curNode);
			for (Integer successor : graph.get(curNode)) {
				if (!visited.contains(successor)) {
					fringe.add(Arrays.asList(successor, dist+1));
				}
			}
		}

		return result;
	}

	public static void main(String...args) {

		List<List<Integer>> testEdges = new ArrayList<>(Arrays.asList(
				Arrays.asList(1, 3),
				Arrays.asList(1, 2),
				Arrays.asList(2, 4),
				Arrays.asList(3, 5),
				Arrays.asList(5, 4)
		));
		BFS bfs = new BFS();

		bfs.constructGraph(testEdges);
		System.out.println(bfs.distancesFromSource(1));

	}

}
