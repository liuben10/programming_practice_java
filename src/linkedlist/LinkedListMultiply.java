package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class LinkedListMultiply {

	static class ListNode {
		Integer value;
		ListNode next;

		public ListNode(Integer value) {
			this.value = value;
			this.next = null;
		}

		public ListNode(Integer value, ListNode next) {
			this.value = value;
			this.next = next;
		}

		public ListNode setNext(Integer val) {
			this.next = new ListNode(val);
			return this.next;
		}

		public ListNode setNext(ListNode next) {
			this.next = next;
			return this.next;
		}
	}

	public static void printList(ListNode listNode) {
		ListNode iter = listNode;
		while(iter != null) {
			System.out.print(iter.value + "->");
			iter = iter.next;
		}
	}

	public static ListNode multiply(ListNode a, ListNode b) {
		ListNode iterB = b;

		List<ListNode> listsToAdd = new ArrayList<>();
		int offset = 0;
		int carry;
		while(iterB != null) {
			ListNode iter = a;
			ListNode tail = null;
			ListNode head = null;
			carry = 0;

			for(int i = 0; i < offset; i++) {
				if (head == null) {
					head = new ListNode(0);
					tail = head;
				} else {
					tail = tail.setNext(new ListNode(0));
				}
			}

			while (iter != null) {
				int multiply = (iter.value * iterB.value) + carry;
				carry = multiply / 10;
				int value = multiply % 10;
				if (tail == null) {
					tail = new ListNode(value);
					head = tail;
				} else {
					tail = tail.setNext(new ListNode(value));
				}
				iter = iter.next;
			}

			if (carry != 0) {
				tail.setNext(carry);
			}

			listsToAdd.add(head);
			iterB = iterB.next;
			offset += 1;
		}


		ListNode sum = listsToAdd.get(0);
		for (int i = 1; i < listsToAdd.size(); i++) {
			sum = add(sum, listsToAdd.get(i));
		}

		return sum;
	}

	@SuppressWarnings("Duplicates")
	public static ListNode add(ListNode a, ListNode b) {
		ListNode iter = a;
		ListNode iterB = b;

		int carry = 0;
		ListNode sum = null;
		ListNode tail = null;
		while (iter != null && iterB != null) {
			int result = iter.value + iterB.value + carry;
			carry = result / 10;
			int val = result % 10;
			if (sum == null) {
				sum = new ListNode(val);
				tail = sum;
			} else {
				tail = tail.setNext(val);
			}
			iter = iter.next;
			iterB = iterB.next;
		}

		while(iter != null) {
			int result = iter.value + carry;
			carry = result / 10;
			int val = result % 10;
			if (sum == null) {
				sum = new ListNode(val);
				tail = sum;
			} else {
				tail = tail.setNext(val);
			}
			iter = iter.next;
		}

		while(iterB != null) {
			int result = iterB.value + carry;
			carry = result / 10;
			int val = result % 10;
			if (sum == null) {
				sum = new ListNode(val);
				tail = sum;
			} else {
				tail = tail.setNext(val);
			}
			iterB = iterB.next;
		}

		while (carry > 0) {
			int val = carry % 10;
			carry = carry / 10;
			tail = tail.setNext(val);
		}

		return sum;
	}

	public static void main(String...args) {
		ListNode a = new ListNode(3);
		a.setNext(4).setNext(5).setNext(6).setNext(2).setNext(8);

		ListNode b = new ListNode(2);
		b.setNext(3).setNext(4).setNext(5);

		printList(multiply(a, b));
	}
}
