/*
Input Format: N = 3
Result: 
A
A B
A B C

Input Format: N = 6
Result:   
A
A B
A B C
A B C D
A B C D E
A B C D E F
*/

import java.util.*;

class Main{
	public static void solve(int a){
		char ctr ='A';
		for(int i=1;i<=a;i++){
			ctr='A';
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