/*
vector<int> solution(vector<int> arr) {
    vector<int> ans;
    int n = arr.size();
    if(n < 3)   return {0};
    
    for(int i = 0; i < n - 2; i++){
        int s1 = arr[i], s2 = arr[i+1], s3 = arr[i+2];
        if((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1))  ans.push_back(1);
        else    ans.push_back(0);
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
			ArrayList<Integer> res = new ArrayList<>();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i]= sc.nextInt();
			}
			if(n<3){
				System.out.println(0);
			}else{
				for(int i=0;i<n-2;i++){
					int s1 = arr[i], s2 = arr[i+1],s3=arr[i+2];
					if(s1+s2 >s3 && s1+s3>s2 && s2+s3>s1){
						res.add(1);
					}else{
						res.add(0);
					}
				}
			}
			System.out.println(res);
		}
		
	}
}