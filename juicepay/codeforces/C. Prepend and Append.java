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
        String s = scanner.next();
        while (s.length() > 0) {
            char f = s.charAt(0);
            char e = s.charAt(s.length() - 1);
            if ((f == '0' && e == '1' && f != e) || (f == '1' && e == '0' && f != e)) {
                s = s.substring(1, s.length() - 1);
            } else {
                break;
            }
        }
        System.out.println(s.length());
    }
}
