/*
observation:
find the breakpoint an store the index kind of like peak element
then swap it with the next greatest pivot element
then reverse the rest of the array
*/

import java.util.*;

public class Main{
	
	public static void nextPermutation(int[] nums) {
        int flag =-1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                flag = i;
                break;
            }
        }
        if(flag==-1){
            Arrays.sort(nums);
        }
        else{

            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[flag]){
                    int temp = nums[i];
                    nums[i] = nums[flag];
                    nums[flag] = temp;
                    break;
                }
            }
            int low = flag +1;
            int high  = n-1;
            while(low<high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
    }
 	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			nextPermutation(arr);
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
	}
}