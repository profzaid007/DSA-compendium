/*
Use sqrt method
*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=1;i<=(int)Math.sqrt(t);i++){
			if(t%i==0){
				System.out.print(i+" ");
				if(i != t/i){
					System.out.print(t/i+" ");
				}
			}
		}
		
		System.out.println();
	}
}