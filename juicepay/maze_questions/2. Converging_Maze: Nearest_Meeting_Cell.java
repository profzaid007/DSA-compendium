import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findCell(arr,n, a, b));
        sc.close();
    }
    
    public static int findCell(int[] arr,int n, int a, int b){
    	
    	if(a==b){
    		return a;
    	}
    	int[] dxa = new int[n];
    	int[] dxb = new int[n];
    	
    	Arrays.fill(dxa,-1);
    	Arrays.fill(dxb,-1);
    	
    	findDist(dxa, a,arr);
    	findDist(dxb,b,arr);
    	int min = Integer.MAX_VALUE;
    	int cell = -1;
    	for(int i=0;i<n;i++){
    		if(dxa[i]!=-1 && dxb[i]!=-1){
    			int max = Math.max(dxa[i],dxb[i]);
    			
    			if(max<min){
    				min = max;
    				cell = i;
    			}
    		}
    	}
    	return cell;
    	
    }
    
    public static void findDist(int[] dist, int a, int[] arr){
    	int cur = a;
    	int d = 0;
    	while(cur!=-1 && dist[cur]==-1){
    		dist[cur] = d++;
    		cur = arr[cur];
    	}
    }
    
    
    
    

}