import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] great = new int[n];
        int[] less = new int[n];
        Arrays.fill(great,-1);
        Arrays.fill(less,-1);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[i]){
                    if(great[i]==-1){
                        great[i] =  j;
                    }
                }
                if(arr[j] < arr[i]){
                    if(less[i] == -1){
                        less[i] = j;
                    }
                }
                if(great[i]!=-1 && less[i]!=-1){
                    break;
                }
            }
        }
        int s = 0;
        for(int i=0; i<n; i++){
            if(great[i] != -1 && less[great[i]] != -1){
                s += 5;
            }else if(great[i] != -1 && less[great[i]] == -1){
                s += 10;
            }else if(great[i] == -1){
                s += 15;
            }
        }
        System.out.println(s);
    }
}