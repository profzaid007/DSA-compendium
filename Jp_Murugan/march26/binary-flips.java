import java.util.*;
//approach:
/*
Simple traversal and counting values
*/
class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ctr =0;
		
		char curr ='1';
		
		for(char c : s.toCharArray()){
			if(c==curr){
				ctr++;
				if(curr=='1'){
					curr='0';
				}
				else{
					curr='1';
				}
				
			}
		}
		System.out.println(ctr);
	}
}