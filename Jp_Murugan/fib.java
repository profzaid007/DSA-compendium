import java.util.*;

class Main {
    static final long M = 1000000007;
    static Map<Long, Long> F = new HashMap<>();

    static long f(long n) {
        if (F.containsKey(n)) return F.get(n);
        long k = n / 2;
        if (n % 2 == 0) { 
            long result = (f(k) * f(k) + f(k - 1) * f(k - 1)) % M;
            F.put(n, result);
            return result;
        } else { 
            long result = (f(k) * f(k + 1) + f(k - 1) * f(k)) % M;
            F.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F.put(0L, 1L);
        F.put(1L, 1L);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            System.out.println((n == 0 ? 0 : f(n - 1)));
        }
    }
}
