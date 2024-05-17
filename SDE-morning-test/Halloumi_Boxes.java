/*

*/

import java.util.*;

class Main{
	public static boolean isSort(int k, int[] arr){
		if(k==1){
			int[] temp = arr.clone();
			Arrays.sort(temp);
			for(int i=0;i<arr.length;i++){
				if(temp[i]!=arr[i]){
					return false;
				}
			}
			
		}
		return true;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t--!=0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			
			if(isSort(k,arr)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}
}