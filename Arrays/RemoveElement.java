import java.util.*;

class Main{
	
	
	public static int[] delete(int[] arr,int pos){
		if(pos<0||pos>arr.length){
			throw new ArrayIndexOutOfBoundsException();
			
		}else{
			for(int i=pos;i<arr.length-1;i++){
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=0;
			return arr;
		}
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] arr = new int[10];
		int t = 2;
		for(int i=0;i<10;i++){
			arr[i]=t;
			t+=2;
		}
		arr = delete(arr,5);
		for(int i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
