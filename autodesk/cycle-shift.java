import java.util.*;

public class Main {
    public static boolean isCyclic(String a, String b) {
        if (a.length() != b.length())
            return false;
        a += a;
        // System.out.println(a);
        if (a.indexOf(b) != -1)
            return true;
        return false;
    }

    public static int solve(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isCyclic(Integer.toString(arr[i]), Integer.toString(arr[j])) == true) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr, n));
        sc.close();
    }

}