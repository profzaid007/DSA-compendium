/*
Input Format: N = 3
Result: 
  A  
 ABA 
ABCBA

Input Format: N = 6
Result:   
     A     
    ABA    
   ABCBA   
  ABCDCBA  
 ABCDEDCBA 
ABCDEFEDCBA

Approach Use a breakpoint/threshold to do reverse typing
*/

import java.util.*;

class Main{
	
	public static void solve(int a){
		char ctr ='A';
		for(int i=0;i<a;i++){
			ctr ='A';
			for(int j=0;j<a-i-1;j++){
				System.out.print(" ");
			}
			int breakpoint = (2*i+1)/2;
          for(int j=1;j<=2*i+1;j++){
              System.out.print(ctr);
              if(j <= breakpoint) ctr++;
              else ctr--;
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