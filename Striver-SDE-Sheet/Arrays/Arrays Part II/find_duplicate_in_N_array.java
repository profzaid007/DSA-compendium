/*
can use sort and then traversal
better is to use a HASHSET - but space is bad
best - turtle slow and fast pointer
*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		
		int slow = arr[0];
		int fast = arr[0];
		do{
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow!=fast);
		
		fast = arr[0];
		while(slow!=fast){
			slow = arr[slow];
			fast = arr[fast];
		}
		System.out.print(slow);
	}
}