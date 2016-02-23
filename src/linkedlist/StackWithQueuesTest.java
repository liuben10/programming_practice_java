package linkedlist;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackWithQueuesTest {
	
	private StackWithQueues stackWithQueues;
	
	@Before
	public void setUp() {
		stackWithQueues = new StackWithQueues();
	}
	
	
	@Test(expected = RuntimeException.class)
	public void testPopEmpty() {	
		stackWithQueues.pop();
	}
	
	@Test
	public void testSingleElement() {
		stackWithQueues.push(3);
		assertEquals(new Integer(3), stackWithQueues.pop());
	}
	
	@Test
	public void testWillBehaveLikeStackSimple() {
		stackWithQueues.push(3);
		stackWithQueues.push(4);
		assertEquals(new Integer(4), stackWithQueues.pop());
		assertEquals(new Integer(3), stackWithQueues.pop());
	}
	
	@Test
	public void testWillBehaveLikeStackComplicated() {
		stackWithQueues.push(3);
		stackWithQueues.push(4);
		stackWithQueues.push(5);
		assertEquals(new Integer(5), stackWithQueues.pop());
		stackWithQueues.push(6);
		assertEquals(new Integer(6), stackWithQueues.pop());
		assertEquals(new Integer(4), stackWithQueues.pop());
		
	}

}
