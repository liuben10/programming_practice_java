package linkedlist;

public class MyLinkedList {
	LinkListNode hp;
	private int size = 0;
	
	public static void main(String...args) {
		MyLinkedList ll = new MyLinkedList();
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.reverse();
		System.out.println(ll);
	}
	
	public MyLinkedList() {
		this.hp = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}

	public void append(int val) {
		LinkListNode node = new LinkListNode(val, null);
		if (this.hp == null) {
			this.hp = node;
		} else {
			LinkListNode iter = this.hp;
			while(iter.getNextNode() != null) {
				iter = iter.getNextNode();
			}
			iter.setNextNode(node);
		}
	}
	
	public void push(int value) {
		LinkListNode newNode = new LinkListNode(value, null);
		if (this.hp == null) {
			this.hp = newNode;
		} else {
			LinkListNode tmp = this.hp;
			this.hp = newNode;
			this.hp.setNextNode(tmp);
		}
		this.size += 1;
	}

	public void reverse() {
		LinkListNode iter = this.hp;
		LinkListNode prev = null;
		while(iter != null) {
			LinkListNode tmp = iter;
			iter = iter.getNextNode();
			tmp.setNextNode(prev);
			prev = tmp;
		}
		this.hp = prev;
	}
	
	
	public int pop() {
		if (this.hp == null) {
			this.size = 0;
			throw new RuntimeException("Cannot pop from an empty list");
		} else {
			LinkListNode toReturn = this.hp;
			this.hp = this.hp.getNextNode();
			this.size -= 1;
			return toReturn.getValue();
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkListNode iter = this.hp;
		while(iter != null) {
			sb.append(iter.getValue()).append("->");
			iter = iter.getNextNode();
		}
		sb.append("|/|");
		return sb.toString();
		
	}
	

	public int getSize() {
		return size;
	}

}
