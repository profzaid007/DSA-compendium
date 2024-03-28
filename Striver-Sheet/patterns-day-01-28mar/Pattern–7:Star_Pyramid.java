/*Input Format: N = 6
Result:
     *     
    ***    
   *****   
  *******  
 ********* 
***********

Approach:
use 2 type nested for loops 
the spaces approach: 6-i-1
the stars approach: 2*i+1


*/
import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			for(int j=0;j<t-i-1;j++){
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++){
				System.out.print("*");
			}
			
			System.out.println();
			
		}
	}
}