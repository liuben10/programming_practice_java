package linkedlist;

import java.util.List;

public class CheckIfListIsPalindrome {

	
	public static boolean isPalindrome(LinkListNode node) {
		if (node == null) {
			return true;
		}
		int length = getLength(node);
		if (length == 1) {
			return true;
		}
		int midpoint = length / 2;
		List<LinkListNode> pointers = positionPointers(node, midpoint);
		reverseHalf(node, 0);
		boolean result;
		if (length % 2 == 0) {
			 result = checkIfPalindrome(pointers.get(0), pointers.get(1));
		} else {
			 result = checkIfPalindrome(pointers.get(0), pointers.get(1).getNextNode());
		}
		LinkListNode lastNode = reverseHalf(pointers.get(0), 0);
		lastNode.setNextNode(pointers.get(1));
		return result;
	}

	private static boolean checkIfPalindrome(LinkListNode linkListNode, LinkListNode linkListNode2) {
		return false;
		// TODO Auto-generated method stub
		
	}

	private static LinkListNode reverseHalf(LinkListNode node, int i) {
		return node;
		// TODO Auto-generated method stub
		
	}

	private static List<LinkListNode> positionPointers(LinkListNode node, int midpoint) {
		return null;
		// TODO Auto-generated method stub
		
	}

	private static int getLength(LinkListNode node) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
