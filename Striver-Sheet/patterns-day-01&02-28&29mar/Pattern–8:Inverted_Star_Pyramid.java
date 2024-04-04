/*
Input Format: N = 6
Result:     
***********
 *********
  *******
   ***** 
    ***    
     *
*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j =0;j<2*t-(2*i+1);j++){
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		System.out.println();
	}
}