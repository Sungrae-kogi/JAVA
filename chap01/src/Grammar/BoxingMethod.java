package Grammar;

class Box<T>{
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t=t;
	}
}


class Util{
	public static <T>Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
}


public class BoxingMethod {
	public static void main(String[] args) {
		Box<Integer> box1 = Util.boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 = Util.boxing("ȫ�浿");
		String strValue = box2.get();
		
		System.out.println(intValue+" "+strValue);
	}
}
