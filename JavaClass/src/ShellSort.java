import java.util.Arrays;

public class ShellSort {
	public static void intervalSort(int a[], int begin, int end, int interval) {
		int j;
		for(int i=begin+interval; i<=end; i=i+interval) {
			int item = a[i];
			for(j = i-interval; j>=begin && item<a[j]; j=j-interval) {
				a[j+interval] = a[j];
			}
			a[j+interval] = item;
		}
	}
	
	public static void shellSort(int[] a, int size) {
		System.out.println("정렬할 원소:"+Arrays.toString(a));
		System.out.println("----------------셸 정렬 수행------------");
		int interval = size/2;
		while(interval >=1) {
			for(int i=0; i<interval; i++) {
				intervalSort(a, i, size-1, interval);
			}
			System.out.println("interval="+interval);
			for(int t=0; t<size; t++) {
				System.out.print(a[t]+" ");
			}
			System.out.println();
			interval = interval/2;
		}
	}
	
	public static void main(String[] args) {
		int[] list = {16, 7, 30, 3, 69, 9, 31, 23};
		int size = list.length;
		shellSort(list, size);
	}
}
