/*
Input Format: N = 3
Result: 
C
B C
A B C

Input Format: N = 6
Result:   
F
E F
D E F
C D E F
B C D E F
A B C D E F

Approach:
start from last alphabet use type casting, then use arithmetic operations
*/

import java.util.*;

class Main{
	public static void solve(int a){
		
		for(int i=0;i<a;i++){
			for(char ch=(char)(int)('A'+a-1-i);ch<=(char)(int)('A'+a-1);ch++){
				System.out.print(ch+" ");
			}
			System.out.println();
		}
		System.out.println("---------");
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