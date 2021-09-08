package Queue;

class DQNode{
	char data;
	DQNode llink;
	DQNode rlink;
}

class DQueue{
	DQNode front;
	DQNode rear;
	
	public DQueue() {	//DQueue의 생성자, front와 rear이라는 DQueue의 주소를 가리키는 변수를 null로 초기화
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front==null);
	}
	
	public void insertFront(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.llink = null;
			newNode.rlink = null;
		}else {
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		System.out.println("Front Inserted Item : " + item);
	}
	
	public void insertRear(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink=null;
			newNode.llink=null;
		}else {
			rear.rlink=newNode;
			newNode.rlink=null;
			newNode.llink=rear;
			rear = newNode;
		}
		System.out.println("Rear Inserted Item : " + item);
	}
	
	public char deleteFront() {
		if(isEmpty()) {
			System.out.println("Front Deleting fail!! DQ is empty");
			return 0;
		}else {
			char item = front.data;
			//DQ에 하나만 있는 경우.  >> front.rlink = null인 경우
			if(front.rlink == null) {
				front = null;
				rear = null;
			}else {
				front = front.rlink;
				front.llink = null;
			}
			return item;
		}
	}
	
	
	public char deleteRear() {
		if(isEmpty()) {
			System.out.println("Rear deleting fail!! DQ is empty");
			return 0;
		}else {
			char item = rear.data;
			//DQ에 하나만 있는 경우 >> rear.llink=null인 경우
			if(rear.llink ==null) {
				front = null;
				rear =null;
			}else {
				rear=rear.llink;
				rear.rlink = null;
			}
			return item;
		}
	}
	
	public void removeFront() {
		if(isEmpty()) {
			System.out.println("Front removing fail!! DQ is empty");
		}else {
			if(front.rlink ==null) {
				front = null;
				rear=null;
			}else {
				front = front.rlink;
				front.llink=null;
			}
		}
	}
	
	public void removeRear() {
		if(isEmpty()) {
			System.out.println("Rear removing fail!! DQ is empty");
		}else {
			if(rear.llink==null) {
				front=null;
				rear=null;
			}else {
				rear=rear.llink;
				rear.rlink=null;
			}
		}
	}
	
	public char peekFront() {
		if(isEmpty()) {
			System.out.println("Front peeking fail!! DQ is empty");
			return 0;
		}else {
			return front.data;
		}
	}
	
	public char peekRear() {
		if(isEmpty()) {
			System.out.println("Rear peeking fail!! DQ is empty");
			return 0;
		}else {
			return rear.data;
		}
	}
	
	public void printDQueue() {
		if(isEmpty()) {
			System.out.printf("DQueue is Empty!! %n %n");
		}else {
			DQNode temp = front;
			System.out.printf("DQueue >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp=temp.rlink;
			}
			System.out.println();
			System.out.println();
		}
	}
}

public class Ex8_4 {
	public static void main(String[] args) {
		char deletedItem;
		DQueue DQ = new DQueue();
		
		DQ.insertFront('A');
		DQ.printDQueue();
		
		DQ.insertFront('B');
		DQ.printDQueue();
		
		DQ.insertRear('C');
		DQ.printDQueue();
		
		deletedItem = DQ.deleteFront();
		if(deletedItem != 0)
			System.out.println("Front deleted Item : " + deletedItem);
		DQ.printDQueue();
		
		deletedItem = DQ.deleteRear();
		if(deletedItem != 0)
			System.out.println("Rear deleted Item : " + deletedItem);
		DQ.printDQueue();
		
		DQ.insertRear('D');
		DQ.printDQueue();
		
		DQ.insertFront('E');
		DQ.printDQueue();
		
		DQ.insertFront('F');
		DQ.printDQueue();
	}
}
