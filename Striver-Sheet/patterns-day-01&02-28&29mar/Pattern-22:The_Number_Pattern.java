
/*
Input Format: N = 3
Result: 
3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3
*/

import java.util.*;

class Main{
	
	public static void solve(int a){
		
		for(int i=0;i<2*a-1;i++){
			for(int j=0;j<2*a-1;j++){
				int top = i;
				int left = j;
				int right = (2*a-2)-j;
				int bottom = (2*a-2)-i;
				
				System.out.print(a-(Math.min(Math.min(top,bottom),Math.min(right,left))));
			}
			System.out.println();	
		}
		System.out.println("----------------");
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t!=0){
			int a = sc.nextInt();
			solve(a);
			t--;
		}	
		
		System.out.println();
	}
}