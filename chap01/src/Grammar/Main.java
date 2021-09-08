package Grammar;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int[] key = new int[9];
	    int sum=0;
	    boolean check=false;
	    for(int i=0; i<9; i++) {
	    	key[i]=sc.nextInt();
	    	sum=sum+key[i];
	    }
	    
	    
	    for(int i=0; i<9; i++) {
	    	if(check)
	    		break;
	    	for(int j=0; j<9; j++) {
	    		if(i==j)
	    			continue;
	    		if(sum-key[i]-key[j]==100) {
	    			key[i]=0;
	    			key[j]=0;
	    			Arrays.sort(key);
	    			printarr(key);
	    			check=true;
	    			break;
	    		}
	    			
	    	}
	    }
	    	
	}
	public static void printarr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0)
				System.out.println(arr[i]);
		}
	}
}
	
