package Sort;

public class HeapSort {
	private static int[] data;
	private static int number =10;
	
	public static void heap(int[] data, int number) {
		for(int i=1; i<number; i++) {
			int child = i;
			while(child>0) {
				int parent = (child-1)/2;	//parent�� ��ȣ�� �˾Ƴ��� ����, / �� ��������
				if(data[child] > data[parent]) {
					swap(child,parent);
				}
				child = parent;
			}
		}
	}
	public static void swap(int a, int b) {
		int temp = data[a];
		data[a]=data[b];
		data[b]=temp;
	}
	
	public static void main(String[] args) {
	
		data = new int[number];
		for(int i=0; i<number; i++) {
			data[i] = (int)(Math.random()*100+1);	//1~������ ���� �������� �巷�� 10 ������ ����
		}
		
		System.out.print("������: ");
		for(int i=0; i<number; i++) {
			System.out.print(data[i]+" ");
		}

		
		System.out.println("�� ���ķ� Ʈ���� ������ ��");
		heap(data, number);
		for(int i=0; i<number; i++) {
			System.out.print(data[i]+" ");
		}
		
		
		
		for(int i= number-1; i>0; i--) {
			int temp = data[0];
			data[0]=data[i];
			data[i]=temp;
			
			heap(data,i);
		}
		
		System.out.print("\n���� ��:");
		for(int i=0; i<number; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
