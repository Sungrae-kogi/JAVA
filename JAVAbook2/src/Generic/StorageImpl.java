package Generic;

//제네릭 인터페이스인 Storage<T> 타입을 구현한 이 클래스도 제네릭 타입이어야 한다
public class StorageImpl<T> implements Storage<T> {
	private T[] array;

	public StorageImpl(int capacity) {
		this.array = (T[])(new Object[capacity]);
	}
	
	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		array[index] = item;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return array[index];
	}
	
}
