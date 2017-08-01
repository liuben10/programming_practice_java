package linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 */
public class ReverseLinkedList {

	public static void main(String...args) {
		final LinkList linkList = new LinkList();
		linkList.add(3).add(4).add(5).add(6);
		linkList.reverse();
		linkList.print();
	}

	@Data
	public static class LinkList {
		@Getter
		@Setter
		private LLNode hp;

		public LinkList add(final int value) {
			if (hp == null) {
				this.hp = new LLNode(value, null);
			} else {
				LLNode iterator = hp;
				while(iterator.getNext() != null) {
					iterator = iterator.getNext();
				}
				iterator.setNext(new LLNode(value, null));
			}
			return this;
		}

		public void print() {
			LLNode iterator = hp;
			while(iterator != null) {
				System.out.println(iterator.getValue());
				iterator = iterator.getNext();
			}
		}

		public LLNode reverse() {
			return reverse(hp);
		}

		private LLNode reverse(LLNode node) {
			if (node.getNext() == null) {
				this.hp = node;
				return node;
			} else {
				LLNode tmp = node;
				LLNode reverse = reverse(tmp.getNext());
				reverse.setNext(tmp);
				tmp.setNext(null);
				return tmp;
			}
		}
	}

	@Data
	@AllArgsConstructor
	public static class LLNode {
		@Getter
		@Setter
		private Integer value;

		@Getter
		@Setter
		private LLNode next;
	}
}
