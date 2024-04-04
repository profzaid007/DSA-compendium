// Input Format: N = 6
// Result:
// 1 2 3 4 5 6
// 1 2 3 4 5
// 1 2 3 4
// 1 2 3
// 1 2 
// 1
import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=t;i>0;i--){
			for(int j=1;j<=i;j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
}