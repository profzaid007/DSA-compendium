/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- !=0){
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] pumps = new int[n];
			int cap = 2;
			for(int i=0;i<n;i++){
				pumps[i] = sc.nextInt();
				if(i==0){
					cap = pumps[i];
				}
				else{
					cap = Math.max(cap,pumps[i]-pumps[i-1]);
				}
			}
			cap = Math.max(cap,(x-pumps[n-1])*2);
			System.out.println(cap);
		}
		
	}
}