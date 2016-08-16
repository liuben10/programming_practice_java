package array;

import java.util.Arrays;

/**
 * Created by benjaminliu on 8/15/16.
 */
public class CircularQueue {

	public static void main(String...args) {
		final CircularQueue circularQueue = new CircularQueue(5);
		System.out.println(circularQueue.enqueue(new char[]{'a', 'b'}));
		System.out.println(Arrays.toString(circularQueue.dequeue(15)));
	}

	private char[] buf;
	private int head;
	private int tail;
	private int size;

	public CircularQueue(final int capacity) {
		this.buf = new char[capacity];
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	public int enqueue(final char[] in) {
		final int availableSlots = buf.length - size;
		final int slots = Math.min(in.length, availableSlots);
		for(int i = 0 ; i < slots; i++) {
			buf[tail % buf.length] = in[i];
			tail = (tail + 1) % buf.length;
			size += 1;
		}
		return slots;
	}

	public char[] dequeue(final int numElem) {
		final int numDeq = Math.min(size, numElem);
		char[] toDequeue = new char[numDeq];
		for(int i = 0 ; i < numDeq; i++) {
			toDequeue[i] = buf[head % buf.length];
			head = (head + 1) % buf.length;
			size -= 1;
		}
		return toDequeue;
	}

}
