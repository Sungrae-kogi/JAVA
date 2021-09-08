package DataStructure;

public class CircularList {
	private ListNode CL;
	
	//���� ��ȯ����Ʈ ���� , �ϴ� �� ����Ʈ�� CL�� �ʱ�ȭ
	public CircularList() {
		this.CL = null;
	}
	
	void insertLastNode(String str) {
		ListNode node = new ListNode(str);	//����Ʈ ����� ��ü node�� ������
		if(CL == null) {	//�� ����Ʈ���  ������ node ����Ʈ�� �ּҸ� ����
			CL = node;
			node.next = node;
		}else {
			ListNode current = CL;
			while(current.next!=CL) {	//������ ��尡 �ɶ����� ��� �̵���Ŵ
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
	}
	
	
	//ù��° ��忡 ����
	void insertFirstNode(String str) {
		ListNode node = new ListNode(str);
		if(CL == null) {
			CL = node;
		}else {
			ListNode current = CL;
			while(current.next!=CL) {
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
			CL=node;
		}
	}
	
	
	//�߰� ��忡 ����
	
	void insertMiddleNode(ListNode pre, String str) {
		ListNode node = new ListNode(str);
		if(CL == null) {
			CL=node;
		}else {
			ListNode current = CL;
			while(current.next!=pre) {
				current=current.next;
			}
			current=current.next;
			node.next = current.next;
			current.next=node;
		}
	}
	
	//������ ��� ����
	void deleteLastNode() {
		if(CL==null) {		//����Ʈ�� �� ����Ʈ���
			System.out.println("���� ��尡 �������� �ʽ��ϴ�.");
		}else { 	//�� ����Ʈ�� �ƴ϶��
			ListNode prev = CL;							//���� ��ĭ ������ �� ��带 prev �� current �� ������
			ListNode current = CL.next;
			while(current.next!=CL) {					//current node �� ������ ��尡 �ɶ�����, �׸��� prev�� ����������� ����
				prev = current;
				current = current.next;
			}
			prev.next = current.next;					/*current.next �� �� �� ��带 ����Ų�� �װŸ� prev.next���� �ش�.
														�׷��� ����Ʈ���� current node�� �����Ȱſ� ���������̴�. */
		}
	}
	
	//ù��° ��� ����
	void deleteFirstNode() {
		if(CL ==null) {
			System.out.println("���� ��尡 �������� �ʽ��ϴ�.");
		}else {
			ListNode current = CL;
			while(current.next!=CL) {
				current=current.next;
			}
			ListNode old = current.next;
			CL = old.next;			//old�� �� �� ��带 ����Ű�Ը���� �ι�° ��� = old.next�� �ּҸ� CL���ٰ� �����ν� �Ǿճ�尡 �����Ȱŷ�
			current.next = CL;		//�� �Ŀ� ������ ��忴�� current�� �� ��° ��尡 �� CL�� �̾������ν� �� �� ��尡 ������
		}
	}
	
	//�߰� ��� ����
	void deleteMiddleNode(String str) {
		ListNode node = new ListNode(str);
		if(CL ==null) {
			System.out.println("���� ��尡 �������� �ʽ��ϴ�.");
		}else {
			ListNode prev = CL;
			ListNode current = CL.next;
			while(current.data!=node.data) {		//ã���� �ϴ� �����Ͱ� �ִ� ��带 �߰��ϸ� 
				prev = current;						
				current = current.next;
			}
			prev.next = current.next;				//ã������� ������� prev�� next�� ã����� current�� next�� �ٲ�. �׷� ������ ȿ��
		}
	}
	
	ListNode searchNode(String str) {
		ListNode node = new ListNode(str);
		if(CL ==null) {
			System.out.println("ã���� �ϴ� ��尡 �����ϴ�.");
			return null;
		}else {
			ListNode current = CL;
			while(current.data!=node.data) {
				current=current.next;
			}
			return current;
		}
	}
	
	void printList() {
		if(CL ==null) {
			System.out.println("����� ����Ʈ�� �������� �ʽ��ϴ�.");
		}else {
			ListNode current = CL;				//current������ ����Ʈ CL�� �� ù��°�� ��
			System.out.print("[");;
			while(current.next!=CL) {			//current������ ����Ʈ�� ������ ��尡 �ɶ����� �ݺ��Ѵ�
				System.out.print(current.data + "");;	//�̵��ϸ鼭 �湮�ϴ� ����� data�� ����Ѵ�
				current = current.next;			//�׸��� ��ĭ ������ �̵�
			}
			System.out.print(current.data);		//current�� ������ ��尡 �Ǿ���, �׷��� data�� ����Ѵ�
			System.out.print("]");
			System.out.println();
		}
	}
}
