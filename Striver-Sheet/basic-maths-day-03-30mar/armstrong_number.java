/*
Definition:

*/

import java.util.*;

class Main{
	public static int digitFind(int a){
		String str = Integer.toString(a);
		
		return str.length();
	}	
	public static boolean isArmStrong(int t){
		int dig = digitFind(t);
		int res =0;
		int n =t;
			while(t!=0){
				int temp = t%10;
				res = res+(int)Math.pow(temp,dig);
				t= t/10;
			}
			return (res==n);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);

		
		int t = sc.nextInt();
		
		
		System.out.println(isArmStrong(t));
	}
}