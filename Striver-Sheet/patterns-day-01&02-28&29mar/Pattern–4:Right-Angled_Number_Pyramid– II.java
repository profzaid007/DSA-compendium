// Input Format: N = 6
// Result:
// 1
// 2 2
// 3 3 3
// 4 4 4 4
// 5 5 5 5 5
// 6 6 6 6 6 6
import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=1;i<=t;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		
		System.out.println();
	}
}