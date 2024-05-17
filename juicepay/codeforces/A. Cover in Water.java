/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		while(t--!=0){
			int n = sc.nextInt();
			String s = sc.next();
			
			int max =0, cnt =0, ct =0;
			for (int i=0;i<s.length();i++){
				if(s.charAt(i)=='.'){
					cnt ++;
					ct++;
				}
				if(s.charAt(i) == '#'){
					max = Math.max(ct,max);
					ct =0;
				}
			}
			max =Math.max(ct,max);
			if(cnt ==0){
						System.out.println(0);
			}
			else if(max>2){
						System.out.println(2);
			}else{
						System.out.println(cnt);
			}
		}
		
		System.out.println();
	}
}