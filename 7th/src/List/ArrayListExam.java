package List;

import java.util.ArrayList;

public class ArrayListExam {
	ArrayList<String> list = new ArrayList<String>(5);
	
	public void addItem() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		this.listPrint();
		
		list.remove(1);
		
		this.listPrint();
		
		list.add(0, "0");
		list.add(1, "1");
		
		this.listPrint();
	}
	
	public void listPrint() {
		System.out.println("size :"+list.size());
		System.out.println("list :"+list);
	}
	
	public static void main(String[] args) {
		ArrayListExam arrayListExam = new ArrayListExam();
		arrayListExam.addItem();
	}
}
