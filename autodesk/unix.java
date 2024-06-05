/*

*/

import java.util.*;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			String[] arr = {"0","ls","cp","mv","mv","mv","!1","!3","!6"};
			int[] res = {0,0,0};
			int ctr =0;
			int max =0;
			for(int i=0;i<arr.length;i++){
				String temp = arr[i];

				if(temp.charAt(0)=='!'){
					while(temp.charAt(0)=='!'){
						int index = Integer.parseInt(temp.substring(1));
						temp = arr[index];
					}
				}
				if(temp=="cp"){
					res[0]++;
					ctr++;
				}
				else if(temp=="ls"){
					res[1]++;
					ctr++;
				}else if(temp=="mv"){
					res[2]++;
					ctr++;
				}
			}
			System.out.println(Arrays.toString(res));
		}

	}
}