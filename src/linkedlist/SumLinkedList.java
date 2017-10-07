package linkedlist;

/**
 * Created by liuben10 on 10/6/17.
 */
public class SumLinkedList {

	static class ListNode {
		int val;

		ListNode next;

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		public ListNode add(int next) {
			this.next = new ListNode(next, null);
			return this.next;
		}
	}

	public static void printList(ListNode in) {
		ListNode iter = in;
		while(iter != null) {
			System.out.println(iter.val);
			iter = iter.next;
		}
	}

	public static ListNode sum(ListNode input, ListNode input2) {
		ListNode a = input;
		ListNode b = input2;
		ListNode res = null;
		ListNode head = null;
		int carry = 0;
		while (a != null && b != null) {
			int rawsum = a.val + b.val + carry;
			int sum = rawsum % 10;
			carry = rawsum / 10;
			if (res == null) {
				res = new ListNode(sum, null);
				head = res;
			} else {
				res.next = new ListNode(sum, null);
				res = res.next;
			}
			a = a.next;
			b = b.next;
		}

		while (a != null) {
			int rawsum = a.val + carry;
			int sum = rawsum % 10;
			carry = rawsum / 10;
			if (res == null) {
				res = new ListNode(sum, null);
				head = res;
			} else {
				res.next = new ListNode(sum, null);
				res = res.next;
			}
			a = a.next;
		}

		while (b != null) {
			int rawsum = b.val + carry;
			int sum = rawsum % 10;
			carry = rawsum / 10;
			if (res == null) {
				res = new ListNode(sum, null);
				head = res;
			} else {
				res.next = new ListNode(sum, null);
				res = res.next;
			}
			b = b.next;
		}

		while (carry > 0) {
			int rawsum = carry;
			int sum = rawsum % 10;
			carry = rawsum / 10;
			if (res == null) {
				res = new ListNode(sum, null);
				head = res;
			} else {
				res.next = new ListNode(sum, null);
				res = res.next;
			}
		}
		return head;
	}

	public static void main(String...args) {
		ListNode nde = new ListNode(5, null);
		nde.add(2).add(1).add(9);
		ListNode nde2 = new ListNode(6, null);
		nde2.add(5).add(9);

		ListNode sum = sum(nde, nde2);
		printList(sum);
	}
}
