package DataStructure;

public class Test {
	public static void main(String[] args) {
		CircularList list = new CircularList();
		System.out.println("(1) ���� ����Ʈ�� ��� 3�� �����ϱ�.");
		list.insertLastNode("��");
		list.insertLastNode("��");
		list.insertLastNode("��");
		list.printList();
		
		System.out.println("(2) \"��\"��� �ڿ� \"��\" ��� �����ϱ�.");
		ListNode pre = list.searchNode("��");
		
		//
		if(pre == null) {
			System.out.println("�˻� ���� >> ã�� �����Ͱ� �����ϴ�.");
		}else {
			list.insertMiddleNode(pre,"��");
		}
		list.printList();
		
		System.out.println("(3) ����Ʈ�� ù��° ��� �߰��ϱ�");
		list.insertFirstNode("��");
		list.printList();
		
		System.out.println("(4) ����Ʈ�� ������ ���  �����ϱ�.");
		list.deleteLastNode();
		list.printList();
		
		System.out.println("(5) ����Ʈ�� �߰� ��� \"��\" �����ϱ�.");
		list.deleteMiddleNode("��");
		list.printList();
		
		System.out.println("(6) ����Ʈ�� ù��° ��� �����ϱ�.");
		list.deleteFirstNode();
		list.printList();
	}
}
