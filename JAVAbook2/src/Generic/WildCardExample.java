package Generic;

import java.util.Arrays;

public class WildCardExample {
	
	//수강생의 타입이 4가지가 있고 최상위가 Person, 밑에가 Worker,Student, Student의 하위에 HighStudent라고 할때
	//Course<?> 모든 과정이 등록 가능하다
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName()+"수강생: "+Arrays.toString(course.getStudents()));
	}
	/*
	//<? extends Student>는 Student와 그 하위인 HighStudent만 가능
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName()+"수강생: "+Arrays.toString(course.getStudents()));
	}
	
	//<? super Worker> 는 super란 단어만 봐도 뭔가 느낌오듯이 Worker와 그 상위만 등록 가능
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName()+"수강생: "+Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
	}
	*/
}
