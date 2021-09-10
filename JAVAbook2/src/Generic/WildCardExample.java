package Generic;

import java.util.Arrays;

public class WildCardExample {
	
	//�������� Ÿ���� 4������ �ְ� �ֻ����� Person, �ؿ��� Worker,Student, Student�� ������ HighStudent��� �Ҷ�
	//Course<?> ��� ������ ��� �����ϴ�
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName()+"������: "+Arrays.toString(course.getStudents()));
	}
	/*
	//<? extends Student>�� Student�� �� ������ HighStudent�� ����
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName()+"������: "+Arrays.toString(course.getStudents()));
	}
	
	//<? super Worker> �� super�� �ܾ ���� ���� ���������� Worker�� �� ������ ��� ����
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName()+"������: "+Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("�Ϲ��ΰ���",5);
		personCourse.add(new Person("�Ϲ���"));
		personCourse.add(new Worker("������"));
		personCourse.add(new Student("�л�"));
		personCourse.add(new HighStudent("����л�"));
		
	}
	*/
}
