import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        while (t-- > 0) {
            solve(sc.nextLine());
        }
        sc.close();
    }

    static void solve(String n) {
        System.out.println(9 * (n.length() - 1) + Character.getNumericValue(n.charAt(0)));
    }
}