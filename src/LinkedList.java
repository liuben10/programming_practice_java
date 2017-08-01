/**
 * Created by benjaminliu on 1/23/17.
 */
public class LinkedList<T> {
	Node<T> hp = null;

	public LinkedList(final T value) {
		this.hp = new Node(value, null);
	}

	public LinkedList() {
		this.hp = null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node<T> iterator = this.hp;
		while(iterator != null) {
			sb.append(iterator.getValue()).append(", ");
			iterator = iterator.getNext();
		}
		sb.append("}");
		return sb.toString();
	}

	public void addToEnd(final T value) {
		final Node<T> newNode = new Node<>(value);
		Node<T> iterator = this.hp;
		if (iterator == null) {
			this.hp = newNode;
			return;
		}
		while (iterator.getNext() != null) {
			iterator = iterator.getNext();
		}
		iterator.setNext(newNode);
	}

	public boolean isEmpty() {
		return this.hp == null;
	}

	public void add(final T value) {
		Node<T> newNode = new Node<>(value);
		if (this.hp == null) {
			this.hp = newNode;
			return;
		} else {
			newNode.setNext(this.hp);
			this.hp = newNode;
		}
	}

	public T pop() {
		Node<T> prev = null;
		Node<T> iterator = this.hp;
		if (iterator == null) {
			return null;
		}
		while (iterator.getNext() != null) {
			prev = iterator;
			iterator = iterator.getNext();
		}
		if (prev == null) {
			this.hp = null;
			return null;
		}
		prev.setNext(null);
		return iterator.getValue();
	}

	public T popFromTop() {
		if (this.hp == null) {
			return null;
		}
		Node<T> popped = this.hp;
		this.hp = this.hp.getNext();
		return popped.getValue();
	}

	private static class Node<T> {
		Node next;
		T value;

		public Node(final T value) {
			this.value = value;
			this.next = null;
		}

		public Node(final T value, final Node next) {
			this.value = value;
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(final Node next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(final T value) {
			this.value = value;
		}
	}
}
