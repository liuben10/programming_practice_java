package tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by liuben10 on 8/15/17.
 */
public class SelfBalancingTreesTest {

	@Test
	public void simpleInsertionTests() {
		AvlTree<Integer> test = new AvlTree<>(new AvlNode<>(6, null, null));

		test.insert(new AvlNode<>(8, null, null));

		test.insert(new AvlNode<>(5, null, null));

		System.out.println(test);
	}

	@Test
	public void avlTreeInsertion() {
		AvlTree<Integer> test = new AvlTree<>(6);

		test.insert(10);
		test.insert(12);
		test.insert(15);

		assertThat(test.getRoot().getVal().equals(12), equalTo(true));
	}
}
