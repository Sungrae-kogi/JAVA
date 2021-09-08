package Grammar;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] res = new int[T];
		int max = 0;
		int[][] d= new int[T+1][T+1];
		
		for(int i=1; i<=T; i++) {
			for(int j=1; j<=i; j++) {
				d[i][j]=sc.nextInt();
				System.out.println("d[i][j]값을 입력함 : "+d[i][j]);
				if(j==1) {
					d[i][j]=d[i-1][j]+d[i][j];
					System.out.println("d[i][j] 현재 : "+d[i][j]);
				}else if(j==i) {
					d[i][j]=d[i-1][j-1]+d[i][j];
					System.out.println("d[i][j] 현재 : "+d[i][j]);
				}else {
					d[i][j]=Math.max(d[i-1][j-1], d[i-1][j])+d[i][j];
					System.out.println("Max 실행d[i][j] 현재 : "+d[i][j]);
				}
				if(max<d[i][j])
					max=d[i][j];
			}
		}
		System.out.println(max);
	}
}
