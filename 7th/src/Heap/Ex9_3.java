package Heap;

class Heap{
	private int heapSize;
	private int itemHeap[];
	
	public Heap() {	//생성자
		heapSize = 0;
		itemHeap = new int[50];
	}
	
	public void insertHeap(int item) {
		int i= ++heapSize;
		while(i != 1 && item>itemHeap[i/2]) {
			itemHeap[i]=itemHeap[i/2];
			i /=2;
		}
		itemHeap[i] = item;
	}
	
	public int getHeapSize() {
		return this.heapSize;
	}
	
	public int deleteHeap() {
		int parent, child;
		int item, temp;
		item = itemHeap[1];		//삭제는 가장 맨 위에 힙이 삭제가 된다 그 값을 item에 저장
		temp = itemHeap[heapSize--];	//마지막 노드를 temp에 저장하고 heapSize는 1 줄인다
		parent =1;
		child = 2;
		
		while(child <= heapSize) {
			//자식중 더 큰 값을 고른다. 완전이진트리니까 child 와 child+1은 각각 parent 1의 왼쪽과 오른쪽
			if((child < heapSize) && (itemHeap[child] < itemHeap[child+1]))
				child++;
			//부모가 더 크면 빠져나온다
			if(temp >= itemHeap[child])	//맨 마지막 노드의 값이 맨 첫번째 노드의 자식노드들 보다 크다면, 맨 마지막노드가 맨 첫번째 자리가맞다
				break;
			
			//---여기까지 실행되면 자식중 더 큰 값이 골라져  child에 들어가 있다.
			//parent의 위치에 child를 올린다.
			
			itemHeap[parent] = itemHeap[child];
			parent = child;
			child *= 2;
		}
		itemHeap[parent] = temp;		// 맨 마지막 노드를 맨 첫번째 자리로 이동
		return item;
	}
	
	public void printHeap() {
		System.out.printf("\nHeap >>> ");
		for(int i=1; i<=heapSize; i++)
			System.out.printf("[%d] ", itemHeap[i]);
	}
}

public class Ex9_3 {
	public static void main(String[] args) {
		int n , item;
		Heap h = new Heap();
		
		h.insertHeap(13);
		h.insertHeap(8);
		h.insertHeap(10);
		h.insertHeap(15);
		h.insertHeap(20);
		h.insertHeap(19);
		
		h.printHeap();
		
		n=h.getHeapSize();
		for(int i=1; i<=n; i++) {
			item = h.deleteHeap();
			System.out.printf("\n deleted Item : [%d]", item);
		}
	}
}
