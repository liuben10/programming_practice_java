package graph;

import java.util.*;

/**
 */
public class Graph {

	static class GraphNode {
		Integer nodeId;
		Integer weight;

		public GraphNode(Integer nodeId, Integer weight) {
			this.nodeId = nodeId;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "GraphNode{" +
					"nodeId=" + nodeId +
					", weight=" + weight +
					'}';
		}
	}

	Map<Integer, List<GraphNode>> graph = new HashMap<>();

	public void addEdge(Integer n1, Integer n2, Integer weight) {
		if (graph.containsKey(n1)) {
			graph.get(n1).add(new GraphNode(n2, weight));
			if (!graph.containsKey(n2)) {
				graph.put(n2, new ArrayList<>());
			}
		} else {
			graph.put(n1, new ArrayList<>(Arrays.asList(new GraphNode(n2, weight))));
		}
	}

	static class NodeAndPath {
		Integer node;
		List<Integer> path;

		@Override
		public String toString() {
			return "NodeAndPath{" +
					"node=" + node +
					", path=" + path +
					", pathWeight=" + pathWeight +
					'}';
		}

		Integer pathWeight;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			NodeAndPath that = (NodeAndPath) o;

			if (node != null ? !node.equals(that.node) : that.node != null) return false;
			if (path != null ? !path.equals(that.path) : that.path != null) return false;
			return pathWeight != null ? pathWeight.equals(that.pathWeight) : that.pathWeight == null;
		}

		@Override
		public int hashCode() {
			int result = node != null ? node.hashCode() : 0;
			result = 31 * result + (path != null ? path.hashCode() : 0);
			result = 31 * result + (pathWeight != null ? pathWeight.hashCode() : 0);
			return result;
		}

		public NodeAndPath(Integer node, List<Integer> path, Integer pathWeight) {
			this.node = node;
			this.path = path;
			this.pathWeight = pathWeight;
		}
	}

	public List<Integer> longestPathDag(Integer src, Integer dest) {
		Stack<NodeAndPath> fringe = new Stack<>();
		fringe.push(new NodeAndPath(src, new ArrayList<>(), 0));
		Integer maxWeight = 0;
		List<Integer> maxPath = new ArrayList<>();
		while (!fringe.isEmpty()) {
			NodeAndPath cur = fringe.pop();
			if (cur.node.equals(dest)) {
				if (cur.pathWeight > maxWeight) {
					maxPath = cur.path;
					maxPath.add(cur.node);
					maxWeight = cur.pathWeight;
				}
			} else {
				for (GraphNode graphNode : graph.get(cur.node)) {
					if (!cur.path.contains(graphNode.nodeId)) {
						ArrayList<Integer> copy = new ArrayList<>(cur.path);
						copy.add(cur.node);
						Integer weight = cur.pathWeight + graphNode.weight;
						fringe.push(new NodeAndPath(graphNode.nodeId, copy, weight));
					} else {
						throw new IllegalArgumentException("Cannot have cycles for the longest path problem");
					}
				}
			}
		}

		return maxPath;
	}

	public static void main(String...args) {
		Graph g = new Graph();
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 5);
		g.addEdge(1, 4, 15);
		g.addEdge(2, 6, 7);
		g.addEdge(6, 4, 10);
		g.addEdge(6, 9, 11);
		g.addEdge(9, 15, 13);
		g.addEdge(3, 4, 2);

		System.out.println(g.longestPathDag(1, 4));
	}
}
