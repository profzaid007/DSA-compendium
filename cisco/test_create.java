/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int t = sc.nextInt();
		int d = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int ctr1 = (int)Math.ceil(n/n1);
		int ctr2 = (int)Math.ceil(n/n2);
		int ctr3 = (int)Math.ceil(n/n3);
		if(n3>n){
			ctr
		}
		
		
		for(int i=0;i<ctr1;i++){
			arr.add(t);
		}
		for(int i=0;i<ctr2;i++){
			arr.add(t+2);
		}
		for(int i=0;i<ctr1;i++){
			arr.add(t-2);
		}
		
		
		System.out.println(ctr3);
	}
}