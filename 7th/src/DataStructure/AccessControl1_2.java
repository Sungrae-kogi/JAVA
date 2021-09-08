package DataStructure;

public class AccessControl1_2 {
	private int num1, num2, sum;
	private double ave;
	AccessControl1_2(int a, int b){
		this.num1 = a;
		this.num2 = b;
	}
	public int getSum() {
		sum = num1 + num2;
		return sum;
	}
	public double getAve() {
		ave = sum/2.0;
		return ave;
	}
}

class Ex_AccessControl1_2{
	public static void main(String[] args) {
		AccessControl1_2 test2 = new AccessControl1_2(10,20);
		System.out.println("sum="+test2.getSum());
		System.out.println("average ="+test2.getAve());
	}
}
