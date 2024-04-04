/*
use maths most efficient = N(N+1)/2
*/

import java.util.*;

class Main{
	
	public static int func(int n){
		if(n==0){
			return 0;
		}
		
		return n+func(n-1);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();
		System.out.println(func(n));
	}
}