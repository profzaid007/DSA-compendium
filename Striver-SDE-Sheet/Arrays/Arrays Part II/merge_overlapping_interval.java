/*
comparator sorting
then compre and add intervals when needed simple intuition
*/

import java.util.*;

public class Main{
	
	
	public static int[][] mergeOverlapping(int[][] interval){
		Arrays.sort(interval, new Comparator<int[]>(){
			public int compare(int[] a, int[]b){
				return a[0]-b[0];
			}
			});
			
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0;i<interval.length;i++){
				if(ans.isEmpty() || interval[i][0] > ans.get(ans.size()-1).get(1)){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(interval[i][0]);
					temp.add(interval[i][1]);
					ans.add(temp);
				}else{
					ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),interval[i][1]));
				}
			}
			System.out.print(ans);
			int[][] array = new int[ans.size()][2];
			for(int i=0;i<ans.size();i++){
				array[i][0] = ans.get(i).get(0);
				array[i][1] = ans.get(i).get(1);
			}
			return array;
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] interval = new int[n][2];
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				interval[i][j] = sc.nextInt();
			}
		}
		mergeOverlapping(interval);
		System.out.println();
	}
}