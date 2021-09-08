
public class quicksort {
	public static void main(String[] args) {
		int[] arr= {10,50,80,90,70};
		
		quick_Sort(arr,0,arr.length-1);
		output(arr);
	}
	
	private static void quick_Sort(int[] arr, int start, int end) {
		int left= start;
		int right=end;
		int pivot = arr[(left+right)/2];
		
		do {
			//Ž�� >> pivot������ ū ���� �ִ°�, ������ left�� �����׸��� �ٽ� while
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			//���� pivot������ ���ǿ� �´°� ã�Ҵٸ�, ������ �����ϰ� Ż���� ����,
			//���ǿ� �´°� ��ã�Ҵٸ�, left�ͤ� right�� ���� right�� left�� ���� ������ �Ǿ���
			
			
			if(left<=right) {
				int temp = arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				
				left++;
				right--;
			}
		}while(left<=right);
		
		if(start<right)	//Ž�����ж�� right�� start�� ���� ���ϰ��̴�
			quick_Sort(arr,start,right);
		if(end>left)	//Ž�����ж�� left�� end�� ���� ���� ���̴�. �޿� �������ѿ����ϱ�
			quick_Sort(arr,left,end);
	}
	private static void output(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
