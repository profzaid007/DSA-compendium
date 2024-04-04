/*
Pattern - 13: Increasing Number Triangle Pattern
Input Format: N = 3
Result: 
1
2 3
4 5 6

Input Format: N = 6
Result:   
1
2  3
4  5  6
7  8  9  10
11  12  13  14  15
16  17  18  19  20  21
*/

import java.util.*;

class Main{
	public static void solve(int a){
		int ctr =1;
		for(int i=1;i<=a;i++){
			for(int j=1;j<=i;j++){
				System.out.print(ctr+" ");
				ctr++;
			}
			System.out.println();
		}
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