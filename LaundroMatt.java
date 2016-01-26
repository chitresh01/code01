package fb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LaundroMatt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			int l = sc.nextInt(); 
			int n = sc.nextInt(); 
			int m = sc.nextInt(); 
			int d = sc.nextInt(); 
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt(); 				
			}
			int time = getMinTime(l,n,m,d,arr);
		}finally{	     
		    sc.close();
		}

	}

	private static int getMinTime(int l, int n, int m, int d, int[] arr) {
		int time = 0;
		int tempTime = 0;
		Integer[] w = new Integer[n];
		for(int i=0; i<n ; i++){
			w[i] = arr[i];
		}
		List<Integer> list = Arrays.asList(w);
		Collections.sort(list);
		
		//int j=0;
		int minTimeForOneLoad = list.get(0) + d;
		int[][] wmarr = new int[n][n];
		
		for(int i=0; i<n ; i++){
			for(int j=i+1; j<n ; j++){
				wmarr[i][j] = list.get(j)/list.get(i);
			}
		}
		
		
		
		
		return 0;
	}

}
