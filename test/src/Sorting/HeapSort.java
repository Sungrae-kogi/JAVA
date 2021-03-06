package Sorting;

public class HeapSort {
	
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,8,4,7,10,9,2,1,6,3};
		
		// maxheap으로 만드는 과정
		for(int i=arr.length/2-1; i>=0; i--) {
			heapify(arr, arr.length,i);
		}
		
		/*
		 * maxHeapify로 최대힙으로 만든 힙에서 루트, 최상단 노드는 최대값이다.
		 * 따라서 최상단 노드를 배열의 맨 마지막 원소와 교환함으로써 그 값은 정렬이 끝
		 * 교환되어 루트로 올라간 값을 알맞는 장소로 보내기 위한 heapify를 실행한다, 루트노드에서부터
		 * 대신 이때 heapfiy 호출은 배열의 크기가 -1 된 상태임에 주의, 맨 끝자리에 제일 큰 값을 둬서 정렬을 끝냈으니
		 * 그부분은 제외시키는것이다
		 */
		
		
		//sorting	루트와 끝자리를 교환 -> 루트에서 다시 heapify 반복
		for(int i=arr.length-1; i>=0; i--) {
			swap(arr, i, 0);			
			heapify(arr, i-1, 0);
			
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	
	public static void heapify(int[] arr, int size, int pNode) {
		int parent = pNode;
		int lNode = pNode*2+1;
		int rNode = pNode*2+2;
		
		//두 자식노드 중 큰값을 parent에 넣어야함
		if(size > lNode && arr[parent] < arr[lNode]) {
			parent = lNode;
		}
		if(size > rNode && arr[parent] < arr[rNode]) {
			parent = rNode;
		}
		
		//자식노드 들 중 하나와 교환을 했다고 한다면
		if(parent != pNode) {
			swap(arr, pNode, parent);
			heapify(arr, size, parent);	//교환한 자식부분에서 다시 heapify
		}
	}
}
