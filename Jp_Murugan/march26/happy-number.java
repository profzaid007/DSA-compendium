import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Set<Integer> set = new HashSet<>();
		
		while(n!=1 && !set.contains(n)){
			set.add(n);
			int sum =0;
			
			while(n!=0){
				int digit  = n%10;
				sum+=digit*digit;
				n=n/10;
			}
			n=sum;
		}
		System.out.println(n==1);
	}
}