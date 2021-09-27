package backJoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//배열 내림차순 기능중 Collections.reverseOrder가 Integer 타입에 가능.;
		Integer[] num = new Integer[N];
		
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		
		//배열이나 리스트 정렬시에 간편하게 메소드 호출로 정렬가능.
		Arrays.sort(num, Collections.reverseOrder());
		/*
		//백준 내가냈던코드 보니까 버블정렬로 한거같다.
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(num[i]>num[j]) {
					change(i,j,num);
				}
			}
		}
		*/
		
		for(int i=0; i<N; i++) {
			System.out.println(num[i]);
		}
		
	}
	//두 개를 바꾸는 흔한 기능, 임시변수둬서 바꾸기 
	public static void change(int a, int b, int[] num) {
		int tmp=0;
		tmp = num[a];
		num[a]=num[b];
		num[b]=tmp;
	}
}
