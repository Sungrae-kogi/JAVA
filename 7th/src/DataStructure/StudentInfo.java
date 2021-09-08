package DataStructure;

public class StudentInfo {
	protected String dept, stdNo, name;
	StudentInfo(String dept, String stdNo, String name){
		this.dept = dept;
		this.stdNo = stdNo;
		this.name = name;
	}
	
	public void getStdInfo() {
		System.out.println("** info print **");
		System.out.println("학과: "+dept);
		System.out.println("학번: "+stdNo);
		System.out.println("이름: "+name);
	}
}
