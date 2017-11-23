package array;

import lombok.AllArgsConstructor;

/**
 */
public class SimpleWarmupStuff {

	public static int sumArray(int[] input) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		return sum;
	}


	public static ListNode reverse(ListNode in) {
		ListNode prev = null;
		ListNode iter = in;
		while (iter != null) {
			ListNode tmp = iter;
			iter = iter.next;
			tmp.next = prev;
			prev = tmp;
		}
		return prev;
	}


	@AllArgsConstructor
	static class ListNode {
		public ListNode(Integer val) {
			this.val = val;
		}

		Integer val;
		ListNode next;

		ListNode setNext(Integer next) {
			this.next = new ListNode(next, null);
			return this.next;
		}
	}

	public static void main(String...args) {
//		System.out.println(sumArray(new int[]{3, 4, 5}));
		ListNode root = new ListNode(3);
		root.setNext(4).setNext(5);
		ListNode reversed = reverse(root);
		while(reversed != null) {
			System.out.println(reversed.val);
			reversed = reversed.next;
		}
	}
}
