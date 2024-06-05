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
			int ctr=0;
			for(int i=0;i<n;i++){
				arr[i]= sc.nextInt();
			}
			int a = arr[0];
			int b = arr[1];
			for(int i=2;i<n;i++){
				if(arr[i]==a || arr[i]==b){
					continue;
				}else{
					ctr++;
				}
			}
		System.out.println(ctr);
		}

	}
}