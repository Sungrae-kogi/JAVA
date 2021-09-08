
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
			//탐색 >> pivot값보다 큰 값이 있는가, 없으면 left를 증가그리고 다시 while
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			//만일 pivot값보다 조건에 맞는걸 찾았다면, 증감은 정지하고 탈출한 상태,
			//조건에 맞는걸 못찾았다면, left와ㅏ right은 각각 right과 left와 같은 값으로 되었다
			
			
			if(left<=right) {
				int temp = arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				
				left++;
				right--;
			}
		}while(left<=right);
		
		if(start<right)	//탐색실패라면 right은 start와 같은 값일것이다
			quick_Sort(arr,start,right);
		if(end>left)	//탐색실패라면 left는 end와 같은 값일 것이다. 쭈욱 증가시켜왔으니까
			quick_Sort(arr,left,end);
	}
	private static void output(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
