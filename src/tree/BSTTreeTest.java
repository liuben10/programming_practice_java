package tree;

import org.junit.Test;

/**
 * Created by liuben10 on 8/26/17.
 */
public class BSTTreeTest {

	@Test
	public void itCanInsertAndPrint() {
		BSTTree tree = new BSTTree(100);
		tree.insert(200);
		tree.insert(50);
		tree.insert(75);
		tree.insert(92);
		tree.insert(25);
		tree.insert(250);

		System.out.println(tree);
	}


	@Test
	public void itCanGetNextInOrderBstNode() {
		BSTTree tree = new BSTTree(100);
		BSTNode insert2 = tree.insert(200);
		tree.insert(50);
		tree.insert(75);
		BSTNode insert1 = tree.insert(92);
		BSTNode insert = tree.insert(25);
		BSTNode insert3 = tree.insert(250);

		System.out.println(tree.getNextInOrder(insert));
		System.out.println(tree.getNextInOrder(insert1));
		System.out.println(tree.getNextInOrder(insert2));
		System.out.println(tree.getNextInOrder(insert3));

	}
}
