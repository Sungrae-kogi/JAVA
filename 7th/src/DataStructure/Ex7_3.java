package DataStructure;

class StackNode{
	char data;
	StackNode link;
}


class LinkedStack implements Stack{
	private StackNode top;
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void push(char item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
		//System.out.println("Inserted Item: "+item);
	}
	
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!");
			return 0;
		}
		else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail!! Linked Stack is empty!");
		}
		else {
			top = top.link;
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! LinkedStack is empty!");
			return 0;
		}
		
		else {
			return top.data;
		}
	}
		// ***********************************************
	public void printStack() {
		if(isEmpty()) {
			System.out.printf("Linked Stack is empty!! %n %n");
		}else {
			StackNode temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null) {
				System.out.printf("\t %c \n",  temp.data);
				temp=temp.link;
			}
		}
	}
	
}



public class Ex7_3 {
	public static void main(String args[]) {
		OptExp opt = new OptExp();
		String exp = "(3*5)-(6/2)";
		char postfix[];
		int value;
		System.out.println(exp);
		if(opt.testPair(exp))
			System.out.println("괄호 맞음!");
		else {
			System.out.println("괄호 틀림!!");
		}
		System.out.printf("\n 후위표기식 : ");
		postfix = opt.toPostfix(exp);
		System.out.println(postfix);
	}
}
