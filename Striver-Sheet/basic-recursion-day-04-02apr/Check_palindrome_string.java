/*

*/

import java.util.*;

class Main{
	
	public static boolean isPalindrome(int i, String str){
		
		if(i>=str.length()/2) return true;
		
		if(str.charAt(i) != str.charAt(str.length()-i-1)) return false;
		
		return isPalindrome(i+1, str);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t!=0){
			String str = sc.next();
			
			System.out.println(isPalindrome(0,str));
			
			t--;
		}
		
		System.out.println();
	}
}