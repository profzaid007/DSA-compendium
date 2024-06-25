/*
rotate a matrix by 90 degree clockwise

brute force is to use anoher copy matrix 

optimized is to transpose the matrix and reverse the elements in the row
while tranposing the diagnal remains the same and the rest elements are swapped from i->j and j->i
*/

import java.util.*;

public class Main{
	
	
	public static void rotateBrute(int[][] matrix){
		int n = matrix.length;
		
		int[][] res = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				res[j][(n-1)-i] = matrix[i][j];
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
	} 
	
	public static void rotateOptimized(int[][] matrix){
		int n = matrix.length;
		
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				int temp = matrix[i][j];
				matrix[i][j] =matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i=0;i<n;i++){
			int low =0;
			int high = n-1;
			while(low <high){
				int temp = matrix[i][low];
				matrix[i][low] = matrix[i][high];
				matrix[i][high] = temp;
				low++;
				high--;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] matrix = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=sc.nextInt();
			}
		}
		rotateOptimized(matrix);
		
		System.out.println();
	}
}