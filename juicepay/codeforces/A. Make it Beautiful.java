import java.util.Arrays;
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
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        Arrays.sort(v);
        if (v[0] == v[n - 1])
            System.out.println("no");
        else {
            System.out.println("yes");
            System.out.print(v[n - 1] + " ");
            for (int i = 0; i < n - 1; i++)
                System.out.print(v[i] + " ");
            System.out.println();
        }
    }
}