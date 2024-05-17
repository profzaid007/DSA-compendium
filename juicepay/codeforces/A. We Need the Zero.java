import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        while (TC-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt();
            ans ^= x;
        }
        if (ans == 0 || (n & 1) == 1)
            System.out.println(ans);
        else
            System.out.println(-1);
    }
}
