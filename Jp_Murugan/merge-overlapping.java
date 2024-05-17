import java.util.*;

class Interval{
	int start, end;
	Interval(int start,int end){
		this.start = start;
		this.end = end;
	}
}

class Main{
	
	public static int merge(Interval[] arr){
		Arrays.sort(arr,new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		
		int index = 0;
		for(int i =1;i< arr.length;i++){
			if(arr[index].end >= arr[i].start){
				arr[index].end = Math.max(arr[index].end,arr[i].end);
			}else{
				index++;
				arr[index] = arr[i];
			}
		}
		return index;
		
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// int m = sc.nextInt();
		
		
		Interval[] arr = new Interval[n];
		for(int i=0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i]= new Interval(a,b);
		}
		int index = merge(arr);
		for(int i=0;i<=index;i++){
			System.out.print("["+arr[i].start+","+arr[i].end+"]\n");
		}
	}
	
}
