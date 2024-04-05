/*
Input: 
7
1 2 3 1 3 2 12
5
1 2 3 4 12

Output: 
2 2 2 0 1
*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> map = new HashMap<>();
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();
		}
		for(int i=0;i<n;i++){
			int key = arr[i];
			int freq =0;
			if(map.containsKey(key)){
				freq = map.get(key);
			}
			freq++;
			map.put(key,freq);
		}
		int q =sc.nextInt();
		while(q-- !=0){
			int a = sc.nextInt();
			//use if to print zero or the frequency
			System.out.print(map.get(a)+" ");
		}
		
		
		
		System.out.println();
	}
}