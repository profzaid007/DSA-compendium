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
			Queue<Integer> queue = new LinkedList<>();
			
			int start = arr[0];
			
			for(int i=1;i<arr.length;i++){
				start+=300;
				if(start>=arr[i] && queue.size()<=10){
					queue.add(arr[i]);
				}
				queue.remove();
			}
			start+=300;
			System.out.println(start);
		}
		
	}
}