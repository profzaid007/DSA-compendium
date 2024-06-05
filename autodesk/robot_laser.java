/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int left=0,right=m-1,top=0, down=n-1;
			int[][] arr = new int[n][m];
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					arr[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(arr[i][j]==1){
						if(j>y){
							right = Math.min(right,j-y);
						}else{
							left = Math.max(left,y-j);
						}
						if(i>x){
							top = Math.max(top,x-i);
						}else{
							down = Math.min(down,i-x);
						}
					}
				}
				
			}
			System.out.println(Math.max(Math.max(top,down),Math.max(left,right)));
		}

	}
}