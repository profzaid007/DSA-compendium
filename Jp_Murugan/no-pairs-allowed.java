import java.util.*;

class Main{

	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] words = new String[t];
		 
		for(int i=0;i<t;i++){
			words[i]= sc.next();
		}
		int[] changes = new int[words.length];
		int td=0;
		for(int i=0;i<t;i++){
			char[] c = words[i].toCharArray();
			for(int j=0;j<c.length-1;j++){
				if(c[j]==c[j+1]){
					c[j+1]='1';
					changes[td]=changes[td]+1;
					td++;
					
				}
				
			}
		}
	  for(int x : changes){
	  	System.out.print(x);
	  }
		
	}
}