/*

*/

import java.util.*;

class Main{
	static void printArray(int arr[], int n) {
      System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
   }
	public static void reverseArray(int[] arr , int low, int high){
		if(low <high){
			int temp = arr[low];
			arr[low]= arr[high];
			arr[high]=temp;
			
			reverseArray(arr, low+1,high-1);
		}
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int arr[] = {10,8,6,4,2,1};
		reverseArray(arr,0,arr.length-1);
		
		printArray(arr,arr.length);
	}
}