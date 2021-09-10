package Generic;

public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name=name;
		students = (T[])(new Object[capacity]);	//Ÿ�� �Ķ���ͷ� �迭�� �����Ϸ��� new T[n]���·� �����Ұ��ؼ�
	}
	
	public String getName() {return name;}
	public T[] getStudents() {return students;}
	
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] ==null) {	//�迭�� ���ڸ��� �߰��� t�� ����
				students[i]=t;
				break;
			}
		}
	}
	
}
