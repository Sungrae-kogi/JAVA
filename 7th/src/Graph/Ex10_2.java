package Graph;

class StackNode{
	int data;
	StackNode link;
}

class LinkedStack{
	StackNode top;
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public void push(int item) {
		StackNode newNode = new StackNode();
		
		newNode.data = item;
		newNode.link = top;
		top=newNode;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Deleting Fail!! Linked Stack is empty");
			return 0;
		}
		else {
			int item = top.data;
			top=top.link;
			return item;
		}
	}
}

class QNode{
	int data;
	QNode link;
}

class LinkedQueue{	//Queue >> 선입 선출
	QNode front;
	QNode rear;
	
	public LinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public void enQueue(int item) {
		QNode newNode = new QNode();
		newNode.data=item;
		newNode.link=null;
		if(isEmpty()) {	//Queue에 새로운 노드를 추가하는 과정인데 만일 아무것도 없다면, 즉 enQueue하는 큐가 첫번째 큐가 된다면
			front=newNode;
			rear=newNode;
		}else {
			rear.link=newNode;
			rear=newNode; 		//newNode가 rear의 맨 뒤로 갔으니까 그 newNode가 rear 가 되어야 함.
		}
	}
	
	//deQueue method Queue니까 front에서 빠져나가는 과정, 리턴값으로 빠져나올 노드가 가진 int 값의 데이터
	public int deQueue() {
		
		//빈 Queue라면, 
		if(isEmpty()) {
			System.out.println("Deleting Fail!! Linked Queue is Empty!");
			return 0;
		}else {
			int item = front.data;
			front=front.link;
			if(front==null) {		//front==null이라면 아무것도 없는 빈 큐가 된거니까 rear도 null로
				rear = null;
			}
			return item;
		}
		
	}
}

//vertex는 그래프의 순위 값
class GraphNode{
	int vertex;
	GraphNode link;
}

class AdjList{
	GraphNode head[] = new GraphNode[10];
	private int totalV=0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1, int v2) {
		if(v1>=totalV || v2>=totalV) {
			System.out.println("그래프에 없는 정점입니다.");
		}else {
			//새로운 gNode를 생성해서 head[v1]자리에 gNode가 들어가게 함. 그리고 head[v1]을 gNode로 지정
			GraphNode gNode = new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
		}
	}
	
	//AdjList 출력 메소드
	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for(int i=0; i<totalV; i++) {
			System.out.printf("\n정점 %d의 인접리스트 ", i);
			//gNode가 탐색 변수가 되는거고 i번째 head 배열을 탐색할거니까 gNode를 head[i]로 지정함, 즉 출발점을 선언해주는거
			gNode = head[i];
			while(gNode != null) {
				System.out.printf("-> %d", gNode.vertex);
				gNode = gNode.link;
			}
		}
	}
	
	public void DFS(int v) {
		GraphNode w = new GraphNode();
		LinkedStack S = new LinkedStack();
		boolean visited[] = new boolean[10];	//전부 false로 자동 초기화
		S.push(v);	//방문할 정점 번호 v 를 일단 스택에 Push
		visited[v]=true;	//인자로 주어지면서 시작점이니 당연히 방문했다고 쳐야한다
		System.out.printf(" %d", v);
		
		//-----------------
		while(S.top != null) {	//Stack의 top이 null이면 종료 즉, **스택이 빌 때 까지**
			w=head[v];
			while(w != null) {
				//정점 v와 인접한 노드중 방문하지 않은 노드를 전부 스택에 push합니다.
				if(visited[w.vertex]==false) {
					S.push(w.vertex);
					visited[w.vertex]=true;
					System.out.printf(" %d", w.vertex);
					
					//--------------
					v=w.vertex;
					w=head[v];
				}
				else w=w.link;
			}
			v=S.pop();
		}
	}
	
	public void BFS(int v) {
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		
		visited[v] = true;
		System.out.printf(" %d", v);
		Q.enQueue(v);		//ex) 0을 Queue에 넣고 방문을 true
		//-------------------
		while(!Q.isEmpty()) {
			v=Q.deQueue();	// Queue를 deQueue하고  그 디큐한 노드와 인접한 노드중 방문하지 않은노드를 enQueue해줍니다.
			//-------------------
			for(w=head[v]; w!=null; w=w.link) {//head[v]에  연결된 노드들 중에
				if(visited[w.vertex]==false) {	//방문하지 않은 노드들을
					visited[w.vertex]=true;		//방문 처리하고 Queue에 넣어준다
					System.out.printf(" %d", w.vertex);
					Q.enQueue(w.vertex);	//방문하지 않은 노드들을 enQueue
				}
			}
		}
	}
}


public class Ex10_2 {
	public static void main(String[] args) {
		AdjList G9 = new AdjList();
		
		for(int i=0; i<7; i++)
			G9.insertVertex(i);
			
		G9.insertEdge(0,2);
		G9.insertEdge(0,1);
		G9.insertEdge(1,4);
		G9.insertEdge(1,3);
		G9.insertEdge(1,0);
		G9.insertEdge(2,4);
		G9.insertEdge(2,0);
		G9.insertEdge(3,6);
		G9.insertEdge(3,1);
		G9.insertEdge(4,6);
		G9.insertEdge(4,2);
		G9.insertEdge(4,1);
		G9.insertEdge(5,6);
		G9.insertEdge(6,5);
		G9.insertEdge(6,4);
		G9.insertEdge(6,3);
		System.out.printf("\n 그래프 G9의 인접리스트 :");
		G9.printAdjList();
		System.out.println();
		
		System.out.printf("\n\n 깊이우선탐색 >> ");
		G9.DFS(0);
		
		System.out.printf("\n\n 너비우선탐색 >> ");
		G9.BFS(0);
	}
}
