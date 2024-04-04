/*
Input Format: N = 3
Result: 
******
**  **
*    *
*    *
**  **
******

Input Format: N = 6
Result:   
************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
*/

import java.util.*;

class Main{
	public static void solve(int a){
		
		for(int i=0;i<a;i++){
			for(int j=0;j<a-i;j++){
				System.out.print("*");
			}
			for(int j=0;j<i*2;j++){
				System.out.print(" ");
			}
			for(int j=0;j<a-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		int temp = a*2-2;
		for(int i=0;i<a;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			for(int j=0;j<temp-i*2;j++){
				System.out.print(" ");	
			}
			for(int j=0;j<=i;j++){
				System.out.print("*");
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