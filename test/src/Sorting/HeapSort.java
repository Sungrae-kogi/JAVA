package Sorting;

public class HeapSort {
	
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,8,4,7,10,9,2,1,6,3};
		
		// maxheap���� ����� ����
		for(int i=arr.length/2-1; i>=0; i--) {
			heapify(arr, arr.length,i);
		}
		
		/*
		 * maxHeapify�� �ִ������� ���� ������ ��Ʈ, �ֻ�� ���� �ִ밪�̴�.
		 * ���� �ֻ�� ��带 �迭�� �� ������ ���ҿ� ��ȯ�����ν� �� ���� ������ ��
		 * ��ȯ�Ǿ� ��Ʈ�� �ö� ���� �˸´� ��ҷ� ������ ���� heapify�� �����Ѵ�, ��Ʈ��忡������
		 * ��� �̶� heapfiy ȣ���� �迭�� ũ�Ⱑ -1 �� �����ӿ� ����, �� ���ڸ��� ���� ū ���� �ּ� ������ ��������
		 * �׺κ��� ���ܽ�Ű�°��̴�
		 */
		
		
		//sorting	��Ʈ�� ���ڸ��� ��ȯ -> ��Ʈ���� �ٽ� heapify �ݺ�
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
		
		//�� �ڽĳ�� �� ū���� parent�� �־����
		if(size > lNode && arr[parent] < arr[lNode]) {
			parent = lNode;
		}
		if(size > rNode && arr[parent] < arr[rNode]) {
			parent = rNode;
		}
		
		//�ڽĳ�� �� �� �ϳ��� ��ȯ�� �ߴٰ� �Ѵٸ�
		if(parent != pNode) {
			swap(arr, pNode, parent);
			heapify(arr, size, parent);	//��ȯ�� �ڽĺκп��� �ٽ� heapify
		}
	}
}
