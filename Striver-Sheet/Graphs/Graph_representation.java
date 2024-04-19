/*
Input:
5 6
1 2
1 3
2 4
3 4 
3 5 
4 5

Explanation:
Number of nodes, n = 5
Number of edges, m = 6
Next m lines represent the edges.

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] matrix = new int[m+1][m+1];
		for(int i=0;i<=n;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i =0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] =1;
			matrix[b][a] = 1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		for(int i=1;i<=m;i++){
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("-----Matrix----");
		for(int i=1;i<=m;i++){
			for(int j=1;j<=m;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}