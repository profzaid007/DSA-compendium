/*
Input Format: N = 3
Result: 
***
* *
***

Input Format: N = 6
Result:   
******
*    *
*    *
*    *
*    *
******

*/

import java.util.*;

class Main{
	public static void solve(int a){
		for(int i=0;i<a;i++){
			for(int j=0;j<a;j++){
				if(i==0||j==0||i==a-1||j==a-1){
					System.out.print("*");
				}
				else System.out.print(" ");
			}
			System.out.println();
		}
			System.out.println("-----------");		
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