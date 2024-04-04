/*

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int rev = 0;
		while(t!=0){
			int temp = t%10;
			rev = rev*10+temp;
			t = t/10;
			
		}
		
		System.out.println(rev);
	}
}
