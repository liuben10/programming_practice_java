package linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckIfPalindromeTest {
	
	private LinkListNode node;
	private LinkListNode node2;
	private LinkListNode node3;
	private LinkListNode node4;
	private LinkListNode node5;

	@Before
	public void setup() {
		node = new LinkListNode(3, new LinkListNode(4, new LinkListNode(5, new LinkListNode(4, new LinkListNode(3, null)))));
		node2 = new LinkListNode(3, null);
		node3 = new LinkListNode(3, new LinkListNode(3, null));
		node4 = new LinkListNode(3, new LinkListNode(4, null));
		node5 = new LinkListNode(3, new LinkListNode(4, new LinkListNode(5, null)));
	}

	@Test
	public void testSingle() {
		assertTrue(CheckIfListIsPalindrome.isPalindrome(node2));
	}
	
	@Test
	public void testDoublePalindrome() {
		assertTrue(CheckIfListIsPalindrome.isPalindrome(node3));
	}
	
	@Test
	public void testOddPalindrome() {
		assertTrue(CheckIfListIsPalindrome.isPalindrome(node));
	}
	
	@Test
	public void testIsNotPalindromeEven() {
		assertFalse(CheckIfListIsPalindrome.isPalindrome(node4));
	}
	
	@Test
	public void testIsNotPalindromeOdd() {
		assertFalse(CheckIfListIsPalindrome.isPalindrome(node5));
	}

}
