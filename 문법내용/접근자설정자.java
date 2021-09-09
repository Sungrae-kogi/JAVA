public class Unit{
	private String name;
	private int HP;
	private int MP;

	public Unit(String name, int MP, int HP){
		this.name =name;
		this.MP = MP;
		this.HP = HP;
	}

	public void ShowAttribute(){
		System.out.println(name+","+HP+","+MP);
	}
	
	//접근자 get private으로 설정된 내부변수의 값을 얻기위해 사용
	public String getName(){
		return name;
	}
	//설정자 set private으로 설정된 내부변수의 값을 설정하기위해 사용
	public void setName(String name){
		this.name = name;
	}

	//모든 속성에 접근자와 설정자가 있을 필요는 없다, 위의 코드에서는 Name 변수에만 접근자,설정자를 적용
	//이는 문법적인요소가 아닌 오랜기간 프로그래머들 끼리 사용한 약속이다
}
