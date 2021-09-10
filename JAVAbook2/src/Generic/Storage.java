package Generic;

/*제네릭 인터페이스를 구현한 클래스도 제네릭 타입이 된다, 다음과 같은 제네릭 인터페이스를 가정*/

public interface Storage<T> {
	public void add(T item, int index);
	public T get(int index);
}
