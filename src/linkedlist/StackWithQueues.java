package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueues {
	
	private Queue<Integer> frontQueue;
	private Queue<Integer> backQueue;
	
	public StackWithQueues() {
		frontQueue = new LinkedList<Integer>();
		backQueue = new LinkedList<Integer>();
	}
	
	public void push(Integer element) {
		frontQueue.add(element);
	}
	
	public Integer pop() {
		if (!frontQueue.isEmpty()) {
			while (frontQueue.size() > 1) {
				Integer element = frontQueue.remove();
				backQueue.add(element);
			}
			return frontQueue.remove();
		} else {
			if (!backQueue.isEmpty()) {
				while(backQueue.size() > 1) {
					Integer element = backQueue.remove();
					frontQueue.add(element);
				}
				return backQueue.remove();
			} else {
				throw new RuntimeException("Cannot remove element from back queue.");
			}
		}
	}
	
	
	
	

}
