/*

*/

import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int  t= sc.nextInt();
		sc.nextLine();
		while(t--!=0){
			char[][] arr = new char[10][10];

			for(int i=0;i<10;i++){
				String temp = sc.nextLine();
				for(int j=0;j<10;j++){
					arr[i][j] = temp.charAt(j);
				}
			}
			int ctr =0;
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					int top =i;
					int bottom = 9-i;
					int left = j;
					int right = 9-j;
					if(arr[i][j]=='X'){
						ctr += Math.min(Math.min(bottom,top),Math.min(right,left))+1;
					}
				}

			}
			System.out.println(ctr);
			
		}
		
		
	}
}