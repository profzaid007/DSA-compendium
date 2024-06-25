/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0;i<m*2;i++){
				int temp = sc.nextInt();
				int freq = arr[temp];
				arr[temp] = freq+1;
			}
			int res =0;
			for(int i=0;i<arr.length;i++){
				if(arr[i]>=2){
					res = res+ k;
				}
			}
			System.out.println(res);
		}
		
	}
}