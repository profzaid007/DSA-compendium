/*

*/

import java.util.*;

class Main{
	class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree  = new int[numCourses];
		
		for(int i=0;i<numCourses;i++){
			for(int it: adj.get(i)){
				indegree[it]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++){
			if(indegree[i]==0){
				queue.add(i);
			}
		}
		ArrayList<Integer> topo = new ArrayList<Integer>();
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
        return (topo.size()==numCourses);
    }
}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println();
	}
}