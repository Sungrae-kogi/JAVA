package backJoon;

import java.util.Scanner;

public class Main1924 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] yoil = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;
				
		//3���̸� 1��2���� ��ü �ϼ��� ���ؾ���
		for(int i=0; i<x; i++) {
			sum=sum+day[i];
		}
		sum=sum+y;
		
		//������ 7���ϱ�!!
		sum=sum%7;
		System.out.println(yoil[sum]);
		
		
	}
}
