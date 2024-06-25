/*
Dutch national flag algorithm\
three pointers low for 0 , mid for ptr and , high for 2, 1 is skipped 
the mid is used for taversal 

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
		int low =0;
		int mid =0;
		int high = n-1;
		
		while(mid<=high){
			if(arr[mid]==1){
				mid++;
			}else if(arr[mid]==0){
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
			}else if(arr[mid]==2){
				int temp = arr[high];
				arr[high]=arr[mid];
				arr[mid]= temp;
				high--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}