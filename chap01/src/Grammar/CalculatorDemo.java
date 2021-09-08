package Grammar;

class Calculator{
	int left;
	int right;
	
	public Calculator(int a, int b) {
		left=a;
		right=b;
	}
	
	public int sum() {
		return this.left+this.right;
	}
	
	public int avg() {
		int sum=0;
		sum=this.left+this.right;
		return sum/2;
	}
	
	public String toString() {
		return "left: "+left + " right: "+right;
	}
}

public class CalculatorDemo {
	public static void main(String[] args) {
		Calculator c1 = new Calculator(10,20);
		
		System.out.println(c1.sum());
		System.out.println(c1.avg());
		System.out.println(c1);
	}
}
