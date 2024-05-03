/*
use indegree + BFS
*/

import java.util.*;

class Main{
	public static ArrayList<Integer> toposort(int v,ArrayList<ArrayList<Integer>> adj){
		int[] indegree  = new int[v+1];
		
		for(int i=0;i<=v;i++){
			for(int it: adj.get(i)){
				indegree[it]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<=v;i++){
			if(indegree[i]==0){
				queue.add(i);
			}
		}
		ArrayList<Integer> topo = new ArrayList<Integer>();
		int i=0;
		while(!queue.isEmpty()){
			int node = queue.poll();
			topo.add(node);
			
			for(int it : adj.get(node)){
				indegree[it]--;
				if(indegree[it]==0){
					queue.add(it);
				}
			}
		}
		return topo;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int v= sc.nextInt();
		int e = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
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
		
		System.out.println("----KAHN's TOPO-----");
		System.out.println(toposort(v,adj));
		
		
	}
}