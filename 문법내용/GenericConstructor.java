//제네릭과 생성자

// 제네릭으로 생성자를 호출할 수 없다.

class Complex{
	int r;
	int i;

	Complex(){
		r=i=0;
	}

	Complex(int r, int i){
		this.r = r;
		this.i = i;
	}
}


//밑에 코드는 잘못된 상황
class Point<E>{
	E x;
	E y;

	point(){
		this.x = new E();
		this.y = new E();
	}

	void swap(){
		E tmp = x;
		x = y;
		y = tmp;
	}

	void Print(){
		System.out.println(x);
		System.out.println(y);
		System.out.println(x.getClass().getTypeName());
	}
}

//Point 클래스는 Complex 클래스를 내부에서 생성하려고 하나, 불가능, new E()같은 생성자를 내부에서 호출하는 게 불 가능
//제네릭형으로 생성자를 호출할 수 없다, 자바의 컴파일러는 생성자를 호출할 경우에는 아예 정해져있는 타입만 호출할 수 있다.


//제네릭으로 배열을 선언할 경우

public class Test{
	public static void main(String[] args){
		DataArr<Complex> da = new DataArr<Complex> (new Complex[10]);
		da.d[0] = new Complex(3,3);
		System.out.println(da.d[0].i);
	}
}

class Complex{
	int r;
	int i;

	Complex(){
		r=i=0;
	}
	Complex(int r, int i){
		this.r =r;
		this.i=i;
	}
}

class DataArr<E>{
	E[] d;
	int size;

	DataArr(E[] d){
		this.d=d;
		this.size=d.length;
	}
}

//너무많다,; 나중에 다시학습
