package backJoon;

import java.util.Scanner;

public class Main1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int answer = n;
		
		for(int i=0; i<n; i++) {
			String word = sc.next();
			boolean[] check = new boolean[26];
			
			//시작점이 1idx라는거 주의 * 이전문자를 비교해야하니까
			for(int j=1; j<word.length(); j++) {
				if(word.charAt(j-1) != word.charAt(j)) {
					if(check[word.charAt(j)-97]==true) {
						answer--;
						break;
					}
					
					//이전알파벳과 같지않은데, 현재알파벳이 이미나왔던알파벳이 아니라면
					check[word.charAt(j-1)-97]=true;
				}
			}
		}
		
		System.out.println(answer);
	}
}
