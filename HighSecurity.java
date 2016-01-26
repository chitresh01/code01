package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HighSecurity {
	
	private static Map<Integer, Boolean> map1 = null;
	private static Map<Integer, Boolean> map2 = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
	      int t = sc.nextInt(); 
//	      if(t<1 || t>200){
//	    	  return;
//	      }
	      
	      for(int tempt = 0; tempt<t; tempt++){
//	    	  if(tempt>200){
//		    	  return;
//		      }
		      int n = sc.nextInt(); 
		      if(n<1 || n>1000){
		    	  return;
		      }
		      sc.nextLine();
		      String str1 = sc.nextLine();
		      String str2 = sc.nextLine();
		      

		      
		      int guardCount = checkSecurity(str1,str2);
		      
		      System.out.println("Case #"+(tempt+1)+": "+guardCount);
		      
	      }
	      
	      
		}finally{	      
		      sc.close();
			}

	}

	private static int checkSecurity(String str1, String str2) {
		map1 = new HashMap<Integer, Boolean>();
		map2 = new HashMap<Integer, Boolean>();
		
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		
		int[] xCharPostions1 = findCharPosition(charArr1,'X');
		int[] xCharPostions2 = findCharPosition(charArr2,'X');
		
		int maxNumberOfGuardsForFirstRow = maxNumberOfGuards(xCharPostions1,charArr1);
		int maxNumberOfGuardsForSecondRow = maxNumberOfGuards(xCharPostions2,charArr2);
		
		int totalGuards = maxNumberOfGuardsForFirstRow + maxNumberOfGuardsForSecondRow;
		
		int[] singleDotPositions1 = findSingleDotPosition(xCharPostions1,charArr1);
		int[] singleDotPositions2 = findSingleDotPosition(xCharPostions2,charArr2);
		
		int reducedNumber =  reducedNumberOfGaurds(charArr1, charArr2,singleDotPositions1,singleDotPositions2,xCharPostions1,xCharPostions2);

		return (totalGuards - reducedNumber);
	}

	private static int reducedNumberOfGaurds(char[] charArr1, char[] charArr2,
			int[] singleDotPositions1, int[] singleDotPositions2,int[] xCharPostions1,int[] xCharPostions2) {
		int reducedCount = 0;
		for(int i=0;i<singleDotPositions1.length; i++){
			if(charArr2[singleDotPositions1[i]] == 'X'){
				continue;
			}else{
				boolean reduce = checkForSecurityInAnotherRow(singleDotPositions1[i],map1,singleDotPositions2, xCharPostions2, map2);
				if(reduce){
					reducedCount++;
				}
			}
		}
		
		for(int i=0;i<singleDotPositions2.length; i++){
			if(charArr1[singleDotPositions2[i]] == 'X'){
				continue;
			}else{
				boolean reduce = checkForSecurityInAnotherRow(singleDotPositions2[i],map2, singleDotPositions1,xCharPostions1,map1);
				if(reduce){
					reducedCount++;
				}
			}
		}
		return reducedCount;
	}

	private static boolean checkForSecurityInAnotherRow(int pos,Map<Integer,Boolean> map1,
			int[] singleDotPositions2,int[] xCharPostions2, Map<Integer,Boolean> map2) {
		int temp = -1;
		
		Boolean bool1 = map1.get(pos);
		if(bool1 != null && bool1.booleanValue()){
			return true;
		}
		
		for(int i = 0; i< singleDotPositions2.length; i++){
			if(pos == singleDotPositions2[i]){
				map1.put(pos, true);
				map2.put(pos, true);
				return false;
			}
		}
		
		Boolean bool2 = map2.get(pos);
		if(bool2 != null && bool2.booleanValue()){
			return false;
		}
		for(int i =0; i< xCharPostions2.length ; i++){
			if(pos>temp && pos<xCharPostions2[i]){
				for(int j = temp +1; j<xCharPostions2[i];j++){
					map2.put(j, true);
				}

				
			}
			temp = xCharPostions2[i];
		}
		return true;
	}

	private static int[] findSingleDotPosition(int[] xCharPostions, char[] charArr) {
		List<Integer> singleDotlist= new ArrayList<>();
		int temp = -1;
		for(int i = 0; i<xCharPostions.length;i++){
			if((xCharPostions[i]-temp) == 2){
				singleDotlist.add((xCharPostions[i]+temp)/2);
				
			}
			temp = xCharPostions[i];
		}
		
		if((charArr.length-temp) == 2){
			singleDotlist.add((charArr.length+temp)/2);
			
		}
		
		int[] singleDotPostions = new int[singleDotlist.size()];
		for(int i=0;i<singleDotlist.size();i++){
			singleDotPostions[i]= singleDotlist.get(i);
		}
		return singleDotPostions;
		
	}

	private static int maxNumberOfGuards(int[] xCharPostions, char[] charArr) {
		int guardCount = 0;
		int temp = -1;

		for(int i=0;i<xCharPostions.length;i++){
			if((xCharPostions[i]-temp)>1){				
				guardCount++;
			}
			temp = xCharPostions[i];
		}
		if(temp < (charArr.length - 1)){
			guardCount++;
		}
		return guardCount;
	}

	private static int[] findCharPosition(char[] charArr, char c) {
		List<Integer> charlist= new ArrayList<>();
		for(int i = 0; i<charArr.length;i++){
			if(charArr[i] == c){
				charlist.add(i);
			}
		}
		
		int[] charPostions = new int[charlist.size()];
		for(int i=0;i<charlist.size();i++){
			charPostions[i]= charlist.get(i);
		}
		return charPostions;
	}

}
