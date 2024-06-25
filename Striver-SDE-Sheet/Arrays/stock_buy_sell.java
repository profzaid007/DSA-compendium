/*
use two pointers
pro and min to calculate the min and the max of the diferene in the array

Example 1:


Input:
 prices = [7,1,5,3,6,4]
Output:
 5

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE;
		int pro =0;
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();
			min = Math.min(arr[i],min);
			
			int sum = arr[i]-min;
			pro = Math.max(sum,pro);
		}
		
		
		
		System.out.println(pro);
	}
}