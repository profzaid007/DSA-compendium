/*
Input Format: N = 6
Result:   
*
**
*** 
****
*****
******  
*****
****
***    
**
*
*/

import java.util.*;

class Main{
	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<2*n;i++){
			int ctr =i;
			
			if(i>n) ctr = 2*n-i;
			
			for(int j=1;j<ctr;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		

	}
}