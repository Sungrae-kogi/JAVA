package backJoon;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int i;
		
		for(i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		//----------------¼ö¿­ ÁÖ¾îÁü
		int leng=1;
		
		do {
			for(i=N-1; i>=0; i--) {
				if(num[i]-num[i-leng] != num[i-leng]-num[i-2*leng])
					leng++;
				
			}
		}while(i<=0);
		
		System.out.println(leng);
	}	
}