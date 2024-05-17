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
				arr[i] = sc.nextInt();
			}
			
			boolean flag = true;
			while(flag){
				flag = false;
				
				for(int i=1;i<n-1;i++){
					if(arr[i] >  arr[i-1] && arr[i]>arr[i+1]){
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						flag = true;
					}
				}
			}
			boolean ans = true;
				
				for(int i=1;i<n;i++){
					if(arr[i]<arr[i-1]){
						ans = false;
						break;
					}
				}
				if(ans){
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
		}
		
		System.out.println();
	}
}