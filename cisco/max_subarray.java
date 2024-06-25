/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n  =sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i]= sc.nextInt();
			}
			int str = 0;
			int max =0;
			int res =0;
			for(int i=1;i<n;i++){
				int temp = arr[i]-arr[str];
				if(temp<max){
					str = i;
					res = res+max;
					continue;
				}
				if(temp>max){
					max  = temp;
				}
			}
			res = res+max;
			System.out.println(res);
		}
		
	}
}