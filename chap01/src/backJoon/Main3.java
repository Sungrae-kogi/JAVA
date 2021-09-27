package backJoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//�迭 �������� ����� Collections.reverseOrder�� Integer Ÿ�Կ� ����.;
		Integer[] num = new Integer[N];
		
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		
		//�迭�̳� ����Ʈ ���Ľÿ� �����ϰ� �޼ҵ� ȣ��� ���İ���.
		Arrays.sort(num, Collections.reverseOrder());
		/*
		//���� �����´��ڵ� ���ϱ� �������ķ� �ѰŰ���.
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
	//�� ���� �ٲٴ� ���� ���, �ӽú����ּ� �ٲٱ� 
	public static void change(int a, int b, int[] num) {
		int tmp=0;
		tmp = num[a];
		num[a]=num[b];
		num[b]=tmp;
	}
}
