/*
Input Format: N = 6
Result:   
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
3 for loop approach and some brain
1    1
12  21
123321
*/

import java.util.*;

class Main{
	
	public static void solve(int a){
		for(int i=1;i<=a;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j);
			}
			for(int j=0;j<a*2-(2*i);j++){
				System.out.print(" ");
			}
			for(int j=i;j>0;j--){
				System.out.print(j);
			}
			System.out.println();
		}

	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n!=0){
			int a = sc.nextInt();
			solve(a);
			n--;	
		}
		
		System.out.println();
	}
}