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
					//charAt은 string으로 저장된 문자열 중에서 한 글자만 선택해서 char 형으로 바꿔주는 기능
					System.out.print(S.charAt(j));
				}
			}
			
			System.out.println();
		}
	}
}
