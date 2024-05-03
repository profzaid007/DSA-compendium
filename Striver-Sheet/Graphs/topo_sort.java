/*

*/

import java.util.*;

class Main{
	public static void dfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
		visited[node]= 1;
		for(int i : adj.get(node)){
			if(visited[i]==0){
				dfs(i,visited,adj,stack);
			}
		}
		stack.push(node);
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		for(int i=0;i<=v;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0;i<e;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj.get(a).add(b);
			
		}
		for(int i=0;i<=v;i++){
			System.out.print(i+"->");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		System.out.println("----TOPO SORT------");
		
		int[] ans = new int[v+1];
		int[] visited = new int[v+1];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<=v;i++){
			if(visited[i]==0){
				dfs(i,visited,adj,stack);
			}
		}
		int i=0;
		while(!stack.isEmpty()){
			ans[i++] = stack.peek();
			stack.pop();
		}
		System.out.println(Arrays.toString(ans));
	}
}