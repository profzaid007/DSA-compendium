/*
GCD or HCF
Using euclidean algorithm

gcd(a,b) = gcd(a-b,b) where a>b and works vice versa

the subtraction method is not very efficient 
hence we use the modulo property to increase out efficiency by a lot
*/

import java.util.*;

class Main{
	
	public static int solveGCD(int a,int b){
		if(b==0){
			return a;
		}
		return solveGCD(b,a%b);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		while(t!=0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.print(solveGCD(a,b));
			t--;
		}
		
		System.out.println();
	}
}