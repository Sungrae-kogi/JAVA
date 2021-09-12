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
