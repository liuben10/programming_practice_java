package linkedlist;

public class SortLinkList {
	
	public static void main(String...args) {
		LinkListNode f = new LinkListNode(12, null);
		LinkListNode e = new LinkListNode(11, f);
		LinkListNode c = new LinkListNode(13, e);
		LinkListNode b = new LinkListNode(1, c);
		LinkListNode a = new LinkListNode(5, b);
		print(sort(a));
	}
	
	
	public static void print(LinkListNode aList) {
		LinkListNode iterator = aList;
		while (iterator != null) {
			System.out.println(iterator.getValue());
			iterator = iterator.getNextNode();
		}
	}
	
	public static LinkListNode sort(LinkListNode aList){ 
		LinkListNode head = new LinkListNode(null, aList);
		LinkListNode fringePtr = aList.getNextNode();
		LinkListNode ptrBeforeFringe = aList;
		LinkListNode findPtr = aList;
		LinkListNode prev = head;
		while(fringePtr != null) {
			Integer valueToInsert = fringePtr.getValue();
			findPtr = head.getNextNode();
			prev = head;
			while(findPtr != fringePtr) {
				System.out.println("fringe=" + fringePtr);
				System.out.println(findPtr);
				if (valueToInsert <= findPtr.getValue()) {
					LinkListNode tmpNode = fringePtr.getNextNode();
					fringePtr.setNextNode(findPtr);
					prev.setNextNode(fringePtr);
					ptrBeforeFringe.setNextNode(tmpNode);
					fringePtr = ptrBeforeFringe;
					break;
				}
				findPtr = findPtr.getNextNode();
				prev = prev.getNextNode();
			}
			fringePtr = fringePtr.getNextNode();
			if (ptrBeforeFringe.getNextNode() != fringePtr) {
				ptrBeforeFringe = ptrBeforeFringe.getNextNode();
			}
		}
		return head.getNextNode();
	}
	
	

}
