/*
Input Format: N = 3
Result: 
*    *
**  **
******
**  **
*    *
Input Format: N = 6
Result:   
*          *
**        **
***      ***
****    ****
*****  *****
************
*****  *****
****    ****
***      ***
**        **
*          *

*/

import java.util.*;

class Main{
	public static void solve(int a){
		int spaces = 2*a-2;
		for(int i =1;i<(2*a);i++){
			int stars = i;
			if(i>a) stars = 2*a-i;
			for(int j=1;j<=stars;j++){
				System.out.print("*");
			}
			for(int j=1;j<=spaces;j++){
				System.out.print(" ");
			}
			for(int j=1;j<=stars;j++){
				System.out.print("*");
			}
			System.out.println();
			if(i<a) spaces-=2;
			else spaces+=2;
		}
		System.out.println("------");
		
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