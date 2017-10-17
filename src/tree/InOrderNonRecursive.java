package tree;

import java.util.*;

/**
 */
public class InOrderNonRecursive {

	public static List<Integer> inOrder(BSTTree tree) {
		Stack<BSTNode> fringe = new Stack<>();
		Set<BSTNode> visited=  new HashSet<>();
		List<Integer> result = new ArrayList<>();
		fringe.push(tree.getRoot());
		while(!fringe.isEmpty()) {
			BSTNode examining = fringe.peek();
			if (examining.getLeft() != null && !visited.contains(examining.getLeft())) {
				fringe.push(examining.getLeft());
			} else {
				BSTNode pop = fringe.pop();
				visited.add(pop);
				result.add(pop.getValue());
				if (pop.getRight() != null && !visited.contains(pop.getRight())) {
					fringe.add(pop.getRight());
				}
			}
		}
		return result;
	}

	public static void main(String...args) {
		BSTTree bstTree = new BSTTree(100);
		bstTree.insert(55);
		bstTree.insert(12);
		bstTree.insert(23);
		bstTree.insert(125);
		bstTree.insert(150);
		bstTree.insert(165);

		List<Integer> resultOrder = inOrder(bstTree);
		System.out.println(resultOrder);
	}
}
