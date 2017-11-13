package graph;

import java.util.*;

/**
 */
public class CountCycles {


	public static class NodePath {
		Integer node;
		LinkedHashSet<Integer> nodes;

		public NodePath(Integer node, LinkedHashSet<Integer> nodes) {
			this.node = node;
			this.nodes = nodes;
		}
	}

	Map<Integer, Set<Integer>> graph;

	public CountCycles() {
		this.graph = new HashMap<>();
	}

	public int countCycles() {
		return countCyclesHelper();
	}

	private int countCyclesHelper() {
		Set<Integer> toVisit = new HashSet<>(graph.keySet());
		int total = 0;
		while(!toVisit.isEmpty()) {
			Stack<NodePath> stack = new Stack<>();
			stack.push(new NodePath(toVisit.iterator().next(), new LinkedHashSet<>()));

			while(!stack.isEmpty()) {
				NodePath src = stack.pop();
				toVisit.remove(src.node);
				for (Integer successor : graph.get(src.node)) {
					if (src.nodes.contains(successor)) {
						LinkedHashSet<Integer> cycle = new LinkedHashSet<>(src.nodes);
						cycle.add(successor);
						System.out.println("Cycle detected: " + cycle);
						total += 1;
					} else {
						LinkedHashSet<Integer> otherPath = new LinkedHashSet<>(src.nodes);
						otherPath.add(successor);
						stack.push(new NodePath(successor, otherPath));
					}
				}
			}

		}

		return total;

	}

	public void addEdge(Integer src, Integer dest) {
		if (graph.containsKey(src)) {
			graph.get(src).add(dest);
		} else {
			graph.put(src, new HashSet<>());
		}

		if (!graph.containsKey(dest)) {
			graph.put(dest, new HashSet<>());
		}
	}

	public static void main(String...args) {
		CountCycles cc = new CountCycles();
		cc.addEdge(3, 5);
		cc.addEdge(5, 4);
		cc.addEdge(5, 7);
		cc.addEdge(5, 11);
		cc.addEdge(4, 6);
		cc.addEdge(6, 5);
		cc.addEdge(6, 9);
		cc.addEdge(9, 10);
		cc.addEdge(10, 9);

		System.out.println(cc.countCycles());
	}


}
