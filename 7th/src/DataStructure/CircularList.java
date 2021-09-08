package DataStructure;

public class CircularList {
	private ListNode CL;
	
	//원형 순환리스트 선언 , 일단 빈 리스트인 CL을 초기화
	public CircularList() {
		this.CL = null;
	}
	
	void insertLastNode(String str) {
		ListNode node = new ListNode(str);	//리스트 노드의 객체 node를 생성함
		if(CL == null) {	//빈 리스트라면  생성한 node 리스트의 주소를 대입
			CL = node;
			node.next = node;
		}else {
			ListNode current = CL;
			while(current.next!=CL) {	//마지막 노드가 될때까지 계속 이동시킴
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
	}
	
	
	//첫번째 노드에 삽입
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
	
	
	//중간 노드에 삽입
	
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
	
	//마지막 노드 삭제
	void deleteLastNode() {
		if(CL==null) {		//리스트가 빈 리스트라면
			System.out.println("지울 노드가 존재하지 않습니다.");
		}else { 	//빈 리스트가 아니라면
			ListNode prev = CL;							//서로 한칸 떨어진 두 노드를 prev 와 current 로 지정함
			ListNode current = CL.next;
			while(current.next!=CL) {					//current node 가 마지막 노드가 될때까지, 그리고 prev는 마지막노드의 이전
				prev = current;
				current = current.next;
			}
			prev.next = current.next;					/*current.next 는 맨 앞 노드를 가리킨다 그거를 prev.next한테 준다.
														그러면 리스트에서 current node는 삭제된거와 마찬가지이다. */
		}
	}
	
	//첫번째 노드 삭제
	void deleteFirstNode() {
		if(CL ==null) {
			System.out.println("지울 노드가 존재하지 않습니다.");
		}else {
			ListNode current = CL;
			while(current.next!=CL) {
				current=current.next;
			}
			ListNode old = current.next;
			CL = old.next;			//old가 맨 앞 노드를 가리키게만들고 두번째 노드 = old.next의 주소를 CL에다가 줌으로써 맨앞노드가 삭제된거로
			current.next = CL;		//그 후에 마지막 노드였던 current를 두 번째 노드가 된 CL에 이어줌으로써 맨 앞 노드가 삭제됨
		}
	}
	
	//중간 노드 삭제
	void deleteMiddleNode(String str) {
		ListNode node = new ListNode(str);
		if(CL ==null) {
			System.out.println("지울 노드가 존재하지 않습니다.");
		}else {
			ListNode prev = CL;
			ListNode current = CL.next;
			while(current.data!=node.data) {		//찾고자 하는 데이터가 있는 노드를 발견하면 
				prev = current;						
				current = current.next;
			}
			prev.next = current.next;				//찾은노드의 이전노드 prev의 next를 찾은노드 current의 next로 바꿈. 그럼 삭제된 효과
		}
	}
	
	ListNode searchNode(String str) {
		ListNode node = new ListNode(str);
		if(CL ==null) {
			System.out.println("찾고자 하는 노드가 없습니다.");
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
			System.out.println("출력할 리스트가 존재하지 않습니다.");
		}else {
			ListNode current = CL;				//current변수를 리스트 CL의 맨 첫번째에 둠
			System.out.print("[");;
			while(current.next!=CL) {			//current변수가 리스트의 마지막 노드가 될때까지 반복한다
				System.out.print(current.data + "");;	//이동하면서 방문하는 노드의 data를 출력한다
				current = current.next;			//그리고 한칸 앞으로 이동
			}
			System.out.print(current.data);		//current가 마지막 노드가 되었어, 그러면 data를 출력한다
			System.out.print("]");
			System.out.println();
		}
	}
}
