import java.util.ArrayList;
import java.util.List;

/**
 */
public class Scratch {

	public static void main(String...args) {
//		int[] coins = {2, 3, 5};
//		int amount = 12;
//		System.out.println(minCoins(coins, amount));
		System.out.println(testCheckBinarySearchTree());
	}

	public static boolean testCheckBinarySearchTree() {
		BinaryTree<Integer> binTree = new BinaryTree<>(5);
		binTree.setLeft(new BinaryTree.BinaryTreeBuilder<>(3).build());
		binTree.setRight((new BinaryTree.BinaryTreeBuilder<>(7)
				.addRight(new BinaryTree.BinaryTreeBuilder<>(8).build())
				.addLeft(new BinaryTree.BinaryTreeBuilder<>(6).build())).build());
		return binTree.isBinarySearchTree();
	}

	public static void testPrintingTree() {
		BinaryTree<Integer> binTree = new BinaryTree<>(5);
		binTree.setLeft(new BinaryTree<>(3));
		binTree.setRight(new BinaryTree<>(5));
		System.out.println(binTree);
	}

	public static List<Integer> minCoins(int[] coins, int amount) {
		int[] subproblems = new int[amount+1];
		int[] lastCoins = new int[amount+1];
		for(int i = 1 ; i < amount+1; i++) {
			int minCoin = Integer.MAX_VALUE;
			int minValue = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin >= 0) {
					if (subproblems[i-coin] + 1 < minValue && subproblems[i-coin] != Integer.MAX_VALUE) {
						minValue = subproblems[i-coin] + 1;
						minCoin = coin;
					}
				}
			}
			subproblems[i] = minValue;
			lastCoins[i] = minCoin;
		}
		final List<Integer> solution = new ArrayList<>();
		int iteratorIndex = amount;
		while (iteratorIndex > 0) {
			solution.add(lastCoins[iteratorIndex]);
			iteratorIndex -= lastCoins[iteratorIndex];
		}

		return solution;
	}
}
