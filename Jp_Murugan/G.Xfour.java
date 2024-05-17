/*

*/

import java.util.*;

class Main{
	public static void selectionSort(int[] arr , int n){
		for(int i=0;i<n;i++){
			int index = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[i]){
					index =j;
				}
			}
			if((arr[i]^arr[index]) < 4){
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
			}
		}
		// return arr;
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t--!=0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			selectionSort(arr,n);
			System.out.println(Arrays.toString(arr));
			
		}
		

	}
}