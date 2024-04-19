/*
Sample Input 1:

8 7
0 1
0 2
0 3
1 4
1 7
2 5
3 6

Sample Output 1:

0 1 2 3 4 7 5 6

*/

import java.util.*;

class Main{
	public static ArrayList<Integer> bfsTraversal(int n,ArrayList<ArrayList<Integer>> adj){
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> bfs = new ArrayList<>();
		visited[0]=true;
		queue.add(0);
		
		while(!queue.isEmpty()){
			int origin = queue.poll();
			bfs.add(origin);
			
			for(int i: adj.get(origin)){
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
			
		}
		return bfs;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		int m = sc.nextInt();
		int n = sc.nextInt();
		for(int i=0;i<=n;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i =0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		for(int i=0;i<m;i++){
			System.out.print(i+"->");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("-----BFS-------");
		System.out.println(bfsTraversal(m,adj));

	}
}