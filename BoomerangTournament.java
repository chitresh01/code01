package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoomerangTournament {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			int n = sc.nextInt(); 
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j] = sc.nextInt(); 
				}
			}
			int[][] positions = getPositions(arr);
			for(int i=0; i<n; i++){
				System.out.println("BoomerangTournament.main() -- "+positions[i][0]+ " "+positions[i][1]);
			}
		}finally{	     
		    sc.close();
		}

	}

	private static int[][] getPositions(int[][] arr) {
		int n = arr.length;
		int[][] positionArr = new int[n][2];
		for(int a=0; a<n ;a++){
			positionArr[a][0] = getBestPosition(a,arr);
			positionArr[a][1] = getWorstPosition(a,arr);
		}
		
		
		return positionArr;
	}

	private static int getWorstPosition(int a, int[][] arr) {
		int n = arr.length;
		boolean isInvincible = true;
		int worstPosition = 1;
		for(int i=0;i<n;i++){
			if (a!=i && arr[a][i]==0){
				isInvincible = false;
			}
		}
		
		if(!isInvincible){
			worstPosition = n/2 +1;
		}
		
		return worstPosition;
	}
	
	private static int getBestPosition(int a, int[][] arr) {
		int n = arr.length;		
		int bestPosition = 1;
		int level = 0;
		int tempLevel = 0;
		int m=0;
		
		Map<Integer,List<Integer>> winningMap = new HashMap<Integer, List<Integer>>();
		Map<Integer,List<Integer>> losingMap = new HashMap<Integer, List<Integer>>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> winninglist = new ArrayList<Integer>();
		List<Integer> losinglist = new ArrayList<Integer>();
		
		List<Integer> tempwinninglist = new ArrayList<Integer>();
		List<Integer> templosinglist = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			winninglist = new ArrayList<Integer>();
			losinglist = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				if (j!=i && arr[i][j]==1){
					winninglist.add(j);
				}
				if (j!=i && arr[i][j]==0){
					losinglist.add(j);
				}
			}
			
			winningMap.put(i, winninglist);
			losingMap.put(i, losinglist);			
		}
		
		List<Integer> listA = winningMap.get(a);
		List<Integer> listB = losingMap.get(a);
		
		List<Integer> templistA = null;
		List<Integer> templistB = null;
		
		int winlen = listA.size();
		
		int tempwinlen = 0;
		
		int sowinlen = 0;
		
		int tempcount = 0;
		
		for(int i =0; i<winlen;i++ ){
			tempcount = 0;
			templistA = winningMap.get(listA.get(i));
			for(Integer x : templistA){
				if(listA.contains(x)){
					tempcount++;
				}
			}
			tempwinlen = templistA.size() - tempcount;
			
			
			if(tempwinlen >sowinlen ){
				sowinlen = tempwinlen;
			}
		}
		
		level = sowinlen +1;
		int temp =n;
		int sam =n;
		
		for(int i=1; i<level ;i++){
			temp = temp/2;
			sam = sam-temp;
		}
		
		
		
		
		
		return sam;
	}

	private static int getBestPosition1(int a, int[][] arr) {
		int n = arr.length;		
		int bestPosition = 1;
		int level = 0;
		int tempLevel = 0;
		int m=0;
		
		Map<Integer,List<Integer>> winningMap = new HashMap<Integer, List<Integer>>();
		Map<Integer,List<Integer>> losingMap = new HashMap<Integer, List<Integer>>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> winninglist = new ArrayList<Integer>();
		List<Integer> losinglist = new ArrayList<Integer>();
		
		List<Integer> tempwinninglist = new ArrayList<Integer>();
		List<Integer> templosinglist = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			winninglist = new ArrayList<Integer>();
			losinglist = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				if (j!=i && arr[i][j]==1){
					winninglist.add(i);
				}
				if (j!=i && arr[i][j]==0){
					losinglist.add(i);
				}
			}
			
			winningMap.put(i, winninglist);
			losingMap.put(i, losinglist);			
		}
		
		List<Integer> listA = winningMap.get(a);
		List<Integer> listB = losingMap.get(a);
		tempwinninglist = winningMap.get(a);
		templosinglist = losingMap.get(a);
				
		for(int i=0; i< listA.size(); i++){
			
		}
		
		
		for(int i=0;i<n;i++){
			if (a!=i && arr[a][i]==1){
				list.add(i);
			}
		}
		
		for(int i=0;i<n;i++){
			if (a!=i && list.contains(i)){
				list.add(i);
			}
		}
		
		
		/*if(list.size() == 0){
			bestPosition = 1;
		}else{
			for(int i: list){
				
			}
		}*/
		
		return bestPosition;
	}

}
