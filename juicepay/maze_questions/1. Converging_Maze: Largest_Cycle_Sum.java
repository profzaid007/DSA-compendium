import java.util.*;

public class Main {

    static List<List<Integer>> adj = new ArrayList<>();
    static int[] vis, par;
    static List<Integer> tmp = new ArrayList<>();

    static long dfs(int node, int p) {
        vis[node] = 1;
        par[node] = p;
        tmp.add(node);
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                long z = dfs(i, node);
                if (z != -1) {
                    return z;
                }
            } else if (vis[i] == 1) {
                long sum = i;
                while (node != i) {
                    sum += node;
                    node = par[node];
                }
                if (node == i) {
                    return sum;
                }
                return -1;
            }
        }
        return -1;
    }

    static long sumCycle(int n, ArrayList<Integer> arr) {
        long ans = -1;
        vis = new int[n];
        adj = new ArrayList<>(n);
        par = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            if (arr.get(i) != -1) {
                adj.get(i).add(arr.get(i));
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                ans = Math.max(ans, dfs(i, -1));
                for (int j : tmp) {
                    vis[j] = 2;
                }
                tmp.clear();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--!=0){
	        int n = sc.nextInt();
	        ArrayList<Integer> arr = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            arr.add(sc.nextInt());
	        }
	        long ans = sumCycle(n, arr);
	        System.out.println(ans);
        }
    }
}
