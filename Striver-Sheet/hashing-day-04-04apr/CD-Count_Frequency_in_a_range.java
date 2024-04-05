/*
Input: ‘n’ = 6 ‘x’ = 9 ‘arr’ = [1, 3, 1, 9, 2, 7]    
Output: [2, 1, 1, 0, 0, 0]
*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] nums = new int[n];
		int[] arr = new int[x];
		
		for(int i=0;i<n;i++){
			nums[i]= sc.nextInt();
		}
		for(int i=0;i<n;i++){
			arr[nums[i]-1]+=1;
		}
		
		
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}