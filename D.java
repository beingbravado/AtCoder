import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s0 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s0[0]);
        int weight = Integer.parseInt(s0[1]);
        Integer[] w = new Integer[n];
        Integer[] v = new Integer[n];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().trim().split(" ");
            w[i] = Integer.parseInt(s1[0]);
            v[i] = Integer.parseInt(s1[1]);
        }
        long[][] dp = new long[n + 1][weight + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (w[i - 1] <= weight && j>= w[i-1]) {
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i-1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(dp[n][weight]);
    }
}
