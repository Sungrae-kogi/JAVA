package DoublyLinked;

public class DoublyLinkedList {
	ListNode head;
	
	public DoublyLinkedList() {
		this.head = null;
	}
	
	//맨 처음 노드를 넣을때 
	public void insertFirstNode(String data) {
		ListNode node = new ListNode(data);			//매개변수로 data를 준 node를 줌
		if(head ==null) {
			head = node;
			node.prev = node;
			node.next = node;
		}else {
			ListNode current = head;				//head노드를 current라고 임시 지정
			ListNode prev = current.prev;			//head.prev를 prev라고 임시 지정  이거 두개가 다 임시지정이다
			
			node.prev = prev;						//새로 들어온 node의 prev 가 head의 prev가 됨
			node.next = current;					//node의 next가 head가 됨
			current.prev = node;					//head의 prev가 node로 이어짐
			prev.next=node;							//기존에 있던 노드가 새로들어온 노드를 가리키게 됨 여기에서 맨앞 노드가 node가 됨
			head=node;								//head가 node를 지칭하게 바꿔줌 
		}
	}		//새 노드의 next 포인터가 현재의 head 노드를 가리키도록 한 다음 새 노드의 prev 포인터는 null을 가리키게 한다.
			//head 노드의 prev 포인터가 새 노드를 가리키게 하고 새 노드를 head 노드가 되도록 한다.
	
	
	public void insertMiddleNode(ListNode prev, String data) {
		ListNode node = new ListNode(data);
		if(head==null) {
			head = node;
			node.prev = node;
			node.next = node;
		}else {
			ListNode current = head;
			
			while(current !=prev) {
				current = current.next;
			}
			ListNode next = current.next;
			
			node.next = next;
			node.prev = current;
			current.next = node;
			next.prev = node;
		}
	}
	
	public void insertLastNode(String data) {
		ListNode node = new ListNode(data);
		
		if(head ==null) {
			head = node;
			node.prev = node;
			node.next = node;
		}else {
			ListNode current = head;
			while(current.next!= head) {
				current = current.next;
			}
			ListNode next = current.next;
			
			node.next= next;
			next.prev = node;
			current.next = node;
			node.prev = current;
		}
	}
	
	public void deleteFirstNode() {
		if(head == null) {
			System.out.println("삭제할 리스트가 존재하지 않습니다.");
		}else {
			ListNode current = head;
			ListNode prev = current.prev;
			ListNode next = current.next;
			next.prev = prev;
			prev.next = next;
			head=next;
		}
	}
	
	public void deleteMiddleNode(String data) {
		if(head==null) {
			System.out.println("삭제할 리스트가 존재하지 않습니다.");
		}else {
			ListNode current = head;
			while(current.data != data) {
				current = current.next;
			}
			ListNode prev = current.prev;
			ListNode next = current.next;
			prev.next = next;
			next.prev = prev;
		}
	}
	
	public void deleteLastNode() {
		if(head==null) {
			System.out.println("삭제할 리스트가 존재하지 않습니다.");
		}else {
			ListNode current = head;
			while(current.next!=head) {
				current = current.next;
			}
			ListNode prev = current.prev;
			ListNode next = current.next;
			prev.next = next;
			next.prev = prev;
		}
	}
	
	public ListNode searchNode(String data) {
		if(head == null) {
			return null;
		}else {
			ListNode current = head;
			while(current.data !=data) {
				current = current.next;
			}
			return current;
		}
	}
	
	public void printList() {
		if(head==null) {
			System.out.println("출력할 내용이 존재하지 않습니다.");
			
		}else {
			ListNode current = head;
			while(current.next!=head) {
				System.out.print(current.data+" ");
				current=current.next;
			}
			System.out.print(current.data);;
		}
		System.out.println();
	}
}
