package Sort;

public class HeapSort {
	private static int[] data;
	private static int number =10;
	
	public static void heap(int[] data, int number) {
		for(int i=1; i<number; i++) {
			int child = i;
			while(child>0) {
				int parent = (child-1)/2;	//parent의 번호를 알아내는 연산, / 몫 연산으로
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
			data[i] = (int)(Math.random()*100+1);	//1~까지의 수중 랜덤으로 드렁감 10 가지의 수가
		}
		
		System.out.print("정렬전: ");
		for(int i=0; i<number; i++) {
			System.out.print(data[i]+" ");
		}

		
		System.out.println("힙 정렬로 트리를 나열한 후");
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
		
		System.out.print("\n정렬 후:");
		for(int i=0; i<number; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
