/*

*/

import java.util.*;

class Main{
	
	public static void dfs(int node, boolean[] visited,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
		dfs.add(node);
		visited[node] = true;
		for(int i : adj.get(node)){
			if(!visited[i]){
				dfs(i,visited,adj,dfs);
			}
		}
	}
	public static ArrayList<Integer> dfsOfGraph (int n, ArrayList<ArrayList<Integer>> adj){
		boolean[] visited = new boolean[n+1];
		
		visited[1] = true;
		ArrayList<Integer> dfs = new ArrayList<>();
		dfs(1,visited,adj,dfs);
		return dfs;
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		int m = sc.nextInt();
		int n = sc.nextInt();
		for(int i=0;i<=n;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i =1;i<=n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		for(int i=1;i<=m;i++){
			System.out.print(i+"->");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("----------DFS----------");
		System.out.println(dfsOfGraph(n,adj));

	}
}