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
        int m = scanner.nextInt();
        String x = scanner.next();
        String s = scanner.next();
        int ct = 0;
        for (int i = 0; i <= 10; ++i) {
            if (x.contains(s)) {
                System.out.println(i);
                return;
            }
            x += x;
        }
        System.out.println(-1);
    }
}
