import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t--!=0){
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        int[] weight = new int[n];
        int max = 0;
        
        for(int i =0;i<n;i++){
        	arr[i] = sc.nextInt();
        	if(arr[i]!=-1){
        		weight[arr[i]] +=1;
        		if(weight[arr[i]]>weight[max]) max = arr[i];
        	}
        }
        System.out.println(max);
        }
	}
}

