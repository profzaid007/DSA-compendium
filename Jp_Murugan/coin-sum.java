import java.util.*;

class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int six,three,one =0;
		int[] arr = {6,3,1};
		int sum = sc.nextInt();
		
		six = sum/6;
		sum = sum %6;
		three = sum/3;
		sum = sum %3;
		one = sum;
		System.out.print(one+" "+three+" "+six);
		
		
		
	}
}