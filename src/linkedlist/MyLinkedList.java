package linkedlist;

public class MyLinkedList {
	Node hp;
	private int size = 0;
	
	public static void main(String...args) {
		MyLinkedList ll = new MyLinkedList();
		ll.push(3);
		ll.push(4);
		ll.push(5);
		System.out.println(ll);
		System.out.println(ll.pop());
		System.out.println(ll);
	}
	
	public MyLinkedList() {
		this.hp = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if (this.hp == null) {
			this.hp = newNode;
		} else {
			Node tmp = this.hp;
			this.hp = newNode;
			this.hp.setNextNode(tmp);
		}
		this.size += 1;
	}
	
	
	public int pop() {
		if (this.hp == null) {
			this.size = 0;
			throw new RuntimeException("Cannot pop from an empty list");
		} else {
			Node toReturn = this.hp;
			this.hp = this.hp.getNextNode();
			this.size -= 1;
			return toReturn.getValue();
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node iter = this.hp;
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

class Node {
	
	private int value;
	private Node nextNode;
	
	public Node(int value) {
		this.value = value;
		this.nextNode = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
