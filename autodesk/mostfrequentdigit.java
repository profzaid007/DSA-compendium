/*
vector<int> solution(vector<int> a) {
    vector<int> freq(10, 0);
    for(auto it : a){
        while(it > 0){
            int rem = it % 10;
            it /= 10;
            freq[rem]++;
        }
    }
    
    int maxi = *max_element(freq.begin(), freq.end());
    vector<int> ans;
    for(int i = 0; i < 10; i++){
        if(freq[i] == maxi) ans.push_back(i);
    }
    return ans;
}
*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			int freq = new int[10];
			Arrays.fill(freq,0);
			for(int i=0;i<n;i++){
				arr[i]= sc.nextInt();
			}
			for()
			
			
		}
		System.out.println();
	}
}