package Sorting;

public class MySort {

	
	public void quickSort(int[] a, int p, int r) {
		if(p <r) {
			int pivot = partition(a,p,r);
			
			quickSort(a,p,pivot-1);
			quickSort(a,pivot+1,r);
		}
	}
	
	public int partition(int[] a, int p, int r) {
		int tpivot = a[(p+r)/2];
		
		while(p <=r) {
			while(a[p] < tpivot) {
				p++;
			}
			while(a[r] > tpivot) {
				r--;
			}
			if(p<=r) {
				swap(a,p,r);
				p++;
				r--;
			}
		}
		return p;
	}
	
	public void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j]=tmp;
	}
	
	public static void main(String[] args) {
		MySort s = new MySort();
		
		int[] test = {40,20,50,10,30,70};
		
		s.quickSort(test,  0,  test.length-1);
		
		for(int i=0; i<test.length; i++) {
			System.out.printf(test[i]+" ");
		}
		System.out.println();
	}
}
