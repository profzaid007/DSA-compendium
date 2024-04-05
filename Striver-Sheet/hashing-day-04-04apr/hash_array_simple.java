/*
Input: 

5 - N
1 3 2 1 3
5 - Q
1 4 2 3 12

Output: 

2 0 1 2 0

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();
		}
		int[] hash = new int[13];
		
		for(int i=0;i<n;i++){
			hash[arr[i]] +=1;
		}
		int q = sc.nextInt();
		while(q--!=0){
			int number = sc.nextInt();
			System.out.print(hash[number]+" ");
			
		}
		
		
		
		System.out.println();
	}
}