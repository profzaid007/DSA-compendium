import java.util.ArrayList;
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
        ArrayList<Integer> v = new ArrayList<>();
        int ct = 0;
        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt();
            v.add(x);
            if (x == 2)
                ct++;
        }
        if (ct == 0)
            System.out.println(1);
        else if ((ct & 1) == 1)
            System.out.println(-1);
        else {
            ct /= 2;
            int x = 0;
            for (int i = 0; i < n; ++i) {
                if (v.get(i) == 2)
                    x++;
                if (x == ct) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
