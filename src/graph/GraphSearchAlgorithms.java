package graph;

import java.util.*;

/**
 * Created by liuben10 on 8/15/17.
 */

public class GraphSearchAlgorithms {

	private static class NodeAndPath {
		GraphNode<String> node;
		NodeAndPath prev;

		public NodeAndPath(GraphNode node, NodeAndPath prev) {
			this.node = node;
			this.prev = prev;
		}
	}





	public static List<String> dijkstra(final GraphNode src, final GraphNode dest) {
		List<String> results = new ArrayList<>();

		PriorityQueue<NodeAndPath> fringe = new PriorityQueue<>(10, new Comparator<NodeAndPath>() {
			@Override
			public int compare(NodeAndPath o1, NodeAndPath o2) {
				return Integer.compare(o1.node.cost, o2.node.cost);
			}
		});

		Set<GraphNode> visited = new HashSet<>();
		fringe.add(new NodeAndPath(src, null));
		while(!fringe.isEmpty()) {
			NodeAndPath visitingNodeAndPath = fringe.remove();
			GraphNode<String> visitingNode = visitingNodeAndPath.node;
			visited.add(visitingNodeAndPath.node);

			if (visitingNode.equals(dest)) {
				NodeAndPath iterator = visitingNodeAndPath;

				while(iterator.prev != null) {
					results.add(0, iterator.node.val);
					iterator = iterator.prev;
				}
			}

			for (GraphNode graphNode : visitingNode.getSuccessors()) {
				if (!visited.contains(graphNode)) {
					fringe.add(new NodeAndPath(graphNode, visitingNodeAndPath));
				}
			}
		}

		return results;
	}

	public static void main(String...args) {
		GraphNode<String> z = new GraphNode<>("z", 1, new ArrayList<>());

		GraphNode<String> f = new GraphNode<>("f", 2, new ArrayList<>());

		GraphNode<String> k = new GraphNode<>("k", 3, Arrays.asList(f, z));

		GraphNode<String> t = new GraphNode<>("t", 5, Arrays.asList(z));

		f.addSuccessor(t);

		GraphNode<String> l = new GraphNode<>("l", 10, Arrays.asList(t, k));
		GraphNode<String> b = new GraphNode<>("b", 12, Arrays.asList(z));
		GraphNode<String> a = new GraphNode<>("a", 13, Arrays.asList(b));

		System.out.println(dijkstra(a, z));
	}


}
