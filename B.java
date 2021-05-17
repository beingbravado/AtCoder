// import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Integer[] dp = new Integer[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i-j>0) {
                    dp[i]= Math.min(dp[i], dp[i-j]+ Math.abs(a[i-1]- a[i-j-1]));
                } else {
                    dp[i] = Math.min(dp[i], Math.abs(a[i - 1] - a[0]));
                    break;
                }
            }
        }
        System.out.println(dp[n]);
        scan.close();
    }
}
