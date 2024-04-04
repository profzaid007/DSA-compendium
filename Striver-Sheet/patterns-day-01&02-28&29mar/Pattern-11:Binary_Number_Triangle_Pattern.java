/*
Input Format: N = 6
Result:   
1
01
101
0101
10101
010101
Approach:
declare and handle row values in outer loop
then alternatively do arithmetic operations to do shit

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start =1;
		for(int i=0;i<n;i++){
			if(i%2==0) start=1;
			else start =0;
			for(int j=0;j<=i;j++){
				System.out.print(start);
				start = 1-start;
				
			}
			System.out.println();
		}
		

	}
}