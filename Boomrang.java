package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boomrang {
	private static int count;
		
	private static double calculateDistance(int[] firstPoint, int[] secondPoint){
		int x1 = firstPoint[0];
		int y1 = firstPoint[1];
		int x2 = secondPoint[0];
		int y2 = secondPoint[1];
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return distance;
	}
	
	private static double[][] distanceArr(int[][] pointArr){
		int pointSize = pointArr.length;
		double[][] distanceArr = new double[pointSize][pointSize];
		int[] firstPoint = new int[2];
		int[] secondPoint = new int[2];
		double distance;
		for(int i=0;i<pointSize;i++){
			firstPoint[0] = pointArr[i][0];
			firstPoint[1] = pointArr[i][1];
			for(int j=0;j<pointSize;j++){
				secondPoint[0] = pointArr[j][0];
				secondPoint[1] = pointArr[j][1];
				distance = calculateDistance(firstPoint, secondPoint);
				distanceArr[i][j] = distance;
			}
		}
		
		return distanceArr;
	}
	
	private static int boomrangCount(double[][] distanceArray){
		count = 0;
		
		int len = distanceArray.length;
		
		List<Double> list = null;
				
		int tempCount = 0;
		Double tempItem = null;
						
		for(int i=0;i<len;i++){
			tempCount = 0;
			tempItem = null;
			list = getDoubleList(distanceArray[i]);
			Collections.sort(list);

			for(Double item : list){
				if(tempItem == null){
					tempItem = item;
					tempCount = 1;
				}else if(tempItem != null && tempItem.equals(item)){
					tempCount++;
				}else{
					changeCount(tempCount);
					tempItem = item;
					tempCount = 1;
				}
			}
			changeCount(tempCount);

		}
		
		return count;
	}
	
	private static void changeCount(int tCount){
		int temp = tCount * (tCount - 1) /2;
		count = count +temp;
	}
	
	private static List<Double> getDoubleList(double[] num){
		List<Double> list = new ArrayList<>();
		Double dNum;
		
		for(double d:num){
			dNum = Double.valueOf(d);
			list.add(dNum);
		}
		
		return list;
		
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
	      int t = sc.nextInt(); 
	      if(t<1 || t>50){
	    	  return;
	      }
	      for(int tempt = 0; tempt<t; tempt++){
		      int n = sc.nextInt(); 
		      if(n<1 || n>2000){
		    	  return;
		      }
		       
		      int[][] pointArr = new int[n][2];
	
		      for(int i=0;i<n;i++){
		    	 pointArr[i][0] = sc.nextInt();
		    	 pointArr[i][1] = sc.nextInt();
		    	 if(pointArr[i][0] < -10000 || pointArr[i][0] > 10000){
		    		 return;
		    	 }
		    	 if(pointArr[i][1] < -10000 || pointArr[i][1] > 10000){
		    		 return;
		    	 }
		      }
		      
		      int boomrangCount = boomrangCount(distanceArr(pointArr));
		      
		      System.out.println("Case #"+(tempt+1)+": "+boomrangCount);
	      }
		}finally{	      
	      sc.close();
		}

	}

}
