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
			a[j]=temp;	//j는 찾은 자리가 됨, 이 코드는 a 배열의 찾은 자리에 temp를 옮겨라 라는 뜻
			System.out.printf("\n삽입정렬 %d 단계 : ", i);
			for(t=0; t<size; t++) {
				System.out.printf("%3d ",  a[t]);
			}
		}
		System.out.println();
	}
	
	//----------------------------------------
	public void intervalSort(int a[], int begin, int end, int interval) {
		int i, j , item;
		for(i=begin+interval; i<=end; i=i+interval) {	//그룹의 갯수만큼
			item=a[i];
			for(j=i-interval; j>=begin && item<a[j]; j-=interval) {	//같은 그룹 내에 item보다 큰게 있다면 
				a[j+interval]=a[j];	//그 큰값을 위로 올림 for문이니까 계속 올라간다.
			}
			a[j+interval]=item;
		}
	}
	
	public void shellSort(int a[], int size) {
		int i, j, interval, t=0;
		interval = size/2;
		while(interval>=1) {
			for(i=0; i<interval; i++)		//첫 interval 4니까 4개의 그룹이 생긴다, 그후엔 2가되서 2개의 그룹이 생긴다.
				intervalSort(a, i, size-1, interval);	//그 갯수의 그룹을 각각 정렬하는 함수
			
			System.out.printf("\n셸 정렬 %d 단계 : interval = %d >>", ++t, interval);
			
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
		int j=middle+1;				//merge는 두 그룹의 합병이니까, middle+1은 두번째 그룹의 시작점을 의미한다.
		int k=m;					//시작지점을 가리키는 변수	sorted배열에서 사용할 것이다
		int t;
		while(i<=middle && j<=n) {	//탈출조건, i 또는 j 탐색변수가 그룹의 끝에 도달하지 않았다면
			
			if(a[i]<=a[j])			//첫그룹과 두번째 그룹의 시작부분을 비교한다, 그래서 뒤에께 크다면 정렬된  상태
				sorted[k]=a[i++];	//따라서 sorted[k] 즉 k는 m이었으니까 시작점, 정렬 완료하고 i를 늘림 
									//i는 첫 그룹의 시작점이니까, 그 다음번의 친구를 불러온다 i++
			else		//그게 아니라 j가 더 작았다면, i와 j의 값 정렬이 안되있으니 sorted[k]에는 a[j]값이 들어간다.
				sorted[k]=a[j++];
			k++;	
		}
		
		//앞 그룹이 전멸했다면!!! i가 middle+1이상인 경우니까 앞그룹을 싹다 뽑았다는것
		if(i>middle) {	
			for(t=j; t<=n; t++,k++)		//뒷 그룹의 나머지들을 싹다 sorted 배열에 집어넣는다 이때 j는 그 정렬된상태의 j값
				sorted[k]=a[t];
		}else {		//그게아니라 뒷그룹이 전멸한 상태였다!!! 라고 한다면 ,앞그룹의 남은 값들을 배열에 집어넣는다
			for(t=i; t<=middle; t++, k++)
				sorted[k]=a[t];
		}
		//남은 값들을 배열에 집어넣는 연산
		
		
		//다시 옮기는 작업
		for(t=m; t<=n; t++)
			a[t] = sorted[t];
		System.out.printf("\n 병합 정렬 >> ");
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
		System.out.printf("\n정렬할 원소 : ");
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
