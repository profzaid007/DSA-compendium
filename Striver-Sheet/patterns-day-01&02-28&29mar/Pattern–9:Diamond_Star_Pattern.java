/*
Input Format: N = 6
Result:   
     *
    ***
   ***** 
  *******
 *********
***********  
***********
 *********
  *******
   ***** 
    ***    
     *
*/

import java.util.*;

class Main{
	public static void erect(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void derect(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<2*n-(2*i+1);j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		erect(t);
		derect(t);
	}
}