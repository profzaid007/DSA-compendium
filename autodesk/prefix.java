/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			
			String[] arr = new String[n];
			for(int i=0;i<n;i++){
				arr[i]= sc.next();
			}
			int ctr=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j){
						continue;
					}else{
						if(arr[j].startsWith(arr[i])){
							ctr++;
						}
					}
				}
			}
			System.out.println(ctr);
		}

	}
}