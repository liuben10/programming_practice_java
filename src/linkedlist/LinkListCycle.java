package linkedlist;

public class LinkListCycle {
	
	public static void main(String...args) {
		LinkListNode a = new LinkListNode(3, null);
		LinkListNode b = new LinkListNode(4, null);
		LinkListNode c = new LinkListNode(5, null);
		LinkListNode d = new LinkListNode(6, null);
		LinkListNode e = new LinkListNode(7, null);
		a.setNextNode(b);
		b.setNextNode(c);
		c.setNextNode(d);
		d.setNextNode(e);
		e.setNextNode(c);
		System.out.println(getEntryPoint(b));
		
	}
	
	public static LinkListNode getEntryPoint(LinkListNode node) {
		LinkListNode cyclePoint = determineCyclePoint(node);
		int lengthOfCycle = countCycleLength(cyclePoint);
		LinkListNode fastIter = node;
		for (int i = 0; i < lengthOfCycle; i++) {
			fastIter = fastIter.getNextNode();
		}
		LinkListNode slowIter = node;
		while (fastIter != slowIter) {
			fastIter = fastIter.getNextNode();
			slowIter = slowIter.getNextNode();
		}
		return fastIter;
	}
	
	private static int countCycleLength(LinkListNode node) {
		int count = 1;
		LinkListNode iterator = node.getNextNode();
		while(iterator != node) {
			iterator = iterator.getNextNode();
			count += 1;
		}
		return count;
	}

	public static boolean determineIfCycle(LinkListNode node) {
		if (node.getNextNode() == null) {
			return false;
		}
		LinkListNode fastPtr = node.getNextNode();
		LinkListNode slowPtr = node;
		while(fastPtr.getNextNode() != null && fastPtr.getNextNode().getNextNode() != null) {
			if (fastPtr == slowPtr) {
				return true;
			}
			fastPtr = fastPtr.getNextNode().getNextNode();
			slowPtr = slowPtr.getNextNode();
		}
		return false;
	}
	
	public static LinkListNode determineCyclePoint(LinkListNode node) {
		if (node.getNextNode() == null) {
			throw new IllegalArgumentException("Node must have a cycle.");
		}
		LinkListNode fastPtr = node.getNextNode();
		LinkListNode slowPtr = node;
		LinkListNode cyclePoint = null;
		while(fastPtr.getNextNode() != null && fastPtr.getNextNode().getNextNode() != null) {
			if (fastPtr == slowPtr) {
				cyclePoint = fastPtr;
				break;
			}
			fastPtr = fastPtr.getNextNode().getNextNode();
			slowPtr = slowPtr.getNextNode();
		}
		if (cyclePoint == null) {
			throw new IllegalArgumentException("Node must have a cycle.");
		} else {
			return cyclePoint;
		}
	}
	
	public static Integer determineCycleLength(LinkListNode node) {
		if (node.getNextNode() == null) {
			throw new IllegalArgumentException("Node must have a cycle.");
		}
		LinkListNode fastPtr = node.getNextNode();
		LinkListNode slowPtr = node;
		LinkListNode cyclePoint = null;
		while(fastPtr.getNextNode() != null && fastPtr.getNextNode().getNextNode() != null) {
			if (fastPtr == slowPtr) {
				cyclePoint = fastPtr;
				break;
			}
			fastPtr = fastPtr.getNextNode().getNextNode();
			slowPtr = slowPtr.getNextNode();
		}
		if (cyclePoint == null) {
			throw new IllegalArgumentException("Node must have a cycle.");
		} else {
			LinkListNode iterator = cyclePoint.getNextNode();
			int count = 1;
			while(iterator != cyclePoint) {
				iterator = iterator.getNextNode();
				count += 1;
			}
			return count;	
		}
	}

}
