import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
            }

            boolean found = false;
            for (int element : v) {
                if (element == k) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        scanner.close();
    }
}
