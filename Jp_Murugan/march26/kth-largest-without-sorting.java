import java.util.*;

class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		PriorityQueue<Integer> data = new PriorityQueue<>(k + 1);
		
		for(int i : arr){
			data.add(i);
			if(data.size()>k){
				data.poll();
			}
		}
		
		System.out.println(data.poll());
	}
}