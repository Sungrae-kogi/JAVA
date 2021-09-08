package Sort;

import java.util.LinkedList;

class Sort{
	public void insertionSort(int[] a, int size) {
		int i, j, t, temp;
		for(i=1; i<size; i++) {
			temp=a[i];
			j=i;
			while((j>0) && (a[j-1]>temp)) {
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;	//j�� ã�� �ڸ��� ��, �� �ڵ�� a �迭�� ã�� �ڸ��� temp�� �Űܶ� ��� ��
			System.out.printf("\n�������� %d �ܰ� : ", i);
			for(t=0; t<size; t++) {
				System.out.printf("%3d ",  a[t]);
			}
		}
		System.out.println();
	}
	
	//----------------------------------------
	public void intervalSort(int a[], int begin, int end, int interval) {
		int i, j , item;
		for(i=begin+interval; i<=end; i=i+interval) {	//�׷��� ������ŭ
			item=a[i];
			for(j=i-interval; j>=begin && item<a[j]; j-=interval) {	//���� �׷� ���� item���� ū�� �ִٸ� 
				a[j+interval]=a[j];	//�� ū���� ���� �ø� for���̴ϱ� ��� �ö󰣴�.
			}
			a[j+interval]=item;
		}
	}
	
	public void shellSort(int a[], int size) {
		int i, j, interval, t=0;
		interval = size/2;
		while(interval>=1) {
			for(i=0; i<interval; i++)		//ù interval 4�ϱ� 4���� �׷��� �����, ���Ŀ� 2���Ǽ� 2���� �׷��� �����.
				intervalSort(a, i, size-1, interval);	//�� ������ �׷��� ���� �����ϴ� �Լ�
			
			System.out.printf("\n�� ���� %d �ܰ� : interval = %d >>", ++t, interval);
			
			for(j=0; j<size; j++)
				System.out.printf("%d	", a[j]);
			System.out.println();
			interval/=2;
		}
	}
	
	//----------------------------------------------
	private int sorted[] = new int[30];
	
	public void merge(int a[], int m, int middle, int n) {
		int size = a.length;
		int i=m;
		int j=middle+1;				//merge�� �� �׷��� �պ��̴ϱ�, middle+1�� �ι�° �׷��� �������� �ǹ��Ѵ�.
		int k=m;					//���������� ����Ű�� ����	sorted�迭���� ����� ���̴�
		int t;
		while(i<=middle && j<=n) {	//Ż������, i �Ǵ� j Ž�������� �׷��� ���� �������� �ʾҴٸ�
			
			if(a[i]<=a[j])			//ù�׷�� �ι�° �׷��� ���ۺκ��� ���Ѵ�, �׷��� �ڿ��� ũ�ٸ� ���ĵ�  ����
				sorted[k]=a[i++];	//���� sorted[k] �� k�� m�̾����ϱ� ������, ���� �Ϸ��ϰ� i�� �ø� 
									//i�� ù �׷��� �������̴ϱ�, �� �������� ģ���� �ҷ��´� i++
			else		//�װ� �ƴ϶� j�� �� �۾Ҵٸ�, i�� j�� �� ������ �ȵ������� sorted[k]���� a[j]���� ����.
				sorted[k]=a[j++];
			k++;	
		}
		
		//�� �׷��� �����ߴٸ�!!! i�� middle+1�̻��� ���ϱ� �ձ׷��� �ϴ� �̾Ҵٴ°�
		if(i>middle) {	
			for(t=j; t<=n; t++,k++)		//�� �׷��� ���������� �ϴ� sorted �迭�� ����ִ´� �̶� j�� �� ���ĵȻ����� j��
				sorted[k]=a[t];
		}else {		//�װԾƴ϶� �ޱ׷��� ������ ���¿���!!! ��� �Ѵٸ� ,�ձ׷��� ���� ������ �迭�� ����ִ´�
			for(t=i; t<=middle; t++, k++)
				sorted[k]=a[t];
		}
		//���� ������ �迭�� ����ִ� ����
		
		
		//�ٽ� �ű�� �۾�
		for(t=m; t<=n; t++)
			a[t] = sorted[t];
		System.out.printf("\n ���� ���� >> ");
		for(t=0; t<size; t++)
			System.out.printf("%3d ",  a[t]);
	}
	
	//-------------------------------------------------------
	public void mergeSort(int a[], int low, int high) {
		int middle;
		if(low<high) {
			middle=(low+high)/2;
			mergeSort(a,low,middle);
			mergeSort(a,middle+1,high);
			merge(a,low,middle,high);
		}
	}
	
}


public class Ex11_4 {
	public static void main(String[] args) {
		int a[] = {69,10,30,2,16,8,31,22};
		int a2[] = {69,10,30,2,16,8,31,22};
		
		int size = a.length;
		Sort S = new Sort();
		System.out.printf("\n������ ���� : ");
		for(int i=0; i<a.length; i++) {
			System.out.printf(" %d", a[i]);
		}
		System.out.println();
		S.mergeSort(a, 0, size-1);
		
		System.out.println();
		S.shellSort(a2, size);
		
		System.out.println();
		
	}
}
