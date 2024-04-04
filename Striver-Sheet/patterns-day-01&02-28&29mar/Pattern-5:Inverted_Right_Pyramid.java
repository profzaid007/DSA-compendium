// Input Format: N = 6
// Result:
// * * * * * *
// * * * * * 
// * * * * 
// * * * 
// * * 
// * 
// 

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=t;i>0;i--){
			for(int j=0;j<i;j++){
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
}