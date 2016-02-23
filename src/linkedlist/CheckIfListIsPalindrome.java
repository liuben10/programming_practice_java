package linkedlist;

import java.util.Arrays;
import java.util.List;

public class CheckIfListIsPalindrome {
	
	public static void main(String...args) {
		LinkListNode node = new LinkListNode(3, new LinkListNode(4, new LinkListNode(5, new LinkListNode(4, new LinkListNode(3, null)))));
		LinkListNode node2 = new LinkListNode(3, null);
		LinkListNode node3 = new LinkListNode(3, new LinkListNode(3, null));
		System.out.println(isPalindrome(node3));
	}

	
	public static boolean isPalindrome(LinkListNode node) {
		if (node == null) {
			return true;
		}
		int length = getLength(node);
		if (length == 1) {
			return true;
		}
		int midpoint = (length - 1) / 2;
		List<LinkListNode> pointers = positionPointers(node, midpoint);
		LinkListNode beginning = reverseHalf(node, pointers.get(0));
		boolean result;
		if (length % 2 == 0) {
			 result = checkIfPalindrome(pointers.get(0), pointers.get(1));
		} else {
			 result = checkIfPalindrome(pointers.get(0), pointers.get(1).getNextNode());
		}
		LinkListNode lastNode = reverseHalf(pointers.get(0), beginning);
		lastNode.setNextNode(pointers.get(1));
		return result;
	}

	private static boolean checkIfPalindrome(LinkListNode front, LinkListNode back) {
		LinkListNode iterFront = front;
		LinkListNode iterBack = back;
		while(iterFront != null) {
			if (!iterFront.getValue().equals(iterBack.getValue())) {
				return false;
			}
			iterFront = iterFront.getNextNode();
			iterBack = iterBack.getNextNode();
		}
		return true;
		
	}

	private static LinkListNode reverseHalf(LinkListNode node, LinkListNode end) {
		if (node == end) {
			node.setNextNode(null);
			return node;
		} else {
			LinkListNode newEnd = reverseHalf(node.getNextNode(), end);
			newEnd.setNextNode(node);
			node.setNextNode(null);
			return node;
		}

	}

	private static List<LinkListNode> positionPointers(LinkListNode node, int midpoint) {
		LinkListNode iter = node;
		int count = 1;
		while(count < midpoint) {
			iter = iter.getNextNode();
			count += 1;
		}
		List<LinkListNode> pairOfPointers = Arrays.asList(iter, iter.getNextNode());
		return pairOfPointers;
	}

	private static int getLength(LinkListNode node) {
		LinkListNode iter = node;
		int length = 0;
		while (iter != null) {
			length += 1;
			iter = iter.getNextNode();
		}
		return length;
	}
}
