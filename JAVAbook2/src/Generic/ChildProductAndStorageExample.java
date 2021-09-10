package Generic;

public class ChildProductAndStorageExample {
	public static void mainI(String[] args) {
		ChildProduct<Tv, String, String> product = new ChildProduct<>();
		product.setKind(new Tv());
		product.setModel("SmartTV");
		//위에까지는 부모클래스의 Product의 내부 메소드를 사용
		product.setCompany("Samsung");
		//위에는 상속받은 ChildProduct의 내부 메소드를 사용
		
		//Tv객체를 담을 수 있는 Storage를 사이즈 100으로 생성
		Storage<Tv> storage = new StorageImpl<Tv>(100);
		//그 Storage의 인덱스 0 에 Tv 객체를 생성해서 대입
		storage.add(new Tv(), 0);
		//그리고 그 add했던 Tv 객체를 get으로 꺼내옴 꺼내서 Tv 타입 tv변수에 대입
		Tv tv = storage.get(0);
		
	}
}
