package DataStructure;

public class Ex3_16 {
	public static void main(String[] args) {
		System.out.println("- main method start");
		
		printCh('*',10);
		
		System.out.println("- main method end");
	}
	
	static void printCh(char ch, int num) {
		System.out.println("- printCh method start!");
		for(int i=0; i<num; i++)
			System.out.print(ch);
		System.out.println();
		System.out.println("- printCh method end");
	}
}
