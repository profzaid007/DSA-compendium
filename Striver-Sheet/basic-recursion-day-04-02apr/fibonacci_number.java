/*

*/

import java.util.*;

class Main{
	
	public static int fib(int n){
		if(n<=1) return n;
		
		int last = fib(n-1);
		int secondlast = fib(n-2);
		
		return last+secondlast;
	}
	public static void fib_naive(int n){
		if(n==0){
			System.out.println(0);
		}else{
			int snd = 0;
			int last = 1;
			System.out.print(snd+" "+last+" ");
			int temp;
			for(int i=2;i<=n;i++){
				temp = last +snd;
				snd = last;
				last = temp;
				System.out.print(temp+" ");
			}
		}
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		
		fib_naive(10);
	}
}