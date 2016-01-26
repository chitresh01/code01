package fb;

import java.util.Scanner;

public class TextEditor {
	private static int count;
	
	private static void print(){
		count++;
	}
	
	private static void type(){
		count++;
	}
	
	private static void backspace(){
		count++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      
	      int n = sc.nextInt(); 
	      int k = sc.nextInt(); 
	      String[] strArr = new String[n];
	      int[] lenArr = new int[n];
	      for(int i=0;i<n;i++){
	    	  strArr[i] = sc.nextLine().trim();
	    	  lenArr[i] = strArr[i].length();
	    	  System.out.println("TextEditor.main()-- "+strArr[i]+" : "+lenArr[i]);
	      }
	      
	      
	      
	      

	}

}
