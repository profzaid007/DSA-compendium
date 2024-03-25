import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            a.add(new ArrayList<>());
        }
        int m = sc.nextInt();
        int t = sc.nextInt();
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            a.get(x).add(y);
            a.get(y).add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(0);
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size; i++){
                int node = q.poll();
                sum += arr[node];
                for(int x: a.get(node)){
                    if(!vis[x]){
                        q.add(x);
                        vis[x] = true;
                    }
                }
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
     }
}