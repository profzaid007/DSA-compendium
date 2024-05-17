import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findCell(arr, a, b));
    }

    public static int findCell(int[] arr, int a, int b) {
        int n = arr.length;
        int temp = -1;
        boolean[] visited = new boolean[n];
        while (a != -1 && b != -1) {
            if (visited[a]) {
                temp = a;
                break;
            } else if (visited[b]) {
                temp = b;
                break;
            }
            visited[a] = true;
            visited[b] = true;
            a = arr[a];
            b = arr[b];
        }
        return temp;
    }
}
