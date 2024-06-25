/*
*/

import java.util.*;

public class Main{
	public static int find(int n,int r){
		int res =1;
		for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int y = sc.nextInt();
			int res =0;
			for(int i=1;i<=y;i++){
				res = res + find(n,i);
			}
			System.out.println(res);
		}
		
	}
}