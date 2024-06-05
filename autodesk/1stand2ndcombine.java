/*

*/

import java.util.*;

public class Main{
	
	public static int count(ArrayList<Integer> l, int n){
		int ctr =0;
		for(int i=0;i<l.size();i++){
			if(l.get(i)>n){
				ctr++;
			}
		}
		return ctr;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			ArrayList<Integer> first = new ArrayList<Integer>();
			ArrayList<Integer> second = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				arr[i]= sc.nextInt();
			}
			
			first.add(arr[0]);
			second.add(arr[1]);
			
			for(int i=2;i<n;i++){
				int cnt1 = count(first,arr[i]);
				int cnt2 = count(second, arr[i]);
				
				if(cnt1>cnt2){
					first.add(arr[i]);
				}else if(cnt2 > cnt1){
					second.add(arr[i]);
				}else if(cnt1 == cnt2){
					if(first.size()>second.size()){
						first.add(arr[i]);
					}else if(first.size() < second.size()){
						second.add(arr[i]);
					}else if(first.size()==second.size()){
						first.add(arr[i]);
					}
				}
			}
			first.addAll(second);
			System.out.println(first);
			
		}
		
	}
}