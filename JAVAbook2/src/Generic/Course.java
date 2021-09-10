package Generic;

public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name=name;
		students = (T[])(new Object[capacity]);	//타입 파라미터로 배열을 생성하려면 new T[n]형태로 생성불가해서
	}
	
	public String getName() {return name;}
	public T[] getStudents() {return students;}
	
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] ==null) {	//배열의 빈자리에 추가된 t를 넣음
				students[i]=t;
				break;
			}
		}
	}
	
}
