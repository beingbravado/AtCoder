import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= 3)
                dp[i] = Math.min(dp[i - 2] + Math.abs(a[i - 1] - a[i - 3]), dp[i - 1] + Math.abs(a[i - 1] - a[i - 2]));
            else if (i == 2)
                dp[i] = Math.abs(a[i - 1] - a[i - 2]);
            else
                dp[i] = 0;
        }
        System.out.println(dp[n]);
        scan.close();
    }
}
