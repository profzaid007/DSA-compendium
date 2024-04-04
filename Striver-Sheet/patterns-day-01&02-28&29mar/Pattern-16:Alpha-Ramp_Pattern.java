/*
Input Format: N = 3
Result: 
A
B B
C C C

Input Format: N = 6
Result:   
A 
B B
C C C
D D D D
E E E E E
F F F F F F
*/

import java.util.*;

class Main{
	
	public static void solve(int a){
		char ctr ='A';
		for(int i=1;i<=a;i++){
			for(int j=0;j<i;j++){
				System.out.print(ctr+" ");
			}
			ctr++;
			System.out.println();
		}
		System.out.println("-------");
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