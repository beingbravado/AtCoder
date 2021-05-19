import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] a = scan.next().trim().toCharArray();
        char[] b = scan.next().trim().toCharArray();
        int na = a.length, nb = b.length;
        int[][] dp = new int[na + 1][nb + 1];

        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (a[i - 1] == b[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                // System.out.print(dp[i][j]);
            }
            // System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        int x = na, y = nb;
        while (x > 0 && y > 0) {
            if (a[x - 1] == b[y - 1]) {
                sb.append(a[x - 1]);
                x--;
                y--;
            } else if (dp[x][y - 1] > dp[x - 1][y]) {
                y--;
            } else {
                x--;
            }
        }

        System.out.println(sb.reverse().toString());

        scan.close();
    }
}
