/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();
		}
		
		int sum =0;
		int maxi = Integer.MIN_VALUE;
		int start =0;
		int low = 0;
		int	high =0;
		for(int i=0;i<n;i++){
			if(sum==0){
				start =i;
			}
			sum +=arr[i];
			if(sum>maxi){
				maxi = sum;
				low = start;
				high = i;
				
			}
			if(sum<0){
				sum =0;
			}
		}
		
		System.out.println("["+low+","+high+"]:"+maxi);
	}
}