/*
Input Format: N = 3
Result: 
A B C
A B
A

Input Format: N = 6
Result:   
A B C D E F
A B C D E 
A B C D
A B C
A B
A
*/

import java.util.*;

class Main{
	
	public static void solve(int a){
		char ctr ='A';
		for(int i=a;i>0;i--){
			ctr ='A';
			for(int j=i;j>0;j--){
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