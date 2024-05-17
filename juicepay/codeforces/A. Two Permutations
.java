/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int a = sc.nextInt();					int b = sc.nextInt();
			
			if(n==a && n==b){
				System.out.println("yes");
			}else if( a+b < n-1){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
		System.out.println();
	}
}