/*
Observation:
 -> to find at row,col = use nCr = r-1Cc-1
 -> each row has the same number of elements as it's row number
 
*/

import java.util.*;

public class Main{
	
	
	public static long findAtPos(int row, int col){
		long res = 1;
		
		for(int i=0;i<col;i++){
			res = res*(row-i);
			res = res/(i+1);
		}
		
		return res;
		
	}
	public static ArrayList<Integer> findRow(int row){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		res.add(1);
		int ans =1;
		for(int i=1;i<row;i++){
			ans = ans*(row-i);
			ans = ans/i;
			res.add(ans);
		}
		return res;
	}
	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			System.out.println("["+row+","+col+"]:"+findAtPos(row-1,col-1));
			System.out.println("---------------");
			System.out.println("["+row+"]:"+findRow(row));
			System.out.println("---------------");
			ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
			for(int i=1;i<=row;i++){
				triangle.add(findRow(i));
			}
			System.out.println(triangle);
		}
		System.out.println();
	}
}