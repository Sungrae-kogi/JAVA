package backJoon;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int R;
		for(int i=0; i<T; i++) {
			R=sc.nextInt();
			String S = sc.next();
			System.out.println(S);
			for(int j=0; j<S.length(); j++){
				for(int k=0; k<R; k++) {
					//charAt�� string���� ����� ���ڿ� �߿��� �� ���ڸ� �����ؼ� char ������ �ٲ��ִ� ���
					System.out.print(S.charAt(j));
				}
			}
			
			System.out.println();
		}
	}
}
