package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SearchProblems {
	
	private Set<String> visited;
	
	public SearchProblems() {
		this.visited = new HashSet<String>();
	}
	
	public static void main(String...args) {
		SearchProblems dfs = new SearchProblems();
		Map<String, List<String>> graph = new HashMap<String, List<String>>();
		graph.put("A", Arrays.asList("B", "C"));
		graph.put("B", Arrays.asList("D"));
		graph.put("C", Arrays.asList("D"));
		graph.put("D", Arrays.asList("F"));
		graph.put("F", Collections.EMPTY_LIST);
		dfs.iterative_dfs(graph, "A");+
	}
	
	public void iterative_dfs(Map<String, List<String>> graph, String src) {
		Stack<String> toVisit = new Stack<String>();
		Set<String> visited = new HashSet<String>();
		toVisit.add(src);
		while(!toVisit.isEmpty()) {
			String visiting = toVisit.pop();
			visited.add(visiting);
			System.out.println("visiting : " + visiting);
			List<String> successors = graph.get(visiting);
			if (successors != null) {
				for (String successor : successors) {
					if (!visited.contains(successor) && !toVisit.contains(successor)) {	
						toVisit.push(successor);
					}
				}
			}
		}
	}
	
	public void iterative_bfs(Map<String, List<String>> graph, String src) {
		Queue<String> toVisit = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		toVisit.add(src);
		while(!toVisit.isEmpty()) {
			String visiting = toVisit.remove();
			visited.add(visiting);
			System.out.println("visiting : " + visiting);
			List<String> successors = graph.get(visiting);
			if (successors != null) {
				for (String successor : successors) {
					if (!visited.contains(successor) && !toVisit.contains(successor)) {
						toVisit.add(successor);
					}
				}
			}
		}
	}
	
	public void bfs(Map<String, List<String>> graph, String src) {
		if (!graph.containsKey(src)) {
			return;
		} else {
			if (visited.isEmpty()) {
				System.out.println(src);
			}
			List<String> successors = graph.get(src);
			visited.add(src);
			if (successors != null && !successors.isEmpty()) {
				for (String successor : successors) {
					if (!visited.contains(successor)) {
						System.out.println(successor);
					}
				}
				for (String successor : successors) {
					if (!visited.contains(successor)) {
						bfs(graph, successor);
					}
				}
			}
		}
	} 
	
	public void dfs(Map<String, List<String>> graph, String src) {	
		if (!graph.containsKey(src)) {
			return;
		} else {
			System.out.println(src);
			visited.add(src);
			List<String> successors = graph.get(src);
			if (successors != null) {
				for (String successor : successors) {
					if (!visited.contains(successor)) {
						dfs(graph, successor);
					}
				}
			}
		}
	}
	
	

}
