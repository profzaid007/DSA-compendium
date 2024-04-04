/*

*/

import java.util.*;

class Main{
	
	public static void recur(int i, int n){
		if(i>n){
			return;
		}
		System.out.println("Wassup MFss!!");
		
		recur(i+1,n);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		int n = sc.nextInt();
		recur(i,n);
		
		
		System.out.println();
	}
}