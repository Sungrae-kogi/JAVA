package Linked;

import java.util.*;

public class LabTest {
	static Scanner in;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		BST<Item> bst = new BST<Item>();
		
		while(true) {
			System.err.print("BST> ");
			String command;
			command = in.next();
			if(command.equals("quit"))
				break;
			else if(command.equals("ins")) {
				int key = in.nextInt();
				int val = in.nextInt();
				if(bst.Insert(new Item(key, val))==false)
			}
		}
	}
}
