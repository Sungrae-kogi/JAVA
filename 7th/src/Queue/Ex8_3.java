package Queue;

class QNode{
	char data;
	QNode link;
}


class LinkedQueue implements Queue{
	QNode front;
	QNode rear;
	
	public LinkedQueue() {
		front =null;
		rear = null;
	}
	
	public boolean isEmpty() {
		if(front==null)
			return true;
		else
			return false;
	}
	
	public void enQueue(char item) {
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}else {				// 빈 노드가 아니라면 rear 즉, 맨 뒷 노드의 link가 null이니까 그거를 enwNode로 연결해줌
			rear.link = newNode;
			rear = newNode;
		}
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("LinkedQueue is empty!!");
			return 0;
		}else {						// Linked에서는 빠지게 했지만 그 뒷 처리가 빠져있음.
			char item = front.data;
			front = front.link;
			if(front==null)
				rear = null;
			return item;
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("LinkedQueue is empty!!");
		}else {
			front = front.link;
			if(front == null)
				rear = null;
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("LinkedQueue is Empty!!");
			return 0;
		}else {
			char item = front.data;
			front = front.link;
			if(front ==null)
				rear = null;
			
			return item;
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("LinkedQueue is Empty!!");
		}else {
			QNode temp = front;
			System.out.printf("LinkedQueue >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp=temp.link;
			}
			System.out.println();
			System.out.println();
		}
	}
}


public class Ex8_3 {
	public static void main(String[] args) {
		char deletedItem;
		LinkedQueue LQ = new LinkedQueue();
		
		LQ.enQueue('A');
		LQ.printQueue();
		
		LQ.enQueue('B');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem !=0)
			System.out.println("deleted Item: "+deletedItem);
		LQ.printQueue();
		
		LQ.enQueue('C');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem !=0)
			System.out.println("deleted Item: "+deletedItem);
		LQ.printQueue();
	}
}
