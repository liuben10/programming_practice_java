package linkedlist;

public class LinkListNode {
	
	private Integer value;
	@Override
	public String toString() {
		return "LinkListNode [value=" + value + "]";
	}
	private LinkListNode nextNode;
	
	public LinkListNode(Integer value, LinkListNode nextNode) {
		super();
		this.value = value;
		this.nextNode = nextNode;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public LinkListNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkListNode nextNode) {
		this.nextNode = nextNode;
	}

}
