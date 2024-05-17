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
        int[] v = new int[n];
        for (int i = 0; i < n; ++i) {
            v[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(v[i], v[j]) <= 2) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
