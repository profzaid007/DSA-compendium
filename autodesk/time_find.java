/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
			}
			int res =0;
			for(int i=0;i<n-1;i++){
				if(arr[i]==arr[i+1]){
					continue;
				}else if(arr[i]<arr[i+1]){
					t+=1;
				}else if(arr[i]>arr[i+1]){
					t+=2;
				}
			}
			
			System.out.println(t);
		}
		
	}
}