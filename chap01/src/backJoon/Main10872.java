package backJoon;

import java.util.Scanner;

public class Main10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int sum=1;
		for(int i=2; i<N+1; i++) {
			sum=sum*i;
		}
		
		System.out.println(sum);
	}
}
