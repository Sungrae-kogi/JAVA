/*	추 상 화
 *	추상화는 아래의 작동원리를 모르더라도 중간다리가 커넥션만 잘해준다면 프로그래머는 순수하게 코딩만 신경쓰면 된다
 *	추상화라는 것은 현대적인 컴퓨터 용어에서는 뭔가의 "계층과 꼐층을 직접적으로 연결하는 것"이 아닌!
 *	계층과 가층 사이에 한 계층을 추가로 두어서 한다리 걸쳐서 연결하는 것!!!~ 을 의미
 *
 *	자바는 추상화가 잘 진행되어있다, 여러 메소드와 여러 클래스들, 그 내부의 구동원리들은 딱히 알 필요없이
 *	직접적인 접근을 허용하게 되는데 이러한 것이 추상화이다
 *
 *	자바에서는 abstract 라는 키워드가 존재 이 여깃도 제어자의 일종
 *
 */


public abstract class Book{
	String name;
	int page;

	abstract void PrintBookName();	//어떠한 메소드를 abstract 붙일 경우!! class의 이름에도 반드시 abstract 붙여야한다 그리고 몸체를 기술하지 말것
	//abstract가 붙은 메소드는 추상메소드인데, 이 메소드는 몸체를 가지지않는 추상메소드라는 것, 즉 이것만으로는 아무 기능이 없다
}

//따라서 추상클래스의 의미는 구체화되지 않은 추상적인 클래스가 아니라 추상메소드를 포함하고 있는 클래스라는 뜻을 가진다.
//아직 완성된 상태가 아니다 ,abstract 메소드는, 그러나 abstract 클래스에게는 일부만 미완성이라는 의미가 된다
//모든 클래스는 일단 모든 메소드가 완성인 상태로 존재해야만 한다 따라서 주의가 필요
//그냥 바로 인스턴스로 만들려고 하면 에러가 발생, 왜냐면 아직 클래스가 abstract니까 내부 메소드가 정의가되지않았기 때문
//해결로는 단순하다, abstract 메소드를 구현해주면 된다

ex)
public class Main{
	public static void main(String[] args){
		Book b1 = new Book(){
			void PrintBookName(){
				System.out.println("이 책의 이름은:"this.name);
			}
		};
		
		Book b2 = new Book(){
			void PrintBookName(){
				System.out.println("This book's name is "+ this.name);
			}
		};

		b1.name ="해리포터";
		b2.name ="Harry Potter";
		b1.PrintBookName();
		b2.PrintBookName();
	}
}

// 구현 방식은 생성자를 호출함ㅁ과 동시에 중괄호를 열어 메소드를 오버라이딩해 선언한다
// 이곳에서 선언하는 메소드는 각각의 인스턴스에 독립적인 메소드가 된다

