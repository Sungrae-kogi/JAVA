package DataStructure;

public class Ex3_17 {
	public static void main(String[] args) {
		System.out.println("- main method start!");
		int cnt;
		cnt = printCh('*',10);
		System.out.println("문자"+cnt+"개 출력");
		System.out.println("- main method end");
	}
	
	static int printCh(char ch, int num) {
		System.out.println("- printCh method start!");
		int i;
		for(i=0; i<num; i++)
			System.out.print(ch);
		System.out.println();
		System.out.println("- printCh method end!");
		
		return i;
	}
}
