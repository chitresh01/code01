package fb;

import java.util.Scanner;

public class CodingContest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
	      int t = sc.nextInt(); 
	      
	      for(int tempt = 0; tempt<t; tempt++){

		      int n = sc.nextInt(); 
		      
		      int[] arr = new int[n];
		      
		      for(int i = 0;i<n ;i++){
		    	  arr[i] = sc.nextInt();
		      }
		      
		          

		      int addCount = getAdditionalCount(arr);
		      
		      
		      System.out.println("Case #"+(tempt+1)+": "+addCount);
		      
	      }
	      
	      
		}finally{	     
			    sc.close();
			}

	}

	private static int getAdditionalCount(int[] arr) {
		int count = 0;
		int n= arr.length;
		int j=0;
		int diff = 0;
		boolean forced = false;
		
		for(int i=0; i<n; i++){
			if(j==4) {
				j=0;
				if(!forced){
					continue;
				}
			}
			if (j==0) {
				j++;
			}
			if((i+1)<n){
				if(arr[i+1] > arr[i]){
					diff = arr[i+1] - arr[i];
					if(diff <= 10){
						j++;
						forced = false;
					}else if(diff <=20){
						count++;
						j++;
						if(j==4){
							forced = true;
						}else{
							//count++;
							j++;
							forced = false;
						}
					}else if(diff <=30){
						count++;
						j++;
						if(j==4){
							forced = true;
						}else{
							count++;
							j++;
							if(j==4){
								forced = true;
							}else{
								//count++;
								j++;
								forced = false;
							}
						}
					}else{
						count = count + (4-j);
						j=4;
						forced = true;
					}
				}else{
					count = count + (4-j);
					j=4;
					forced = true;
				}
			}else{
				count = count + (4-j);
			}
			
		}
		
		return count;
	}

}
