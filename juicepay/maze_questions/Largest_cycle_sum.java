/*

*/

import java.util.*;

public class Main{
	static int[] par;
	static int[] rank;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		largestCycle(arr,n);
		sc.close();
	}
	
	public static int findPar(int x){
		if(par[x]==x){
			return x;
		}
		
		return par[x] = findPar(par[x]);
	}
	public static void union(int x, int y){
		if(rank[x] == rank[y]){
			par[x] = y;
			rank[x]++;
		}
		else if(rank[x] < rank[y]){
			par[x] = y;
		}
		else if(rank[y]<rank[x]){
			par[y] = x;
		}
	}
	public static void  largestCycle(int[] arr, int n){
		par = new int[n];
		rank = new int[n];
		
		int max = -1;
		for(int i=0;i<n;i++){
			par[i] = i;
		}
		for(int i=0;i<n;i++){
			int x = i;
			int y = arr[i];
			
			if(y!=-1){
				int u = findPar(x);
				int v = findPar(y);
				
				if(u==v){
					int s = x;
					int t = arr[x];
					int sum = s;
					while(s!=t){
						sum += t;
						t = arr[t];
					}
					max = Math.max(sum, max);
				}else{
					union(u,v);
				}
			}
		}
		System.out.println(max);
		
	}
	
	
	
}