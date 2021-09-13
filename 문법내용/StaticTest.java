public class StaticTest{
	public static void main(String[] args){
		Static.all_sumf();
		Static.all_sumf();

		Static st1 = new Static();
		st1.each_sumf();
		st1.all_sumf();

		Static st2 = new Static();
		st2.each_sumf();
		st2.all_sumf();
	}
}

class Static{
	private static int all_sum = 0;
	private int each_sum = 0;

	public static void all_sumf(){
		all_sum = all_sum+1;
		System.out.prinln("all_sum "+all_sum);
	}

	public void each_sumf(){
		each_sum = each_sum+1;
		System.out.println("each_sum "+each_sum);
	}
}


//출력이 1 -> 2 -> 1 -> 3 -> 1 ->4로 나온다, static 선언된 변수는 전 클래스에 공용 지금 위의 예제는
//예시로 이해해보자면 자동차의 시리얼넘버로 사용 할 수 있다 좀 변형하면 ( 생성자에 증감을넣으면 되지않을까) 

++ 9/13 추가내용
ex)
class Foo{
	public static String classVar = "I class var";
	public String instanceVar = "I instance var";
	//정적 메소드 선언
	public static void classMethod(){
		System.out.println(classVar); //정적변수에 접근 -> OK
		System.out.println(instanceVar); //일반변수에 접근 -> 에러발생
	}

	public void instanceMethod(){
		System.out.println(classVar); //정적변수에 접근 -> OK
		System.out.println(instanceVar); //일반변수에 접근 -> OK
	}
}

public class StaticApp{
	public static void main(String[] args){
		System.out.println(Foo.classVar); // OK
		System.out.println(Foo.instanceVar); //Error 객체 생성해서 접근해야함

		Foo f1 = new Foo(); //하면 인스턴스가 생성 f1이라는
		//instanceVar 라는건 f1이라는 객체를 생성하고 나서 그 안에 생성이 됨, 값이 있다면 값을 할당
		//class 에 연결되어있지않기 때문에 f1객체의 instanceVar를 변경할지라도 클래스자체?의 instanceVar가 변하지않음
	}
}


