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

        for(int i=0;i<v.length;i++){
            int key = v[i];
            int freq =0;
            if(map.containsKey(key)){
                freq = map.get(key);
            }
            freq++;
            map.put(key,freq);
        }
        int[] arr = new int[2];
        
        int max = (Collections.max(map.values()));
        int min = (Collections.min(map.values()));
		for(Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue()==max){
				arr[0] =entry.getKey();
			}
			else if(entry.getValue()==min){
				arr[1] = entry.getKey();
				break;
			}
		}
        return arr;
    }
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int[] v = {1, 2, 3, 1, 1, 4};
		int[] arr = getFrequencies(v);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}