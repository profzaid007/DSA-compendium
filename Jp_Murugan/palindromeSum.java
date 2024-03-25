import java.util.*;

class Main {
	public static long revdigs(long num) {
		long rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		return rev;
	}

	public static boolean isPal(long num) {
		return (revdigs(num) == num);
	}

	public static void rev(long num) {
		long rev = 0;
		while (num <= 4294967295l) {
			rev = revdigs(num);
			num = num + rev;
			if (isPal(num)) {
				System.out.println(num);
				break;
			} else if (num > 4294967295l) {
				System.out.println("Not Possible Beta");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		rev(t);
		
	}
}
