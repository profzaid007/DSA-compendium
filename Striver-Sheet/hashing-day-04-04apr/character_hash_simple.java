/*
Input: 

abcdabefc
a c z
Output: 
2 2 0

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] hash = new int[26];
		
		
		for(int i=0;i<s.length();i++){
			hash[s.charAt(i)-'a'] +=1;
		}
		int q = sc.nextInt();
		
		while(q-- !=0){
			char c = sc.next().charAt(0);
			
			System.out.print(hash[c-'a']+" ");
		}
		
		System.out.println();
	}
}