
import java.util.*;
class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.trim().split(" ");
		String res ="";
		
		for(int i= arr.length-1;i>=0;i--){
			if(i==0){
				res+=arr[i];
				break;
			}
			res += arr[i]+" ";
			
	}
	char d = res.charAt(0);
	String c = String.valueOf(res.charAt(0));
	String t = String.valueOf(Character.toUpperCase(d));
	res = res.replaceFirst(c,t);
	res+=".";
	System.out.println(res);
	}
}