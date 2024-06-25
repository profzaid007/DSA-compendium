/*

*/

import java.util.*;

class Main{
	public static int bfsPath(int m, int src, int des, ArrayList<ArrayList<Integer>> adj){
		boolean[] visited = new boolean[m];
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> bfs = new ArrayList<>();
		int[] relativesCount = new int[m];
		visited[src]=true;
		queue.add(src);
		
		while(!queue.isEmpty()){
			int origin = queue.poll();
			//bfs.add(origin);
			if(origin==des){
				return relativesCount[origin]-1;
			}
			for(int i: adj.get(origin)){
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
					relativesCount[i] = relativesCount[origin]+1;
				}
			}
			
		}
		return -1;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		int m = sc.nextInt();
		int n = sc.nextInt();
		m = m+1;
		for(int i=0;i<=m;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i =0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		int src = sc.nextInt();
		int des = sc.nextInt();
		
		
		for(int i=0;i<m;i++){
			System.out.print(i+"->");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("-----ANS-------");
		System.out.println(bfsPath(m,src,des,adj));

	}
}