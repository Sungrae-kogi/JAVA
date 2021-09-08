package DoublyLinked;

public class ListNode {
	ListNode prev;
	String data;
	ListNode next;
	
	public ListNode() {
		this.prev = null;
		this.data = null;
		this.data = null;
	}
	
	public ListNode(String data) {
		this.data = data;
	}
	
	public ListNode(ListNode prev, String data, ListNode next) {
		super();
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	
	public String getData() {
		return this.data;
	}
}
