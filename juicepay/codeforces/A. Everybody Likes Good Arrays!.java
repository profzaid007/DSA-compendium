import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int last = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            if (i == 0) {
                last = x & 1;
                continue;
            }
            if ((last + x) % 2 == 0)
                ans++;
            last = x & 1;
        }
        System.out.println(ans);
    }
}
