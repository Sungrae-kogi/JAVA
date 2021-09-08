package DoublyLinked;

public class DoublyLinkedList {
	ListNode head;
	
	public DoublyLinkedList() {
		this.head = null;
	}
	
	//�� ó�� ��带 ������ 
	public void insertFirstNode(String data) {
		ListNode node = new ListNode(data);			//�Ű������� data�� �� node�� ��
		if(head ==null) {
			head = node;
			node.prev = node;
			node.next = node;
		}else {
			ListNode current = head;				//head��带 current��� �ӽ� ����
			ListNode prev = current.prev;			//head.prev�� prev��� �ӽ� ����  �̰� �ΰ��� �� �ӽ������̴�
			
			node.prev = prev;						//���� ���� node�� prev �� head�� prev�� ��
			node.next = current;					//node�� next�� head�� ��
			current.prev = node;					//head�� prev�� node�� �̾���
			prev.next=node;							//������ �ִ� ��尡 ���ε��� ��带 ����Ű�� �� ���⿡�� �Ǿ� ��尡 node�� ��
			head=node;								//head�� node�� ��Ī�ϰ� �ٲ��� 
		}
	}		//�� ����� next �����Ͱ� ������ head ��带 ����Ű���� �� ���� �� ����� prev �����ʹ� null�� ����Ű�� �Ѵ�.
			//head ����� prev �����Ͱ� �� ��带 ����Ű�� �ϰ� �� ��带 head ��尡 �ǵ��� �Ѵ�.
	
	
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
			System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
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
			System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
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
			System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
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
			System.out.println("����� ������ �������� �ʽ��ϴ�.");
			
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
