/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int q = sc.nextInt();
		String[] songs = new String[n];
		String[] anime = new String[q];
		for(int i=0;i<n;i++){
			songs[i]= sc.next();
		}
		for(int i=0;i<q;i++){
			anime[i]= sc.next();
		}
		String[] res = new String[n];
		
		int index=0;		
		for(String song: songs){
			String[] s = song.split(":");
			int slen = Integer.parseInt(s[1]);
			for(String ani : anime){
				String[] a = ani.split(":");
				int alen = Integer.parseInt(a[1]);
				if(slen%alen==0){
					res[index]=a[0]+":"+(String.valueOf(slen/alen));
					index++;
					break;
				}
				
			}
		}
        for(int i=0;i<n;i++){
        	System.out.println(res[i]);
        }
	}
}