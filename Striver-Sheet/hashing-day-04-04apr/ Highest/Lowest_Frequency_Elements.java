/*
Sample Input 1 :

6
1 2 3 1 1 4

Sample Output 1 :

1 2

Sample Explanation 1:

Input: ‘n' = 6, 'v' = [1, 2, 3, 1, 1, 4]

Output: 1 2

*/

import java.util.*;
import java.util.Map.Entry;

class Main{
	public static int[] getFrequencies(int []v) {
        HashMap<Integer,Integer> map = new HashMap<>();
		int [] arr = new int[2];
        for(int i=0;i<v.length;i++){
            int key = v[i];
            int freq =0;
            if(map.containsKey(key)){
                freq = map.get(key);
            }
            freq++;
            map.put(key,freq);
        }
        int maxf =0;
        int minf = v.length;
        int minv=0;
        int maxv = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        	int ctr = entry.getValue();
        	int key = entry.getKey();
        	if(ctr<=minf){
                if(ctr==minf){
                    minv = Math.min(minv,key);
                }else{
                    minv = key;
        		    minf = ctr;
                }
        		
        	}
        	if(ctr>=maxf){
                if(ctr==maxf){
                    maxv = Math.min(maxv,key);
                }else{
                    maxv = key;
        		    maxf = ctr;
                }
            }
        }
        arr[0]= maxv;
        if(minv==0){
        	arr[1]=maxv;
        }else{
        	arr[1] = minv;
        }
        return arr;
    }
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] v = new int[t];
		for(int i=0;i<t;i++){
			v[i]=sc.nextInt();
		}
		Arrays.sort(v);
		int[] arr = getFrequencies(v);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}